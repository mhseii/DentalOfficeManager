<head>
	<title>Pacientes</title>
	
	<!--  standard imports through out the app-->
	<%@ include file="/WEB-INF/pages/common/header.jsp" %>

	<!-- page javascript  -->
	<script src="${pageContext.request.contextPath}/resources/js/list-patients.js"></script>
</head>

<body>
	
	<div class="content">
		<%@ include file="/WEB-INF/pages/common/navigation.jsp" %>
		
		<div>
			<table style="border: thin;">
				<tr>
					<th><spring:message code="firstName" /></th>
					<th><spring:message code="document" /></th>
					<th><spring:message code="dateOfBirth" /></th>
					<th><spring:message code="contact" /></th>
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
		
		<div class="footer">
			<c:import url="/WEB-INF/pages/common/footer.jsp" />
		</div>
	</div>

</body>