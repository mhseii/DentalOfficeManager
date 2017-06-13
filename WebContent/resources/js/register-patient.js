$(function(){
	
	$("#patient-ssn").keypress(function(e) {
		
		var $ssn = $(this);
		var key = e.which || e.charCode || e.keyCode || 0;
		
		if (key !== 8 && key !== 9) {
			if($ssn.val().length === 3 || $ssn.val().length === 7) {
				$ssn.val($ssn.val() + '.');
			} else if($ssn.val().length === 11) {
				$ssn.val($ssn.val() + '-');
			}
		}

		if (key < 48 || key > 57 || key == 8 || $ssn.val().length > 13) {
			return false;
		}
		
	}).blur(function() {
		
		$(this).removeClass("error");
		
		var $ssn = $(this);
		var regExp = /[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}/;
		var firstSum = 0, secondSum = 0, calculatedSSN = $ssn.val().replace(/\D/g,'').substring(0,9);
		
		if($ssn.val().match(regExp)) {
			for(var i=0, j=10; i < calculatedSSN.length; i++, j--) {
				firstSum += calculatedSSN[i]*j;
			}
			firstSum = firstSum % 11;
			if(firstSum === 0 || firstSum === 1) {
				firstSum = 0;
			} else {
				firstSum = 11 - firstSum;
			}
			calculatedSSN += firstSum;
			
			for(var i=0, j=11; i < calculatedSSN.length; i++, j--) {
				secondSum += calculatedSSN[i]*j; 
			}
			
			secondSum = secondSum % 11;
			if(secondSum === 0 || secondSum === 1) {
				secondSum = 0;
			} else {
				secondSum = 11 - secondSum;
			}
			calculatedSSN += secondSum;
		}
		
		if($ssn.val().replace(/\D/g,'') != calculatedSSN) {
			$(this).addClass("error");
		}
	});

});