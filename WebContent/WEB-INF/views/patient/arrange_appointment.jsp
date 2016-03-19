<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- JQuery UI -->
<script type="text/javascript" src="resources/js/jquery.js"></script>
<script src="resources/css/external/jquery/jquery.js"></script>
<script src="resources/css/jquery-ui.js"></script>
<link href="resources/css/jquery-ui.css" rel="stylesheet"></link>
<!-- Custom CSS -->
<link href="resources/css/custom.css" rel="stylesheet"></link>
<!-- JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script type="text/javascript">
	$(function() {
		$("#datepicker").datepicker({
			autoSize: true,
			showAnim : "drop",
			dateFormat : "dd/mm/yy",
			changeMonth : true,
			changeYear : true,
			minDate: "-90Y",
			maxDate: "-1Y",
			yearRange: "1925:2014"
		})
	});
	$(function() {
		$("input[type=submit],input[type=reset],a").button();
	});
</script>

<title></title>
</head>
<body>

	<div id="navigation">
		<c:import url="/WEB-INF/views/navigation.jsp"></c:import>
	</div>

	<div id="content">
		<form id="arrangementForm" action="/DentalOfficeManager/arrangementForm" method="post">
			<fieldset>
				<legend>Agendar Horário</legend>
				<label>Data:</label>
				<input id="datepicker" type="text" name="appointmentDate"/>
				<label>Hora:</label>
				<input id="datepicker" type="text" name="appointmentTime"/>
							
			</fieldset>
		</form>
	</div>
	
	<div id="footer">
		<c:import url="/WEB-INF/views/footer.jsp"></c:import>
	</div>
</body>
</html>