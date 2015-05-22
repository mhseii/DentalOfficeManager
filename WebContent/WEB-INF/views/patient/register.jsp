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

<title>Cadastro de Paciente</title>
</head>
<body>

	<div id="navigation">
		<c:import url="/WEB-INF/views/navigation.jsp" />	
	</div>
	
	<div id="content">
		<form:errors path="patient.notNull"/>
		<form id="registrationForm" action="/DentalOfficeManager/patientRegistrationForm" method="post">
			<fieldset>
				<legend>Dados do Paciente</legend>
				
				<label class="formLabel" id="fieldset-label" for="firstName">Nome:</label>
				<input type="text" name="firstName"/> <br />
				
				<label class="formLabel" id="fieldset-label" for="lastName">Sobrenome:</label>
				<input type="text" name="lastName"/> <br />
				
				<label class="formLabel" id="fieldset-label" for="birthDate">Nascimento:</label> 
				<input id="datepicker" type="text" name="birthDate"/> <br />
				 
				<label class="formLabel" id="fieldset-label" for="cpf">CPF:</label> 
				<input type="text" name="cpf"/> <br />
				
				<label class="formLabel" id="fieldset-label" for="phoneNumber">Telefone:</label> 
				<input type="text" name="phoneNumber"/>  <br /><br />
				
				<legend>Endereço</legend>
				
				<label class="formLabel" id="fieldset-label" for="addressStreet">Rua:</label> 
				<input type="text" name="addressStreet"/> <br />
				
				<label class="formLabel" id="fieldset-label" for="addressNumber">Número:</label> 
				<input type="text" name="addressNumber"/> <br />
					
				<label class="formLabel" id="fieldset-label" for="addressPostalCode">Bairro:</label> 
				<input type="text" name="addressDistrict"/> <br />
				
				<label class="formLabel" id="fieldset-label" for="addressPostalCode">Cep:</label> 
				<input type="text" name="addressPostalCode"/> <br />

				<input type="reset" value="cancelar"/>
				<input type="submit" value="registrar"/>
				
			</fieldset>
		</form>
	</div>
	
	<div id="footer">
		<c:import url="/WEB-INF/views/footer.jsp" />
	</div>
</body>
</html>