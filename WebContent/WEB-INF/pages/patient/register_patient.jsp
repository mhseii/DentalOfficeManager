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
<script src="resources/js/register-patient.js"></script>

<title>Cadastro de Paciente</title>
</head>
<body>

	<div id="navigation">
		<c:import url="/WEB-INF/pages/common/navigation.jsp" />	
	</div>
	
	<div id="content">
		<div id="register" style="display:table; overflow: auto;">
				<form id="registrationForm" action="/DentalOfficeManager/patientRegistrationForm" method="post" >
				<form:errors path="patient.notNull"/>
				<fieldset>
					<legend>Paciente</legend>
					<div>
						<label for="firstName">
							Nome
							<input name="firstName"/>
						</label>
						<label for="lastName">
							Sobrenome
							<input name="lastName"/>
						</label> 
						<p>
							<span>Sexo:</span>
							<label class="signup-form-radio"> 
								masculino 
								<input class="signup-form-radio" type="radio" name="gender" value="male"> 
							</label> 
							&nbsp; &nbsp;
							<label class="signup-form-radio"> 
								feminino
								<input class="signup-form-radio" type="radio" name="gender" value="female"> 
							</label>
						</p>
						<label for="birthDate">
							Nascimento 
							<input id="datepicker" type="text" name="birthDate" placeholder="dd/mm/yyyy" /> 
						</label> 
						<label for="cpf">
							CPF 
							<input id="patient-ssn" name="cpf"/> 
						</label> 
					</div>			
				</fieldset>
				<fieldset>
					<legend>Contato</legend>
					<div>
						<label for="phoneNumber">
							Telefone Fixo
							<input type="text" name="phoneNumber"/>
						</label> 
						<label for="cellPhoneNumber">
							Celular
							<input type="text" name="cellPhoneNumber"/>
						</label> 
						<label for="email">
							e-mail
							<input id="email" type="email" name="email" placeholder="teste@email.com.br"/>
						</label>
					</div>
				</fieldset>
				<fieldset>	
					<legend>Endereço</legend>
					<div>
						<p><label for="addressZipCode">
							Cep
							<input name="addressZipCode" placeholder="9999-999"/>
						</label></p>
						<label for="addressStreet">
							Rua
							<input name="addressStreet"/>
						</label> 
						<label for="addressAdditionalInfo">
							Complemento
							<input name="addressAdditionalInfo"/>
						</label> 
						<label for="addressNumber">
							Número
							<input name="addressNumber"/>
						</label> 
						<label for="addressDistrict">
							Bairro
							<input name="addressDistrict"/>
						</label> 
						<label for="addressCity">
							Cidade
							<input name="addressCity"/>
						</label> 
						<label class="form" for="addressState">
							Estado 
							<select id="address-state">
							</select> 
						</label>
					</div>
				</fieldset>
				<div>
	            	<input id="register" type="submit" value="registrar" />
	        	</div>
			</form>
		</div>
	</div>
	<div id="footer">
		<c:import url="/WEB-INF/pages/common/footer.jsp" />
	</div>
</body>
</html>