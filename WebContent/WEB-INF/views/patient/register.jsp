<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- JQuery UI -->
<!-- FormToWizard by JankoAtWarpSpeed -->
<!-- http://www.jankoatwarpspeed.com/turn-any-webform-into-a-powerful-wizard-with-jquery-formtowizard-plugin/ -->
<script type="text/javascript" src="resources/js/jquery.js"></script>
<script type="text/javascript" src="resources/css/external/jquery/jquery.js"></script>
<script type="text/javascript" src="resources/css/jquery-ui.js"></script>
<script type="text/javascript" src="resources/js/form-to-wizard.js"></script>
<!-- CSS -->
<link href="resources/css/jquery-ui.css" rel="stylesheet"></link>
<link href="resources/css/custom.css" rel="stylesheet"></link>
<!-- JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script type="text/javascript" src="resources/js/formToWizard.js"></script>

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

	$(function(){
		$("#registrationForm").formToWizard({ submitButton: 'register' });
	});
</script>

<title>Cadastro de Paciente</title>
</head>
<body>

	<div id="navigation">
		<c:import url="/WEB-INF/views/navigation.jsp" />	
	</div>
	
	<div id="content">
		<div id="register" >
				<form id="registrationForm" action="/DentalOfficeManager/patientRegistrationForm" method="post">
				<form:errors path="patient.notNull"/>
				<fieldset>
					<legend>Paciente</legend>
					<label class="form" for="firstName">Nome:</label>
					<input class="formInput" name="firstName"/>
					
					<label class="form" for="lastName">Sobrenome:</label>
					<input class="formInput" name="lastName"/>
					
					<label class="form" for="birthDate">Nascimento:</label> 
					<input class="formInput" id="datepicker" type="text" name="birthDate" placeholder="dd/mm/yyyy" />
					
					<label class="form" for="cpf">CPF:</label> 
					<input class="formInput" name="cpf" placeholder="123.456.789-10"/>			
				</fieldset>
				<fieldset>
					<legend>Contato</legend>
					<label class="form" for="phoneNumber">Tel. Fixo:</label> 
					<input class="formInput" type="text" name="phoneNumber" placeholder="(11)123456789"/>
					
					<label class="form" for="cellPhoneNumber">Celular:</label> 
					<input class="formInput" type="text" name="cellPhoneNumber" placeholder="(11)123456789"/>
					
					<label class="form" form="email">e-mail:</label>
					<input class="formInput" id="email" type="text" name="email"/>
				</fieldset>
				<fieldset>	
					<legend>Endereço</legend>
					<label class="form" for="addressStreet">Rua:</label> 
					<input class="formInput" name="addressStreet"/>
					
					<label class="form" for="addressAdditionalInfo">Complemento:</label> 
					<input class="formInput" name="addressAdditionalInfo"/>
					
					<label class="form" for="addressNumber">Número:</label> 
					<input class="formInput" name="addressNumber"/>
					
					<label class="form" for="addressDistrict">Bairro:</label> 
					<input class="formInput" name="addressDistrict"/>
					
					<label class="form" for="addressCity">Cidade:</label> 
					<input class="formInput" name="addressCity"/>
					
					<label class="form" for="addressState">Estado:</label> 
					<input class="formInput" name="addressState"/>
					
					<label class="form" for="addressZipCode">Cep:</label>
					<input class="formInput" name="addressZipCode" placeholder="12345-000"/>
				</fieldset>
				<p>
	            	<input id="register" type="submit" value="registrar" />
	        	</p>
			</form>
		</div>
	</div>
	<div id="footer">
		<c:import url="/WEB-INF/views/footer.jsp" />
	</div>
</body>
</html>