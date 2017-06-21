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
<script src="${pageContext.request.contextPath}/resources/js/register-patient.js"></script>

<title>Cadastro de Paciente</title>
</head>
<body>
	<div id="navigation">
		<c:import url="/WEB-INF/pages/common/navigation.jsp" />	
	</div>
	
	<div id="content">
		<h2>hello world</h2>
	</div>
	
	<div id="footer">
		<c:import url="/WEB-INF/pages/common/footer.jsp" />
	</div>

</body>
</html>