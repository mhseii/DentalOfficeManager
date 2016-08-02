$(function() {

	$("input[type=submit],a,button").button();
	
	$("#datepicker").datepicker({
		autoSize: true,
		showAnim : "drop",
		dateFormat : "dd/mm/yy",
		changeMonth : true,
		changeYear : true,
		yearRange: "-80:+0"
	})
	
});