$(document).ready(function() {
	$("#searchPatient").click(searchPatient);
	
});

function searchPatient() {
	$.ajax({
		type : 'POST',
		url : 'select_patient',
		contentType : 'application/json',
		dataType : "json",
		data : $("#patientName").val(),
		done : function(data) {
			if (data.success === true) {
				// console.log(data);
				$.each(data.patient, function(index) {
					// console.log(novopatient[index]);

				});
			}
		}
	});
};

