<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>

	<!-- JSTL  -->
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<head>
	<!--  standard imports through out the app -->
	<c:import url="/WEB-INF/pages/common/header.jsp" />

	<title>Dental Office Manager</title>
</head>
<body>
	<div class="content">
		<div class="navigation">
			<c:import url="/WEB-INF/pages/common/navigation.jsp" />
		</div>
		
		<div class="footer">
			<c:import url="/WEB-INF/pages/common/footer.jsp" />
		</div>
	</div>
</body>

</html>