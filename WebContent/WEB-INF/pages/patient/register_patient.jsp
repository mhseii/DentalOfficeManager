<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<title>Cadastro de Paciente</title>

	<!--  standard imports through out the app-->
	<%@ include file="/WEB-INF/pages/common/header.jsp" %>
	
	<!-- page javascript  -->
	<script src="${pageContext.request.contextPath}/resources/js/register-patient.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/register-patient-validation.js"></script>
</head>
<body>

	<div id="registration-dialog"><span id="registration-dialog-msg"></span></div>
	
	<div class="content justified">
	<%@ include file="/WEB-INF/pages/common/navigation.jsp" %>
	
		<div class="main">
			<form id="registration-form" class="registration-form">
				<fieldset>
					<h2><spring:message code="patient"/></h2>
                    <div>
                        <input id="firstName" name="firstName" placeholder="<spring:message code="firstName"/>"/>
                        <input id="lastName" name="lastName" 	placeholder="<spring:message code="lastName"/>"/>
                    </div>
					<div id="gender-radio-div" class="radio-div">
                        <label class="register-form-radio"> 
                            <span><spring:message code="gender.male"/></span> 
                            <input class="register-form-radio" type="radio" name="gender" value="male"> 
                        </label> 
                        <label class="register-form-radio"> 
                            <span><spring:message code="gender.female"/></span>
                            <input class="register-form-radio" type="radio" name="gender" value="female"> 
                        </label>
                    </div>
                    <div>
                    	<input class="datepicker" name="dateOfBirth" placeholder="<spring:message code="dateOfBirth"/>"/>
                    </div>
                    <div>
						<div id="ssn-radio-div" clas="radio-div">
							<label class="register-form-radio">
								<span><spring:message code="ssn.RG"/></span>
								<input class="register-form-radio" type="radio" name="ssnType" value="RG">
							</label>
							<label class="register-form-radio">
								<span><spring:message code="ssn.CPF"/></span>
								<input class="register-form-radio" type="radio" name="ssnType" value="CPF">
							</label>
							<label class="register-form-radio">
								<span><spring:message code="ssn.CNPJ"/></span>
								<input class="register-form-radio" type="radio" name="ssnType" value="CNPJ">
							</label>
						</div>
                        <label for="ssnId">
                            <input name="ssnId" class="ssn" id="patient-ssn" placeholder="<spring:message code="ssn.id"/>"/> 
                        </label> 
                    </div>
                    <div>
                        <input class="next action-button" type="button" name="next" value="next"/>
                    </div>
				</fieldset>
				
				<fieldset>
					<h2><spring:message code="contact" /></h2>
					<input name="phoneNumber" class="phone-number" id="phone-number" placeholder="<spring:message code="phone"/>"/>
					<input name="mobileNumber" class="mobile-number" id="mobile-number" placeholder="<spring:message code="mobile"/>"/>
					<input name="email" class="email" id="email" type="email" placeholder="<spring:message code="email"/>"/>
                    <div>
						<input class="previous action-button" type="button" name="previous" value="previous"/>
						<input class="next action-button" type="button" name="next" value="next"/>
                    </div>
				</fieldset>
				
				<fieldset>	
					<h2><spring:message code="address" /></h2>
						<input id="addressZipCode" name="addressZipCode" placeholder="<spring:message code="address.zipcode"/>">
					<p>
						<input class="autofill-enabled" id="addressStreet" 		name="addressStreet" placeholder="<spring:message code="address.street"/>"/>
						<input class="autofill-enabled" id="addressNumber" 		name="addressNumber" placeholder="<spring:message code="address.number"/>"/>
						<input class="autofill-enabled" id="addressComplements" name="addressComplements" placeholder="<spring:message code="address.complement"/>"/>
						<input class="autofill-enabled" id="addressDistrict" 	name="addressDistrict" placeholder="<spring:message code="address.district"/>"/>
						<input class="autofill-enabled" id="addressCity" 		name="addressCity" placeholder="<spring:message code="address.city"/>"/>
						<select class="autofill-enabled" id="addressState"		name="addressState" >
							<option selected disabled><spring:message code="address.state"/></option>
						</select> 
						<input name="addressCountry" value="Brazil" type="hidden"/>
					</p>
                    <div>
                        <input class="previous action-button" type="button" name="previous" value="previous"/>
                        <input id="register" type="submit" value="<spring:message code="button.register"/>" />
                    </div>
				</fieldset>
			</form>
		</div>
            
		<%@ include file="/WEB-INF/pages/common/footer.jsp" %>
	</div>
</body>
</html>