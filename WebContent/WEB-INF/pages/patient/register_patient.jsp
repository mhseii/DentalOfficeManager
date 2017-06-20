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
<script src="${pageContext.request.contextPath}/resources/js/register-patient.js"></script>

<title>Cadastro de Paciente</title>
</head>
<body>

	<div id="navigation">
		<c:import url="/WEB-INF/pages/common/navigation.jsp" />	
	</div>
	
	<div id="content">
		<div id="register" style="display:table; overflow: auto;">
				<form id="registration-form">
				<fieldset>
					<legend>Paciente</legend>
					<hr/>
					<div>
							<input name="firstName" placeholder="Nome" >
							<input name="lastName" 	placeholder="Sobrenome" >
							<input name="dateOfBirth" placeholder="Data de nascimento" class="datepicker" >
						<p>
							<label class="signup-form-radio"> 
								<span>masculino</span> 
								<input class="signup-form-radio" type="radio" name="gender" value="male"> 
							</label> 
							&nbsp; &nbsp;
							<label class="signup-form-radio"> 
								<span>feminino</span>
								<input class="signup-form-radio" type="radio" name="gender" value="female"> 
							</label>
						</p>
						<p>
							<label class="signup-form-radio">
								<span>RG</span>
								<input class="signup-form-radio" type="radio" name="ssnType" value="RG">
							</label>
							&nbsp; &nbsp;
							<label class="signup-form-radio">
								<span>CPF</span>
								<input class="signup-form-radio" type="radio" name="ssnType" value="CPF">
							</label>
							&nbsp; &nbsp;
							<label class="signup-form-radio">
								<span>CNPJ</span>
								<input class="signup-form-radio" type="radio" name="ssnType" value="CNPJ">
							</label>
						</p>
						<label for="ssn">
							<input name="ssn" id="patient-ssn" placeholder="n&#186; de identidade" > 
						</label> 
					</div>			
				</fieldset>
				<fieldset>
					<legend>Contato</legend>
					<hr/>
					<div>
							<input name="phoneNumber" id="phone-number"	placeholder="telefone"/>
							<input name="mobileNumber" id="mobile-number" placeholder="celular"/>
							<input name="email" id="email" type="email" placeholder="e-mail"/>
					</div>
				</fieldset>
				<fieldset>	
					<legend>Endereço</legend>
					<hr/>
					<div>
						<div>
							<label for="addressZipCode">
								<input name="addressZipCode" placeholder="cep">
							</label>
						</div>
						<input name="addressStreet" 		placeholder="logradouro"/>
						<input name="addressComplements" placeholder="complemento"/>
						<input name="addressNumber" 		placeholder="n&#186;"/>
						<input name="addressDistrict" 		placeholder="bairro"/>
						<input name="addressCity" 			placeholder="cidade"/>
						<select name="addressState" id="address-state" >
							<option value="SP">SP</option>
						</select> 
						<input name="addressCountry" value="Brazil" type="hidden"/>
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