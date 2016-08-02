$(function(){
	
	$("#patient-ssn").keypress(function(key) {
		//simply ignore input if it is not a digit
		if (key.charCode < 48 || key.charCode > 57) {
			return false;
		}
	});
	
	$("#patient-ssn").on("blur", patientSsnValidator($(this).val()));
	
});

function patientSsnValidator(ssn) {
	
    var firstSum = 0;
	var	secondSum = 0;
	var	firstDigit = 0; 
	var secondDigit = 0; 
	var cpfRegex = /[0-9]{11}/;
	
	var i;
			
	var cpf = ssn;
	
	if(cpf != "") {
		if (cpf.match(cpfRegex)) {
			
				for(i=10;  i > 3; i--) {
					firstSum = firstSum + parseInt(cpf.charAt(i)*i);
					secondSum = secondSum + parseInt(cpf.charAt(i)*(i+1));
				}
				console.log(firstSum);
				console.log(secondSum);
				
				firstDigit = calculateSsnDigit(firstSum);
				console.log(firstDigit);
				secondSum = secondSum + (firstDigit*2);
				secondDigit = calculateSsnDigit(secondSum);
				console.log(secondDigit);
				
				if (parseInt(cpf.charAt(9)) != firstDigit || parseInt(cpf.charAt(10)) != secondDigit){
					console.log(cpf.charAt(9) + cpf.charAt(10) + "cpf invalido!");
					return false;
				}
		} else {
			console.log("cpf is in wrong format!");
		}
	}
}

function calculateSsnDigit(sum) {
	var remainder = sum % 11;
	var digit = 11 - remainder;
	if (digit > 9) {
		digit = 0;
	}
	return digit;
}