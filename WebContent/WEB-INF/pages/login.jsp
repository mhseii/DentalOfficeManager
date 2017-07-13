<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	
<head>
	<title>DentalOfficeManager - Login</title>
	<!--  standard imports through out the app-->
	<c:import url="/WEB-INF/pages/common/header.jsp" />
	<script type="application/javascript" src="${pageContext.request.contextPath}/resources/js/login.js" ></script>
</head>

<body>
	<div class="content">
		<div>
			<div style="text-align: center;">
				<h1><spring:message code="navigation.title"/></h1>
			</div>
			<div>
				<form id="login-form" class="login" method="post">
					<fieldset>
						<div>
							<label for="username"><input type="text" id="username" name="username"/>
								<span class="ui-icon ui-icon-person"></span>
							</label>
						</div>
						<div>
							<label for="password"><input type="password" id="password" name="password"/>
								<span class="ui-icon ui-icon-key"></span>
							</label>
						</div>
					</fieldset>
					<div style="text-align: center;">
						<input type="submit" id="sign-in" value="<spring:message code="login.sign-in"/>"/>
					</div>
				</form>
				<input type="submit" id="recover-password" value="<spring:message code="login.pass-recover"/>"/>
			</div>
		</div>
	</div>
</body>

</html>