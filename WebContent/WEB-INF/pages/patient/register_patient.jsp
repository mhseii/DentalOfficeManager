<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- JSTL  -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!--  standard imports through out the app-->
<c:import url="/WEB-INF/pages/common/header.jsp" />

<!-- page javascript  -->
<script type="text/javascript" src="resources/js/register-patient.js"></script>

<title>Cadastro de Paciente</title>
</head>
<body>

	<div id="navigation">
		<c:import url="/WEB-INF/pages/common/navigation.jsp" />	
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
					<input class="formInput" id="patient-ssn" name="cpf" placeholder="123.456.789-10"/>			
				</fieldset>
				<fieldset>
					<legend>Contato</legend>
					<label class="form" for="phoneNumber">Tel. Fixo:</label> 
					<input class="formInput" type="text" name="phoneNumber" placeholder="(11) 1234-5678"/>
					
					<label class="form" for="cellPhoneNumber">Celular:</label> 
					<input class="formInput" type="text" name="cellPhoneNumber" placeholder="(11) 1234-5678"/>
					
					<label class="form" for="email">e-mail:</label>
					<input class="formInput" id="email" type="text" name="email" placeholder="teste@email.com.br"/>
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
		<c:import url="/WEB-INF/pages/common/footer.jsp" />
	</div>
</body>
</html>