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

<script type="text/javascript">
$(function() {
	$("a, input[type=submit],input[type=reset]").button();
});

</script>
</head>

<body>
	<div id="navigation">
		<c:import url="/WEB-INF/views/navigation.jsp"></c:import>
	</div>

	<div id="content">
	<h3>Paciente - ${patient.firstName} ${patient.lastName}</h3><br />
	<fieldset>
		<legend>Dados do Paciente</legend>
		<br />
		<label class="displayLabel" for="firstName">Nome:</label> ${patient.firstName}<br />
		<label class="displayLabel" for="lastName">Sobrenome:</label> ${patient.lastName}<br />
		<label class="displayLabel" for="birthdate">Nascimento:</label> <fmt:formatDate value="${patient.birthDate.time}" pattern="dd/MM/yyyy"/><br />
		<label class="displayLabel" for="cpf">CPF:</label> ${patient.cpf}<br />
		<label class="displayLabel" for="phoneNumber">Telefone:</label> ${patient.phoneNumber}<br />
		<br /><br />
		<legend>Endereço</legend>
		<br />
		<label class="displayLabel" for="addressStreet">Rua:</label> ${patient.addressStreet}
		<label class="displayLabel" for="addressNumber">Número:</label> ${patient.addressNumber}<br />
		<label class="displayLabel" for="addressDistrict">Bairro:</label> ${patient.addressDistrict}
		<label class="displayLabel" for="addressPostalCode">CEP:</label> ${patient.addressPostalCode}<br />
	</fieldset>
	</div>

	<div id="footer">
		<c:import url="/WEB-INF/views/footer.jsp"></c:import>
	</div>

</body>
</html>