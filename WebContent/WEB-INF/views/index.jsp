<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script type="text/javascript" src="resources/js/jquery.js"></script>
<script src="resources/css/external/jquery/jquery.js"></script>
<script src="resources/css/jquery-ui.js"></script>

<link href="resources/css/jquery-ui.css" rel="stylesheet"></link>
<link href="resources/css/custom.css" rel="stylesheet"></link>

<script type="text/javascript">
	$(function() {
		$("a, input[type=submit]").button();
	});
</script>
<title>Dental Office Manager</title>
</head>

<body>
	<div id="navigation">
		<c:import url="navigation.jsp" />
	</div>
	
	<div id="content">
	
	</div>
	
	<div id="footer">
		<c:import url="/WEB-INF/views/footer.jsp" />
	</div>
</body>
</html>