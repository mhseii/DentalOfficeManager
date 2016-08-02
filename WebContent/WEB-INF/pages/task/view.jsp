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
		$("#datepicker").datepicker({
			showAnim : "drop",
			dateFormat : "dd/mm/yy",
			changeMonth : true,
			changeYear : true
		})
	});
	
	
	$(function() {
		$("input[type=submit],a").button();
	});
</script>

</head>

<body>

	<div id="navigation">
		<c:import url="/WEB-INF/pages/navigation.jsp"></c:import>
	</div>

	<div id="content">
		<h3>Inspect Task - ${task.id}</h3>
		<form action="alterTask" method="post">

			<input type="hidden" name="id" value="${task.id}" /> <br />
			
			Description: <br />
			<textarea name="description" rows="5" cols="100">${task.description}</textarea>
			<br /> 
			
			Finished ? 
			<input type="checkbox" name="finished" value="true" ${task.finished? 'checked':''} /> 
			<br /> 
				
			End Date: <input type="text"
				name="endDate" id="datepicker"
				value="<fmt:formatDate 
					value="${task.endDate.time}" pattern="dd/MM/yyyy" />"
				readonly="readonly" /> 
				
			<br /> 
			<input type="submit" value="alter" />
		</form>
	</div>
	
	<div id="footer">
		<c:import url="/WEB-INF/pages/footer.jsp"></c:import>
	</div>
</body>
</html>
