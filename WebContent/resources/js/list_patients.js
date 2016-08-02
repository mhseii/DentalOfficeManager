$(function() {
	
	$("#searchPatient").autocomplete({
		minLength : 2,
		delay : 500,
		source : function(request, response) {
			$.getJSON('${pageContext.request.contextPath}/search_patient', request, function(result) {
				response($.map(result, function(item) {
					return {
						// what is shown in the drop down menu
						label : item.firstName + " " + item.lastName,
						// what is shown in the text box
						// and what is defined for 'select' handler
						value : item,
					}
				}));
			});
		},
		select : function( event, ui ) {
			console.log(ui.item);
			if (ui.item){
				// reset the value of text box to the label
				// it would appear [object Object] otherwise
				$('#searchPatient').val(ui.item.value.firstName + " " +ui.item.value.lastName);
				$(this).val(ui.item.label);
				window.location.href = 'view_patient?id=' + ui.item.value.id;
				return false;
			} 
		}
	});

	
});