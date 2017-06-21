<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- JSTL  -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>

<!--  standard imports through out the app-->
<c:import url="/WEB-INF/pages/common/header.jsp" />

<!-- page javascript  -->
<script src="${pageContext.request.contextPath}/resources/js/list-patients.js"></script>

<title>Pacientes</title>
</head>

<body>
	<div id="navigation">
		<c:import url="/WEB-INF/pages/common/navigation.jsp" />
	</div>
	
	<div id="content">
		<table>
			<tr>
				<th>Nome</th>
				<th>CPF/RG</th>
				<th>Data de Nascimento</th>
				<th>Contato</th>
			</tr>
			<c:forEach items="${patients}" var="patient">
				<tr id="${patient.id}" onclick="selectPatient(this);">
					<td>${patient.firstName} ${patient.lastName}</td>
					<td>${patient.ssnId}</td>
					<td class="center" ><fmt:formatDate value="${patient.dateOfBirth.time}"
							pattern="dd/MM/yyy" /></td>
					<td>${patient.phoneNumber} <br /> ${patient.mobileNumber}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div id="footer">
		<c:import url="/WEB-INF/pages/common/footer.jsp" />
	</div>
</body>
</html>