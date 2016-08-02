<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- JQuery UI -->
<script type="text/javascript" 	src="resources/js/jquery-2.1.1.js"></script>
<script type="text/javascript"	src="resources/css/jquery-css/external/jquery/jquery.js"></script>
<script type="text/javascript"	src="resources/css/jquery-css/jquery-ui.js"></script>
	
<!-- CSS -->
<!-- <link href="resources/css/jquery-css/jquery-ui.css" rel="stylesheet"></link> -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<link href="resources/css/custom.css" rel="stylesheet"></link>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>

<body>
	<h1>Dental Office Manager</h1>
	<ul id="nav">
			<li><a class="navigation-button" id="home"  href="home">Início</a></li>
			<li><a class="navigation-button" id="list-patients" href="list_patients">Pacientes</a></li>
			<li><a class="navigation-button" id="register-patient" href="register_patient">Registrar Pacientes</a></li>
			<li><a class="navigation-button" id="appoint-patient"href="arrange">Agendar Consulta</a></li>
	</ul>
</body>
</html>