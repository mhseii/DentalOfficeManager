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
<script type="text/javascript" src="resources/js/list_patients.js"></script>

<title>Pacientes</title>
</head>

<body>
	<div id="navigation">
		<c:import url="/WEB-INF/pages/common/navigation.jsp" />
	</div>
	<div id="content">
		<div class="ui-widget">
			<label class="search" for="searchPatient">Pesquisar:</label><input
				id="searchPatient" type="text" name="searchPatient" />
		</div>
		<br />
		<table>
			<tr>
				<th>Registro #</th>
				<th>Nome</th>
				<th>Sobrenome</th>
				<th>Data de Nascimento</th>
				<th>Contato</th>
			</tr>
			<c:forEach items="${patients}" var="patients">
				<tr>
					<td>${patients.id}</td>
					<td>${patients.firstName}</td>
					<td>${patients.lastName}</td>
					<td><fmt:formatDate value="${patients.birthDate.time}"
							pattern="dd/MM/yyy" /></td>
					<td>${patients.phoneNumber}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div id="footer">
		<c:import url="/WEB-INF/pages/common/footer.jsp" />
	</div>
</body>
</html>