<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	
	<!-- JSTL  -->
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<head>
	<title>register new user</title>
	
	<!--  standard imports through out the app-->
	<c:import url="/WEB-INF/pages/common/header.jsp" />
	
	<!-- page javascript  -->
	<script src="${pageContext.request.contextPath}/resources/js/register-user.js"></script>
</head>

<body>
	
	<div class="content">
		<div class="navigation">
			<c:import url="/WEB-INF/pages/common/navigation.jsp" />	
		</div>
	
		<div class="main register-form">
			<form id="registration-form">
				<fieldset>
					<legend><spring:message code="login.user"/></legend>
					<hr/>
					<input name="email" id="email" type="email" placeholder="<spring:message code="email"/>"/>
					<input name="password" id="password" type="password" placeholder="<spring:message code="login.password"/>"/>
					<input name="passwordConfirmation" id="pwconfirm" type="password" placeholder="<spring:message code="login.pwconfirm"/>"/>
					<div id="userRoles">
					</div>
				</fieldset>
				<fieldset>
					<legend><spring:message code="general"/></legend>
					<hr/>
					<div>
						<input name="firstName" placeholder="<spring:message code="firstName"/>"/>
						<input name="lastName" 	placeholder="<spring:message code="lastName"/>"/>
						<input class="datepicker" name="dateOfBirth" placeholder="<spring:message code="dateOfBirth"/>"/>
						<p>
							<label class="register-form-radio"> 
								<span><spring:message code="gender.male"/></span> 
								<input class="register-form-radio" type="radio" name="gender" value="male"> 
							</label> 
							&nbsp; &nbsp;
							<label class="register-form-radio"> 
								<span><spring:message code="gender.female"/></span>
								<input class="register-form-radio" type="radio" name="gender" value="female"> 
							</label>
						</p>
					</div>			
				</fieldset>
				<fieldset>
					<legend><spring:message code="contact" /></legend>
					<hr/>
					<div>
						<input name="phoneNumber" id="phone-number"	placeholder="<spring:message code="phone"/>"/>
						<input name="mobileNumber" id="mobile-number" placeholder="<spring:message code="mobile"/>"/>
					</div>
				</fieldset>
				<div>
	            	<input id="register" type="submit" value="<spring:message code="button.register"/>" />
	        	</div>
			</form>
		</div>
		
		<div class="footer">
			<c:import url="/WEB-INF/pages/common/footer.jsp" />
		</div>
	</div>
</body>
</html>