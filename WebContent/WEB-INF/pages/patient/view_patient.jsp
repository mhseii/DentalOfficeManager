<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- JQuery UI -->
<script type="text/javascript" src="resources/js/jquery-2.1.1.js"></script>
<script type="text/javascript"
	src="resources/css/jquery-css/external/jquery/jquery.js"></script>
<script type="text/javascript"
	src="resources/css/jquery-css/jquery-ui.js"></script>
<!-- CSS -->
<link href="resources/css/jquery-css/jquery-ui.css" rel="stylesheet"></link>
<link href="resources/css/custom.css" rel="stylesheet"></link>

<!-- Latest compiled JavaScript -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"></link>

<!-- JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script type="text/javascript">
	$(function() {
		$("a, input[type=submit],input[type=reset]").button();
	});

	$(function() {
		$('#content2').accordion({
			collapsible: true,
			heightStyle: "content"
		});
	});
</script>

<style>
label, span {
	display: inline-block;
	width: auto;
}

label {
	padding-right: 5px;
}

span {
	padding-right: 10px;
}
body{
	color: black;
}

</style>
</head>

<body>
	<div id="navigation">
		<c:import url="/WEB-INF/pages/navigation.jsp"></c:import>
	</div>

	<h3>Paciente - ${patient.firstName} ${patient.lastName}</h3>
	<div id="content2" class="ui-widget-content">
		<h3>Dados do Paciente</h3>
		<div>
				<label for="firstName">Nome:</label> <span>${patient.firstName}
					${patient.lastName}</span> <label for="birthdate">Nascimento:</label><span><fmt:formatDate
						value="${patient.birthDate.time}" pattern="dd/MM/yyyy" /></span> <label
					for="cpf">CPF:</label><span>${patient.cpf}</span>
		</div>
		<h3>Contatos</h3>
		<div>
			<label for="phoneNumber">Telefone:</label><span>${patient.phoneNumber}</span>
			<label for="cellPhoneNumber">Celular:</label><span>${patient.cellPhoneNumber}</span><br />
			<label for="email">e-mail:</label><span>${patient.email}</span><br />
		</div>
		<h3>Endereço</h3>
		<div>
			<label for="district">Cidade:</label><span>${patient.address.city}</span>
			<label for="state">UF:</label><span>${patient.address.state}</span><br />
			<label for="street">Rua:</label><span>${patient.address.street}</span>
			<label for="number">Número:</label><span>${patient.address.number}</span><br />
			<c:if test="${patient.address.additionalAddressInfo} != null">
				<label for="additionalAddressInfo">Complemento:</label>
				<span></span>
				<br />
			</c:if>
			<label for="district">Bairro:</label><span>${patient.address.district}</span>
			<label for="zipcode">CEP:</label><span>${patient.address.zipcode}</span><br />
		</div>
	</div>

	<div id="footer">
		<c:import url="/WEB-INF/pages/footer.jsp"></c:import>
	</div>

</body>
</html>