<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
 
 <div>
		<div style="display: inline-block; height: inherit;">
			<h1><spring:message code="navigation.title" /></h1>
		</div>
		<div class="ui-widget" style="display: inline-block; height: inherit; float: right">
			<input id="searchPatient" type="text" name="searchPatient" placeholder="<spring:message code="navigation.search" />">
			<span class="ui-icon-search ui-icon" style="background"></span>
		</div>
</div>
<div>
		<div style="display: inline-block; height: inherit;">
			<ul id="nav">
					<li>
						<a class="navigation-button" id="home"  href="${pageContext.request.contextPath}/home">
							<spring:message code="navigation.home" />
						</a>
					</li>
					<li>
						<a class="navigation-button" id="list-patients" href="${pageContext.request.contextPath}/patient/list">
							<spring:message code="navigation.patientList" />
						</a>
					</li>
					<li>
						<a class="navigation-button" id="register-patient" href="${pageContext.request.contextPath}/patient/register">
							<spring:message code="navigation.patientRegister" />
						</a>
					</li>
			</ul>
		</div>
</div>
