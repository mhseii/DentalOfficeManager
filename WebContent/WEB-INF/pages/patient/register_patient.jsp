<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- JSTL  -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!--  standard imports through out the app-->
<c:import url="/WEB-INF/pages/common/header.jsp" />

<!-- page javascript  -->
<script src="${pageContext.request.contextPath}/resources/js/register-patient.js"></script>

<title>Cadastro de Paciente</title>
</head>
<body>

	<div id="registration-dialog">
		<span id="registration-dialog-msg"></span>
	</div>

	<div id="navigation">
		<c:import url="/WEB-INF/pages/common/navigation.jsp" />	
	</div>
	
	<div id="content">
		<div id="register" style="display:table; overflow: auto;">
				<form id="registration-form">
				<fieldset>
					<legend><spring:message code="patient" /></legend>
					<hr/>
					<div>
							<input name="firstName" placeholder="<spring:message code="firstName" />" >
							<input name="lastName" 	placeholder="<spring:message code="lastName" />" >
							<input name="dateOfBirth" placeholder="<spring:message code="dateOfBirth" />" class="datepicker" >
						<p>
							<label class="signup-form-radio"> 
								<span><spring:message code="gender.male" /></span> 
								<input class="signup-form-radio" type="radio" name="gender" value="male"> 
							</label> 
							&nbsp; &nbsp;
							<label class="signup-form-radio"> 
								<span><spring:message code="gender.female" /></span>
								<input class="signup-form-radio" type="radio" name="gender" value="female"> 
							</label>
						</p>
						<p>
							<label class="signup-form-radio">
								<span><spring:message code="ssn.RG" /></span>
								<input class="signup-form-radio" type="radio" name="ssnType" value="RG">
							</label>
							&nbsp; &nbsp;
							<label class="signup-form-radio">
								<span><spring:message code="ssn.CPF" /></span>
								<input class="signup-form-radio" type="radio" name="ssnType" value="CPF">
							</label>
							&nbsp; &nbsp;
							<label class="signup-form-radio">
								<span><spring:message code="ssn.CNPJ" /></span>
								<input class="signup-form-radio" type="radio" name="ssnType" value="CNPJ">
							</label>
						</p>
						<label for="ssn">
							<input name="ssn" id="patient-ssn" placeholder="<spring:message code="ssn.id" />" > 
						</label> 
					</div>			
				</fieldset>
				<fieldset>
					<legend><spring:message code="contact" /></legend>
					<hr/>
					<div>
							<input name="phoneNumber" id="phone-number"	placeholder="<spring:message code="phone" />"/>
							<input name="mobileNumber" id="mobile-number" placeholder="<spring:message code="mobile" />"/>
							<input name="email" id="email" type="email" placeholder="<spring:message code="email" />"/>
					</div>
				</fieldset>
				<fieldset>	
					<legend><spring:message code="address" /></legend>
					<hr/>
					<div>
						<div>
							<label for="addressZipCode">
								<input name="addressZipCode" placeholder="<spring:message code="address.zipcode" />">
							</label>
						</div>
						<input name="addressStreet" 		placeholder="<spring:message code="address.street" />"/>
						<input name="addressComplements" 	placeholder="<spring:message code="address.complement" />"/>
						<input name="addressNumber" 		placeholder="<spring:message code="address.number" />"/>
						<input name="addressDistrict" 		placeholder="<spring:message code="address.district" />"/>
						<input name="addressCity" 			placeholder="<spring:message code="address.city" />"/>
						<select name="addressState" id="address-state" >
							<option selected disabled><spring:message code="address.state" /></option>
						</select> 
						<input name="addressCountry" value="Brazil" type="hidden"/>
					</div>
				</fieldset>
				<div>
	            	<input id="register" type="submit" value="<spring:message code="button.register" />" />
	        	</div>
			</form>
		</div>
	</div>
	<div id="footer">
		<c:import url="/WEB-INF/pages/common/footer.jsp" />
	</div>
</body>
</html>