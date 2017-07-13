$(function(){

	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	
	$("#registration-form").submit(function(e) {
		e.preventDefault();
		var form = $(this).serializeArray();
		var JSONForm = {};
		$(form).each(function(index, data) {
			if(data.type != 'checkbox') {
				JSONForm[data.name] = data.value;
			}
		});
		
		var checkBoxes = $("[type=checkbox]:checked").serializeArray();
		var JSONCheckBoxes = {};
		$(checkBoxes).each(function(index, data) {
			JSONCheckBoxes[index] = data.name;
		});
		
		JSONForm['userRoles'] = JSONCheckBoxes;
		
		$.ajax({
			type: "POST",
			url: "registration_form",
			contentType: "application/json; charset=utf-8",
			data: JSON.stringify(JSONForm),
			beforeSend: function(xhr) {
				xhr.setRequestHeader(header, token);
			},
		}).done(function(data){
			window.location.href = data.redirectURL;
		});
	});
	
	$.ajax({
		type: "GET",
		url: window.location.pathname.substring(0, window.location.pathname.indexOf("/",2)) + "/role/list",
		contentType: "application/json; charset=utf-8",
		beforeSend: function(xhr) {
			xhr.setRequestHeader(header, token);
		}
	}).done(function(data) {
		$.each(data, function(i, value) {
			$("#userRoles").append($("<label>").text(value.displayName).prepend(
				$("<input>").attr('id',value.id).attr('name', value.id).attr('type', 'checkbox').val(value.displayName)));
		});
	});
});