<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
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
		$("input[type=submit],a").button();
	});
</script>

<title>Task Agenda</title>
</head>
<body>

	<div id="navigation">
		<c:import url="/WEB-INF/pages/navigation.jsp" />	
	</div>
	
	<div id="content">
		<h3>Record a new task</h3>
		
		<form id="taskForm" action="taskForm" method="post">
			Description: <br />
			<form:errors path="task.description" cssStyle="color:red" />
			<br />
			<textarea name="description" rows="5" cols="100"></textarea>
			<br /> 
			<input type="submit" value="submit" />
		</form>
	</div>
	
</body>
</html>