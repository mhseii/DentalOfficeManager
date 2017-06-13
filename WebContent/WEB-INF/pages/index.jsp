<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>

	<head>
		<!-- JSTL  -->
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
		<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
		
		<!--  standard imports through out the app -->
		<c:import url="/WEB-INF/pages/common/header.jsp" />
	
		<title>Dental Office Manager</title>
	</head>
	
	<body>
		<div id="location-selector" style="position: relative; float: right;">
			<select id="language">
			<c:forEach items="${countries}" var="country">
				<option id="${country.abbr}" value="${country.countryId}">${country.name}</option>
			</c:forEach>
			</select>
		</div>
	
		<div id="navigation">
			<c:import url="/WEB-INF/pages/common/navigation.jsp" />
		</div>
		
		<div id="content" style="text-align: center;">
	
		</div>
		
		<div id="footer">
			<c:import url="/WEB-INF/pages/common/footer.jsp" />
		</div>
	</body>
	
</html>