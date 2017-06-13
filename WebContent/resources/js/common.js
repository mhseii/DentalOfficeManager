$(function() {

	$("input[type=submit],a,button").button();
	
	$("#datepicker").datepicker({
		autoSize: true,
		showAnim : "drop",
		dateFormat : "dd/mm/yy",
		changeMonth : true,
		changeYear : true,
		yearRange: "-80:+0"
	});
	
	$(document).ready(function() {
		$("#searchPatient").autocomplete({
			minLength : 3,
			delay : 500,
			source : function(request, response) {
				$.getJSON("search_patient", request, function(result) {
					response($.map(result, function(item) {
						console.log(item);
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
					window.location.href = 'view_patient?id=' + ui.item.value;
					return false;
				}
			}
		});
	});
	
});