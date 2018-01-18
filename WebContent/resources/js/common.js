$(function () {

	var header = $("meta[name='_csrf_header']").attr("content");
	var token = $("meta[name='_csrf']").attr("content");

	$("input[type=submit],input[type=button],a,button").button();

	$("#searchPatient").autocomplete({
		minLength: 3,
		delay: 500,
		source: function (request, response) {
			$.ajax({
				type: "GET",
				url: "/DentalOfficeManager/patient/search",
				dataType: "JSON",
				data: request,
				beforeSend: function (xhr) {
					xhr.setRequestHeader(header, token);
				}
			}).done(function (result) {
				response($.map(result, function (item) {
					return {
						label: item.firstName + " " + item.lastName,
						value: item.id
					}
				}));
			});
		},
		select: function (event, ui) {
			if (ui.item) {
				$(this).val(ui.item.label);
				var url = '/DentalOfficeManager/patient/view?id=' + ui.item.value;
				changePage(url, header, token);
				return false;
			}
		}
	});

	$(".datepicker").datepicker({
		autoSize: true,
		showAnim: "drop",
		dateFormat: "dd/mm/yy",
		changeMonth: true,
		changeYear: true,
		yearRange: "-80:+0"
	}).each(function () {
		$(this).attr('size', $(this).attr('placeholder').length);
	});

	$(".datepicker").blur(validateDateOfBirth);
	$(".datepicker").keypress(formatDateOfBirth);

	$(".phone-number").on('copy paste', preventCopyPaste);
	$(".phone-number").blur(validatePhoneNumber);
	$(".phone-number").keydown(preventNavigationKeys);
	$(".phone-number").keypress(formatPhoneNumber);

	$(".mobile-number").on('copy paste', preventCopyPaste);
	$(".mobile-number").blur(validateMobileNumber);
	$(".mobile-number").keydown(preventNavigationKeys);
	$(".mobile-number").keypress(formatMobileNumber);

	$(".ssn").attr("disabled", true);
	$("input[type=radio][name=ssnType]").on("click", function () {
		if ($("input[type=radio][name=ssnType]:checked").length > 0) {
			$(".ssn").removeAttr("disabled");
		}
	});

	$(".ssn").on('copy paste', preventCopyPaste);
	$(".ssn").blur(validateSSN);
	$(".ssn").keydown(preventNavigationKeys);
	$(".ssn").keypress(formatSSN);

	function formatDateOfBirth(e) {
		var $dateOfBirth = $(this);
		var key = e.which || e.charCode || e.keyCode || 0;

		if (key !== 8 && key !== 9) {
			if ($dateOfBirth.val().length == 2 || $dateOfBirth.val().length == 5) {
				$dateOfBirth.val($dateOfBirth.val() + '/');
			}
		}
	}

	function formatPhoneNumber(e) {
		var $phoneNumber = $(this);
		var key = e.which || e.charCode || e.keyCode || 0;

		if (key !== 8 && key !== 9) {
			if ($phoneNumber.val().length === 0) {
				$phoneNumber.val($phoneNumber.val() + '(');
			} else if ($phoneNumber.val().length === 3) {
				$phoneNumber.val($phoneNumber.val() + ') ');
			} else if ($phoneNumber.val().length === 9) {
				$phoneNumber.val($phoneNumber.val() + '-');
			}
		}

		if (!/8|4[8-9]|5[0-7]/g.test(key) || $phoneNumber.val().length > 14) {
			return false;
		}
	};

	function formatMobileNumber(e) {
		var $mobileNumber = $(this);
		var key = e.which || e.charCode || e.keyCode || 0;

		if (key !== 8 && key !== 9) {
			if ($mobileNumber.val().length === 0) {
				$mobileNumber.val($mobileNumber.val() + '(');
			} else if ($mobileNumber.val().length === 3) {
				$mobileNumber.val($mobileNumber.val() + ') ');
			} else if ($mobileNumber.val().length === 6 || $mobileNumber.val().length === 11) {
				$mobileNumber.val($mobileNumber.val() + '-');
			}
		}

		if (!/8|4[8-9]|5[0-7]/g.test(key) || $mobileNumber.val().length > 16) {
			return false;
		}
	};

	function formatSSN(e) {
		var $ssn = $(this);
		var ssnType = $("input[type=radio][name=ssnType]:checked")[0].value;
		var key = e.which || e.charCode || e.keyCode || 0;

		switch (ssnType) {
			case "CPF": formatCpf($ssn, key);
				break;
			case "CNPJ": formatCnpj($ssn, key);
				break;
			case "RG": formatRG($ssn, key);
				break;
		}
	};
	
	function formatCpf($ssn, key) {
		if (key !== 8 && key !== 9) {
			if ($ssn.val().length === 3 || $ssn.val().length === 7) {
				$ssn.val($ssn.val() + '.');
			} else if ($ssn.val().length === 11) {
				$ssn.val($ssn.val() + '-');
			}
		}

		if (!/8|4[8-9]|5[0-7]/g.test(key) || ($ssn.val().length > 13 && key !== 8)) {
			return false;
		}
	};
	
	function formatCnpj($ssn, key) {
		if (key !== 8 && key !== 9) {
			if ($ssn.val().length === 2 || $ssn.val().length === 6) {
				$ssn.val($ssn.val() + '.');
			} else if ($ssn.val().length === 10) {
				$ssn.val($ssn.val() + '/');
			} else if ($ssn.val().length === 15) {
				$ssn.val($ssn.val() + '-');
			}
		}
		
		if (!/8|4[8-9]|5[0-7]/g.test(key) || ($ssn.val().length > 17 && key !== 8)) {
			return false;
		}
	};
	
	function formatRG($ssn, key) {
		if (key !== 8 && key !== 9) {
			if ($ssn.val().length === 2 || $ssn.val().length === 6) {
				$ssn.val($ssn.val() + '.');
			} else if ($ssn.val().length === 10) {
				$ssn.val($ssn.val() + '-');
			}
		}

		if (!/8|4[8-9]|5[0-7]|120/g.test(key) || ($ssn.val().length > 11 && key !== 8)) {
			return false;
		}
	};

	function validateDateOfBirth() {
		$(this).removeClass("error");

		var $dateOfBirth = $(this);
		var regexp = /[0-9]{2}\/[0-9]{2}\/[0-9]{4}/g;
		if (!regexp.test($dateOfBirth.val())) {
			$(this).addClass("error");
		}
	};

	function validatePhoneNumber() {
		$(this).removeClass("error");

		var $phoneNumber = $(this);
		var regexp = new RegExp(/\([0-9]{2}\)\s[0-9]{4}-[0-9]{4}/g);
		if (!regexp.test($phoneNumber.val())) {
			$(this).addClass("error");
		}
	};

	function validateMobileNumber() {
		$(this).removeClass("error");

		var $phoneNumber = $(this);
		var regexp = /\([0-9]{2}\)\s([0-9]{1}-[0-9]{4}|[0-9]{4})-([0-9]{4})/g;

		if ($phoneNumber.val().length > 14) {
			if ($phoneNumber.val().replace(/[^0-9]/g, '').length === 10) {
				$phoneNumber.val($phoneNumber.val().replace(/-/g, '').substring(0, 9)
					+ '-' + $phoneNumber.val().replace(/-/g, '').substring(9));
			} else {
				$phoneNumber.val($phoneNumber.val().replace(/-/g, '').substring(0, 6)
					+ '-' + $phoneNumber.val().replace(/-/g, '').substring(6, 10)
					+ '-' + $phoneNumber.val().replace(/-/g, '').substring(10));
			}
		}

		if (!regexp.test($phoneNumber.val())) {
			$(this).addClass("error");
		}
	};

	function validateSSN() {
		$(this).removeClass("error");
		var ssnType = $("input[type=radio][name=ssnType]:checked")[0].value;
		var $ssn = $(this);
		if (ssnType === "CPF") {
			var regExp = /[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}/g;
			var calculatedSSN = $ssn.val().replace(/\D/g, '').substring(0, $ssn.val().replace(/\D/g, '').length - 2);

			if ($ssn.val().match(regExp)) {
				var multiple = 10;
				calculatedSSN += getCPFDigits(multiple, calculatedSSN);
				multiple = 11;
				calculatedSSN += getCPFDigits(multiple, calculatedSSN);
			}

			if ($ssn.val().replace(/\D/g, '') !== calculatedSSN || $ssn.val().replace(/\D/g, '').length < 11) {
				$(this).addClass("error");
			}
		} else if (ssnType === "CNPJ") {
			var regExp = /[0-9]{2}.[0-9]{3}.[0-9]{3}\/[0-9]{4}-[0-9]{2}/g;
			var calculatedSSN = $ssn.val().replace(/\D/g, '').substring(0, $ssn.val().replace(/\D/g, '').length - 2);

			if ($ssn.val().match(regExp)) {
				calculatedSSN += getCNPJDigits(calculatedSSN);
				calculatedSSN += getCNPJDigits(calculatedSSN);
			}

			if ($ssn.val().replace(/\D/g, '') !== calculatedSSN || $ssn.val().replace(/\D/g, '').length < 14) {
				$(this).addClass("error");
			}
		} else {
			var regExp = /[0-9]{2}.[0-9]{3}.[0-9]{3}-([0-9]{1}|x)/g;
			var calculatedSSN = $ssn.val().replace(/[^0-9]|^x/g, '').substring(0, $ssn.val().replace(/[^0-9]|^x/g, '').length - 1);

			if ($ssn.val().match(regExp)) {
				calculatedSSN += getRGDigits(calculatedSSN);
			}

			if ($ssn.val().replace(/[^0-9]|^x/g, '') !== calculatedSSN || $ssn.val().replace(/[^0-9]|^x/g, '').length < 9) {
				$(this).addClass("error");
			}
		}
	};

	function getCPFDigits(multiple, calculatedSSN) {

		var digit = 0;
		for (var i = 0, j = multiple; i < calculatedSSN.length; i++ , j--) {
			digit += calculatedSSN[i] * j;
		}
		digit = digit % 11;
		if (digit === 0 || digit === 1) {
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
		for (var i = 0; i < calculatedSSN.length; i++) {
			if (mult > 9) {
				mult = 2;
			}
			digit += calculatedSSN.substring(calculatedSSN.length - (i + 1), calculatedSSN.length - i) * mult;
			mult++;
		}

		if (digit % 11 > 2) {
			digit = 11 - (digit % 11);
		} else {
			digit = 0;
		}
		return digit;
	};

	function getRGDigits(calculatedSSN) {
		var digit = 0;
		for (var i = 0, j = 1; i < calculatedSSN.length; i++ , j++) {
			digit += calculatedSSN.substring(i, j) * i;
		}

		if (digit % 11 < 10) {
			digit = 11 - (digit % 11);
		} else if (digit % 11 === 10) {
			digit = x;
		}
		return digit;
	}

	function preventNavigationKeys(e) {
		var key = e.which || e.charCode || e.keyCode || 0;
		var regexp = /3[6-9]/g;
		if (regexp.test(key)) {
			return false;
		}
	}

	function preventCopyPaste(e) {
		e.preventDefault();
		return false;
	}

});

function changePage(url, header, token) {
	if (!header) {
		header = getHeader();
	}
	if (!token) {
		token = getToken();
	}

	$.ajax({
		type: "GET",
		url: url,
		beforeSend: function (xhr) {
			xhr.setRequestHeader(header, token);
		}
	}).done(function () {
		window.location.href = url;
	}).fail(function () {
		window.location = 'login';
	});
};

function getHeader() {
	return $("meta[name='_csrf_header']").attr("content");
}

function getToken() {
	return $("meta[name='_csrf']").attr("content");
}