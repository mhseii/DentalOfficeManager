<head>
	<title>Pacientes</title>
	
	<!--  standard imports through out the app-->
	<%@ include file="/WEB-INF/pages/common/header.jsp" %>
</head>

<body>
	
	<div class="content">
		<%@ include file="/WEB-INF/pages/common/navigation.jsp" %>
		
		<div>
			<table>
				<tr>
					<th><spring:message code="login.user"/></th>
					<th><spring:message code="dateOfBirth"/></th>
					<th><spring:message code="contact"/></th>
				</tr>
				<c:forEach items="${users}" var="user">
					<tr id="${user.id}">
						<td>${user.username}</td>
						<td class="center" ><fmt:formatDate value="${user.dateOfBirth.time}" pattern="dd/MM/yyy" /></td>
						<td>${user.phoneNumber} <br /> ${user.mobileNumber}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		
		<div class="footer">
			<c:import url="/WEB-INF/pages/common/footer.jsp" />
		</div>
	</div>

</body>
</html>