<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<title>Patient Management</title>

<script type="text/javascript">
	$(function() {
		$("input[type=submit],a").button();
	});
</script>
</head>
<body>

	<div id="navigation">
		<c:import url="/WEB-INF/views/navigation.jsp"></c:import>
	</div>
	<div id="content">
		<a href="register_patient">Cadastrar paciente</a> 
		<a href="list_patients">Listar pacientes</a>
	</div>
	<div id="footer">
		<c:import url="/WEB-INF/views/footer.jsp"></c:import>
	</div>

</body>
</html>