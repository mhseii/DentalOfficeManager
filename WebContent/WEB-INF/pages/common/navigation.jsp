<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
 
<div>
	<div class="header">
		<h1><spring:message code="navigation.title"/></h1>
	</div>
	<div class="ui-widget search-box">
		<input id="searchPatient" type="text" name="searchPatient" 
			placeholder="<spring:message code="navigation.search"/>"/>
		<label><span class="ui-icon-search ui-icon"></span></label>
	</div>
</div>
<div>
	<div class="navigation-items">
		<ul class="navigation-list">
			<li>
				<button class="navigation-button" id="home" 
					onclick="javascript:changePage('${pageContext.request.contextPath}/home')">
					<spring:message code="navigation.home" />
				</button>
			</li>
			<li>
				<button class="navigation-button" id="list-patients" 
					onclick="javascript:changePage('${pageContext.request.contextPath}/patient/list')">
					<spring:message code="navigation.patientList" />
				</button>
			</li>
			<li>
				<button class="navigation-button" id="register-patient" 
					onclick="javascript:changePage('${pageContext.request.contextPath}/patient/register')">
					<spring:message code="navigation.patientRegister" />
				</button>
			</li>
			<li>
				<button class="navigation-button" id="list-users" 
					onclick="javascript:changePage('${pageContext.request.contextPath}/user/list')">
					<spring:message code="navigation.usersList" />
				</button>
			</li>
			<li>
				<button class="navigation-button" id="register-user" 
					onclick="javascript:changePage('${pageContext.request.contextPath}/user/register')">
					<spring:message code="navigation.userRegister" />
				</button>
			</li>
		</ul>
	</div>
</div>