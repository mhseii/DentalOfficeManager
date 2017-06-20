$(function(){
	
	$("input[name=firstName]").keypress(function(e){
		var key = e.which || e.charCode || e.keyCode || 0;
		console.log(key);
	});
	
	$("#phone-number").on('copy paste', preventCopyPaste);
	$("#phone-number").blur(validatePhoneNumber);
	$("#phone-number").keydown(preventNavigationKeys);
	$("#phone-number").keypress(formatPhoneNumber);
	
	$("#mobile-number").on('copy paste', preventCopyPaste);
	$("#mobile-number").blur(validateMobileNumber);
	$("#mobile-number").keydown(preventNavigationKeys);
	$("#mobile-number").keypress(formatMobileNumber);
	
	$("#patient-ssn").attr("disabled", true);
	$("input[type=radio][name=ssnType]").on("click", function() {
		if($("input[type=radio][name=ssnType]:checked").length > 0){
			$("#patient-ssn").removeAttr("disabled");
		}
	});
	
	$("#patient-ssn").on('copy paste', preventCopyPaste);
	$("#patient-ssn").blur(validateSSN);
	$("#patient-ssn").keydown(preventNavigationKeys);
	$("#patient-ssn").keypress(formatSSN);
	
	$("#registration-form").submit(function(e) {
		e.preventDefault();
		var form = $(this).serializeArray();
		var jsonForm = {};
		$(form).each(function(index, data) {
			jsonForm[data.name] = data.value;
		});
		
		$.ajax({
			type: "POST",
			data: JSON.stringify(jsonForm),
			contentType: "application/json; charset=utf-8",
			url: "registration_form",
		}).done(function(data){
			if(data.success) {
				window.location.href = data.redirectURL;
			} else {
				alert("registration failed!");
			}
		});
	});

	
	function formatPhoneNumber(e) {
		var $phoneNumber = $(this);
		var key = e.which || e.charCode || e.keyCode || 0;
		
		if(key !== 8 && key !==9) {
			if($phoneNumber.val().length === 0) {
				$phoneNumber.val( $phoneNumber.val() + '(');
			} else if($phoneNumber.val().length === 3) {
				$phoneNumber.val( $phoneNumber.val() + ') ' );
			} else if($phoneNumber.val().length === 9) {
				$phoneNumber.val( $phoneNumber.val() + '-' );
			}
		}
			
		if (!/8|4[8-9]|5[0-7]/g.test(key) || $phoneNumber.val().length > 13) {
			return false;
		}
	};
	
	function formatMobileNumber(e) {
		var $mobileNumber = $(this);
		var key = e.which || e.charCode || e.keyCode || 0;
		
		if(key !== 8 && key !==9) {
			if($mobileNumber.val().length === 0) {
				$mobileNumber.val( $mobileNumber.val() + '(');
			} else if($mobileNumber.val().length === 3) {
				$mobileNumber.val( $mobileNumber.val() + ') ' );
			} else if($mobileNumber.val().length === 6 || $mobileNumber.val().length === 11) {
				$mobileNumber.val( $mobileNumber.val() + '-' );
			}
		}
		
		if (!/8|4[8-9]|5[0-7]/g.test(key) || $mobileNumber.val().length >= 16) {
			return false;
		}
	};
	
	function formatSSN(e) {
		var $ssn = $(this);
		var ssnType = $("input[type=radio][name=ssnType]:checked")[0].value;
		var key = e.which || e.charCode || e.keyCode || 0;
		
		if(ssnType === "CPF"){
			if (key !== 8 && key !== 9) {
				if($ssn.val().length === 3 || $ssn.val().length === 7) {
					$ssn.val($ssn.val() + '.');
				} else if($ssn.val().length === 11) {
					$ssn.val($ssn.val() + '-');
				}
			}
			
			if (!/8|4[8-9]|5[0-7]/g.test(key) || $ssn.val().length > 13) {
				return false;
			}
		} else if(ssnType === "CNPJ"){
			if (key !== 8 && key !== 9) {
				if($ssn.val().length === 2 || $ssn.val().length === 6) {
					$ssn.val($ssn.val() + '.');
				} else if($ssn.val().length === 10) {
					$ssn.val($ssn.val() + '/');
				} else if($ssn.val().length === 15) {
					$ssn.val($ssn.val() + '-');
				}
			}
			
			if (!/8|4[8-9]|5[0-7]/g.test(key)|| $ssn.val().length > 17) {
				return false;
			}
		} else {
			if (key !== 8 && key !== 9) {
				if($ssn.val().length === 2 || $ssn.val().length === 6) {
					$ssn.val($ssn.val() + '.');
				} else if($ssn.val().length === 10) {
					$ssn.val($ssn.val() + '-');
				}
			}
			
			if (!/8|4[8-9]|5[0-7]|120/g.test(key) || $ssn.val().length > 11) {
				return false;
			}
		}
		
	};
	
	function validatePhoneNumber() {
		$(this).removeClass("error");
		
		var $phoneNumber = $(this);
		var regexp = /\([0-9]{2}\)\s[0-9]{4}-[0-9]{4}/g;
		if( $phoneNumber.val().match(regexp) === null || $phoneNumber.val().match(regexp)[0] !== $phoneNumber.val()) {
			$(this).addClass("error");
		}
	};
	
	function validateMobileNumber() {
		$(this).removeClass("error");
		
		var $phoneNumber = $(this);
		var regexp = /\([0-9]{2}\)\s([0-9]{1}-[0-9]{4}|[0-9]{4})-([0-9]{4})/g;

		if($phoneNumber.val().length > 14) {
			if($phoneNumber.val().replace(/[^0-9]/g,'').length === 10) {
				$phoneNumber.val($phoneNumber.val().replace(/-/g,'').substring(0,9) 
						+ '-' + $phoneNumber.val().replace(/-/g,'').substring(9));
			} else {
				$phoneNumber.val($phoneNumber.val().replace(/-/g,'').substring(0,6) 
						+ '-' + $phoneNumber.val().replace(/-/g,'').substring(6, 10) 
						+ '-' + $phoneNumber.val().replace(/-/g,'').substring(10));
			}
		} 
		
		if($phoneNumber.val().match(regexp) === null || $phoneNumber.val().match(regexp)[0] !== $phoneNumber.val()) {
			$(this).addClass("error");
		}
	};
	
	function validateSSN() {
		$(this).removeClass("error");
		var ssnType = $("input[type=radio][name=ssnType]:checked")[0].value;
		var $ssn = $(this);
		if(ssnType === "CPF"){
			var regExp = /[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}/g;
			var calculatedSSN = $ssn.val().replace(/\D/g,'').substring(0, $ssn.val().replace(/\D/g,'').length-2);
			
			if($ssn.val().match(regExp)) {
				var multiple = 10;
				calculatedSSN += getCPFDigits(multiple, calculatedSSN);
				multiple = 11;
				calculatedSSN += getCPFDigits(multiple, calculatedSSN);
			}
			
			if($ssn.val().replace(/\D/g,'') !== calculatedSSN || $ssn.val().replace(/\D/g,'').length < 11) {
				$(this).addClass("error");
			}
		} else if(ssnType === "CNPJ") {
			var regExp = /[0-9]{2}.[0-9]{3}.[0-9]{3}\/[0-9]{4}-[0-9]{2}/g;
			var calculatedSSN = $ssn.val().replace(/\D/g,'').substring(0, $ssn.val().replace(/\D/g,'').length-2);
			
			if($ssn.val().match(regExp)){
				calculatedSSN += getCNPJDigits(calculatedSSN);
				calculatedSSN += getCNPJDigits(calculatedSSN);
			}
			
			if($ssn.val().replace(/\D/g,'') !== calculatedSSN || $ssn.val().replace(/\D/g,'').length < 14) {
				$(this).addClass("error");
			}
		} else {
			var regExp = /[0-9]{2}.[0-9]{3}.[0-9]{3}-([0-9]{1}|x)/g;
			var calculatedSSN = $ssn.val().replace(/[^0-9]|^x/g,'').substring(0, $ssn.val().replace(/[^0-9]|^x/g,'').length-1);
			
			if($ssn.val().match(regExp)) {
				calculatedSSN += getRGDigits(calculatedSSN);
			}
			
			if($ssn.val().replace(/[^0-9]|^x/g,'') !== calculatedSSN || $ssn.val().replace(/[^0-9]|^x/g,'').length < 9) {
				$(this).addClass("error");
			}
		}
	};
	
	function getCPFDigits(multiple, calculatedSSN) {
		
		var digit = 0;
		for(var i=0, j=multiple; i < calculatedSSN.length; i++, j--) {
			digit += calculatedSSN[i]*j;
		}
		digit = digit % 11;
		if(digit === 0 || digit === 1) {
			digit = 0;
		} else {
			digit = 11 - digit;
		}
		calculatedSSN += digit;
	
		return digit;
	};
	
	function getCNPJDigits(calculatedSSN) {
		var digit = 0;
		var mult = 2;
		for(var i=0; i < calculatedSSN.length; i++) {
			if(mult > 9){
				mult = 2;
			}
			digit += calculatedSSN.substring(calculatedSSN.length - ( i + 1), calculatedSSN.length - i) * mult;
			mult++;
		}
		
		if(digit % 11 > 2) {
			digit = 11 - (digit % 11);
		} else {
			digit = 0;
		}
		return digit;
	};
	
	function getRGDigits(calculatedSSN) {
		var digit = 0;
		for(var i=0, j=1; i < calculatedSSN.length; i++, j++) {
			digit += calculatedSSN.substring(i, j) * i;
		}
		
		if(digit % 11 < 10) {
			digit = 11 - (digit % 11);
		} else if(digit % 11 === 10) {
			digit = x;
		}
		return digit;
	};
	
	function preventNavigationKeys(e) {
		var key = e.which || e.charCode || e.keyCode || 0;
		if(key >= 35 && key <= 40) {
			return false;
		}
	};
	
	function preventCopyPaste(e) {
		e.preventDefault(); 
	    return false;
	};

});