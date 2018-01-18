$(function() {
	
	$("#confirmation-dialog").dialog({
		modal: true, autoOpen: false, draggable: false, resizable: false, height: 200, width: 400,
		title: $('#dialog-title').val()
	});
	
	$('#button-confirm').text($("#dialog-confirm").val());
	$('#button-confirm').on('click', function() {
		$.when(submitUpdate()).done(closeDialog);
	});
	
	$('#button-cancel').text($("#dialog-cancel").val());
	$('#button-cancel').on('click', closeDialog);
	
	$('#dialog-message').text($('#dialog-span-message').val());
	
	$("#edit").on('click', editDetails);
	$("#update").on('click', function() {
		if($('#isEditing').val() === "true") {
			$("#confirmation-dialog").dialog("open");
		}
	});
	
});

function editDetails() {
	$('#isEditing').val(true);
	$("span.editable").each(function(){ 
		var $input = $('<input>', { val: $(this).text(), type: 'text', name: $(this)[0].id }); 
		$input.attr('class', 'patient-info editable');
		$(this).replaceWith($input); 
	});
};

function updateDetails() {
	$("input.editable").each(function(){
		var $span = $('<span />', { text: $(this).val(), id: $(this)[0].name });
		$span.attr('class', 'patient-info editable');
		$(this).replaceWith($span);
	}).promise().when;
};

function closeDialog() {
	$("#confirmation-dialog").dialog("close");
	$('#isEditing').val(false);
	updateDetails();
};

function submitUpdate() {
	
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	
	var form = $('#patient-udpate-form').serializeArray();
	var formJSON =  {};
	$(form).each(function(index, data) {
		formJSON[data.name] = data.value;
	});
	
	$.ajax({
		method: "PUT",
		url: "/DentalOfficeManager/patient/update",
		contentType: "application/json; charset=utf-8",
		data: JSON.stringify(formJSON),
		beforeSend: function(xhr) {
			xhr.setRequestHeader(header, token);
		}
	}).done(closeDialog);
};
