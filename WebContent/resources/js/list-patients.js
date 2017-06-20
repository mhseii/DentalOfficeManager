function selectPatient(element) {
	
	$.ajax({
		method: "GET",
		url: "view",
		data: "id=" + element.id
	}).done(function(data){
		window.location.href = 'view?id=' + element.id;
	});
	
};