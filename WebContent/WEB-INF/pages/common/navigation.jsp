<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <div>
		<div style="display: inline-block; height: inherit;">
			<h1>Dental Office Manager</h1>
		</div>
		<div class="ui-widget" style="display: inline-block; height: inherit; float: right">
			<input id="searchPatient" type="text" name="searchPatient" placeholder="buscar"><span class="ui-icon-search ui-icon" style="background"></span>
		</div>
</div>
<div>
		<div style="display: inline-block; height: inherit;">
			<ul id="nav">
					<li><a class="navigation-button" id="home"  href="${pageContext.request.contextPath}/home">Início</a></li>
					<li><a class="navigation-button" id="list-patients" href="${pageContext.request.contextPath}/patient/list">Pacientes</a></li>
					<li><a class="navigation-button" id="register-patient" href="${pageContext.request.contextPath}/patient/register">Registrar Pacientes</a></li>
			</ul>
		</div>
</div>
