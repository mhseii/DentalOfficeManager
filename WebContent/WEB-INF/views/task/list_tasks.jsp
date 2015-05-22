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
		$("a").button();
	});
</script>

<script type="text/javascript">
	function finishTask(id){
		$.post("finishThisTask", {'id':id}, function(response){
			$("#task_"+id).html(response);
			alert("Tarefa Finalizada!");
		});
	}
</script>

<title>Lista de tarefas</title>
</head>

<body>
	<div id="navigation">
		<c:import url="/WEB-INF/views/navigation.jsp" />	
	</div>
	
	<div id="content">
		<table>
			<tr>
				<th>Registro</th>
				<th>Descrição</th>
				<th>Finalizada?</th>
				<th>Término</th>
			</tr>
			<c:forEach items="${tasks}" var="task">
				<tr id="task_${task.id}">
					<td>${task.id}</td>
					<td>${task.description}</td>
					<c:if test="${task.finished eq true}">
						<td>Finalizada</td>
					</c:if>
					<c:if test="${task.finished eq false}">
						<td>
							<a href="#" onClick="finishTask(${task.id})"> Finalizar </a>
						</td>
					</c:if>
					<td><fmt:formatDate value="${task.endDate.time}"
							pattern="dd/MM/yyyy" /></td>
					<td><a href="removeTask?id=${task.id}" >Remover</a></td>
					<td><a href="viewTask?id=${task.id}">Visualizar</a></td>
				</tr>
			</c:forEach>
		</table>
		<br />
		<br />
		<a href="registerTask">Registrar nova tarefa</a>
	</div>
	
</body>
</html>