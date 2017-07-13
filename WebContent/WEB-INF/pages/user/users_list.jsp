<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<!-- JSTL  -->
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<head>
	<title>Pacientes</title>
	
	<!--  standard imports through out the app-->
	<c:import url="/WEB-INF/pages/common/header.jsp" />
</head>

<body>
	
	<div class="content">
		<div class="navigation">
			<c:import url="/WEB-INF/pages/common/navigation.jsp" />
		</div>
		
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