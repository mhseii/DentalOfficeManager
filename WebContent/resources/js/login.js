$(function(){
	
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	
	$("#login-form").submit(function(e){
		e.preventDefault();
		var form = $(this).serializeArray();
		var jsonForm = {};
		$(form).each(function(index, data) {
			jsonForm[data.name] = data.value;
		});
		
		$.ajax({
			type: "POST",
			url: "sign_in",
			data: JSON.stringify(jsonForm),
			dataType: "JSON",
			contentType: "application/json; charset=utf-8",
			beforeSend: function (xhr) {
				xhr.setRequestHeader(header, token);
			},
		}).done(function(data){
			if(data.success) {
				window.location.href = data.redirectURL;
			} else {
				alert("invalid password and/or username!");
			}
		});
	});
});