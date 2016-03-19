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

	<div id="content2">
	<h3>Paciente - ${patient.firstName} ${patient.lastName}</h3><br />
	<fieldset>
		<legend>Dados do Paciente</legend>
		<br />
		<label class="noStyle" for="firstName">Nome:</label><span>${patient.firstName}</span><br />
		<label class="noStyle" for="lastName">Sobrenome:</label><span>${patient.lastName}</span><br />
		<label class="noStyle" for="birthdate">Nascimento:</label><span><fmt:formatDate value="${patient.birthDate.time}" pattern="dd/MM/yyyy"/></span><br />
		<label class="noStyle" for="cpf">CPF:</label><span>${patient.cpf}</span><br />
		<br />
		<legend>Contatos</legend>
		<label class="noStyle" for="phoneNumber">Telefone:</label><span>${patient.phoneNumber}</span><br />
		<label class="noStyle" for="cellPhoneNumber">Celular:</label><span>${patient.cellPhoneNumber}</span><br />
		<label class="noStyle" for="email">e-mail:</label><span>${patient.email}</span><br />
		<br />
		<legend>Endereço</legend>
		<label class="noStyle" for="street">Rua:</label><span>${patient.address.street}</span><br />
		<label class="noStyle" for="additionalAddressInfo">Complemento:</label><span>${patient.address.additionalAddressInfo}</span><br />
		<label class="noStyle" for="number">Número:</label><span>${patient.address.number}</span><br />
		<label class="noStyle" for="district">Bairro:</label><span>${patient.address.district}</span><br />
		<label class="noStyle" for="district">Cidade:</label>${patient.address.city}</span><br />
		<label class="noStyle" for="state">UF:</label><span>${patient.address.state}</span><br />
		<label class="noStyle" for="zipcode">CEP:</label><span>${patient.address.zipcode}</span><br />
	</fieldset>
	</div>

	<div id="footer">
		<c:import url="/WEB-INF/views/footer.jsp"></c:import>
	</div>

</body>
</html>