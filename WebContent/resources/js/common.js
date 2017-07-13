$(function() {
	
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	
	$("input[type=submit],a,button").button();
	
	$(".datepicker").datepicker({
		autoSize: true,
		showAnim : "drop",
		dateFormat : "dd/mm/yy",
		changeMonth : true,
		changeYear : true,
		yearRange: "-80:+0"
	}).each(function () {
        $(this).attr('size', $(this).attr('placeholder').length);
    });
	
	$("#searchPatient").autocomplete({
		minLength : 3,
		delay : 500,
		source : function(request, response) {
			$.ajax({
				type: "GET",
				url: "patient/search",
				dataType: "JSON",
				data: request,
				beforeSend: function(xhr) {
					xhr.setRequestHeader(header, token);
				}
			}).done(function(result) {		
				response($.map(result, function(item) {
					return {
						label : item.firstName + " " + item.lastName,
						value : item.id
					}
				}));
			});
		},
		select : function(event, ui) {
			if (ui.item) {
				$(this).val(ui.item.label);
				window.location.href = 'patient/view?id=' + ui.item.value;
				return false;
			}
		}
	});
});

function changePage(url) {
	
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	
	$.ajax({
		type: "GET",
		url: url,
		beforeSend: function(xhr) {
			console.log("header: " + header);
			console.log("token: " + token);
			xhr.setRequestHeader(header, token);
		}
	}).done(function(data, textStatus, jqXHR){
		window.location.href = url;
		var csrfToken = jqXHR.getResponseHeader('X-CSRF-TOKEN');
		if(csrfToken){
			console.log(csrfToken);
		}/* else {
			window.location = window.location.pathname.substring(0, window.location.pathname.indexOf("/",2)) + '/login';
		}*/
	}).fail(function(){
		window.location = 'login';
	});
};