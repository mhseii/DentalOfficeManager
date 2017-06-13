function selectPatient(element) {
	
	$.ajax({
		method: "GET",
		url: "view_patient",
		data: "id=" + element.id
	}).done(function(data){
		window.location.href = 'view_patient?id=' + element.id;
	});
	
};