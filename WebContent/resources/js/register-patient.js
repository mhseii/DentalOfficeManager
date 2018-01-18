$(function () {
	
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");

	$(".autofill-enabled").attr("disabled", true);
	
	$.ajax({
		method: "GET",
		url: "/DentalOfficeManager/retrieveCountryStates",
		contentType: "application/json; charset=utf-8",
		dataType: "json",
		beforeSend: function (xhr) {
			xhr.setRequestHeader(header, token);
		}
	}).done(function (data) {
		$.each(data, function (i, value) {
			$("#addressState").append($('<option>').text(value).attr('value', value));
		});
	});
	
	$("#addressZipCode").blur(function() {
		$.ajax({
			method: "GET",
			url: "/DentalOfficeManager/retrieveAddressData",
			contentType: "application/json; charset=utf-8",
			dataType: "json",
			data: 'zipCode=' + $(this).val(),
			beforeSend: function (xhr) {
				xhr.setRequestHeader(header, token);
			}
		}).done(function (data) {
			if(data.state){
				$('#addressState').val(data.state.abbreviation);
				$('#addressState').attr("disabled", true);
			}
			
			if(data.city){
				$('#addressCity').val(data.city.name);
				$('#addressCity').attr("disabled", true);
			}
			
			if(data.district){
				$('#addressDistrict').val(data.district.name);
				$('#addressDistrict').attr("disabled", true);
			}
		});
	});

	$('.next').on('click', navigate2NextTab);
	$('.previous').on('click', navigate2PreviousTab);
	
	$("#registration-form").submit(function (e) {
		e.preventDefault();
		if ($(".error").length === 0) {
			var form = $(this).serializeArray();
			var jsonForm = {};
			$(form).each(function (index, data) {
				jsonForm[data.name] = data.value;
			});

			$.ajax({
				type: "POST",
				data: JSON.stringify(jsonForm),
				beforeSend: function (xhr) {
					xhr.setRequestHeader(header, token);
				},
				contentType: "application/json; charset=utf-8",
				url: "registration_form",
			}).done(function (data) {
				if (data.success) {
					console.log(data);
				} else {
					$("#registration-dialog-msg").text(data.msg);
					$("#registration-dialog").dialog({ title: "Error" });
					$("#registration-dialog").dialog("open");
				}
			});
		} else {
			alert("the registration form you're trying to submit contains error!");
		}
	});

});

var current, next, previous;
var left, opacity, scale;
var isAnimating;
var hasErrors, hasEmptyInputs, isPristine;

function validateCurrentTabInputTexts(current){
	current.find('input:text').each(function() {
		if ($(this).val() === '') {
			$(this).addClass('error');
			hasEmptyInputs = true;
		}
	});
}

function validateCurrentTabRadioButtons(current){
	var inputRadios = current.find('input[type=radio]');
	inputRadios.each(function(){
		var radioDiv = $(this).parent().parent();
		var areAllRadiosUnchecked = radioDiv.find('input[type=radio]:checked').length === 0;
		var hasErrorLabel = radioDiv.find('label#errlbl_'+radioDiv[0].id).length === 0;
		
		if(areAllRadiosUnchecked && hasErrorLabel){
			$errorLabel = $('<label>', {id: 'errlbl_' + radioDiv[0].id});
			$errorSpan = $('<span>', {text: 'choose an option!'});
			$errorSpan.css({'color':'#ffffff','background-color':'#ff0000','border-radius':'2px', 'padding':'2px'});
			$errorLabel.append($errorSpan);
			radioDiv.append($errorLabel);
		}
	});
}

function navigate2NextTab() {
	if (isAnimating) return false;
	isAnimating = true;

	current = $(this).parent().parent();
	next = $(this).parent().parent().next();

	validateCurrentTabInputTexts(current);
	validateCurrentTabRadioButtons(current);

	hasErrors = current.find('input:text').hasClass('error');
	if (hasErrors) {
		isAnimating = false;
		return false;
	}

	//activate next step on progressbar using the index of next_fs
	$("#progressbar li").eq($("fieldset").index(next)).addClass("active");

	next.show();

	current.animate({
		opacity: 0
	}, {
			step: function (now, mx) {
				scale = (1 - now) * 0.2;
				left = (now * 50) + "%";
				opacity = 1 - now;
				current.css({
					'transform': 'scale(' + scale + ')'
				});
				next.css({
					'left': left,
					'opacity': opacity
				});
			},
			duration: 'fast',
			specialEasing: {
				width: "linear",
				height: "easeOutBounce"
			},
			complete: function () {
				current.hide();
				isAnimating = false;
			}
		});
}

function navigate2PreviousTab (){
	if (isAnimating) return false;
	isAnimating = true;

	current = $(this).parent().parent();
	previous = $(this).parent().parent().prev();

	//de-activate current step on progressbar
	$("#progressbar li").eq($("fieldset").index(current)).removeClass("active");

	previous.show();

	current.animate({
		opacity: 0
	}, {
			step: function (now, mx) {
				scale = 0.8 + (1 - now) * 0.2;
				left = ((1 - now) * 50) + "%";
				opacity = 1 - now;
				current.css({
					'left': left
				});
				previous.css({
					'transform': 'scale(' + scale + ')',
					'opacity': opacity
				});
			},
			duration: 'fast',
			specialEasing: {
				width: "linear",
				height: "easeOutBounce"
			},
			complete: function () {
				current.hide();
				isAnimating = false;
			}
		});
}