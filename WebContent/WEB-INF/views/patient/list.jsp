<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- JQuery UI -->
<script type="text/javascript" src="resources/js/jquery.js"></script>
<script src="resources/css/external/jquery/jquery.js"></script>
<script src="resources/css/jquery-ui.js"></script>
<link href="resources/css/jquery-ui.css" rel="stylesheet"></link>

<!-- Custom CSS -->
<link href="resources/css/custom.css" rel="stylesheet"></link>

<!-- JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<title>Pacientes</title>

<script type="text/javascript">
	$(document).ready(function() {
		$("#searchPatient").autocomplete({
			minLength : 2,
			delay : 500,
			source : function(request, response) {
				$.getJSON('${pageContext.request.contextPath}/searchPatient', request, function(result) {
					response($.map(result, function(item) {
						return {
							// what is shown in the drop down menu
							label : item.firstName + " " + item.lastName,
							// what is shown in the text box
							// and what is defined for 'select' handler
							value : item,
						}
					}));
				});
			},
			select : function( event, ui ) {
				console.log(ui.item);
				if (ui.item){
					// reset the value of text box to the label
					// it would appear [object Object] otherwise
					$('#searchPatient').val(ui.item.value.firstName + " " +ui.item.value.lastName);
					$(this).val(ui.item.label);
					window.location.href = 'view_patient?id=' + ui.item.value.id;
					return false;
				} 
			}
		});
	})
</script>

<script type="text/javascript">
	$(function() {
		$("input[type=submit],a").button();
	});
</script>
</head>

<body>

	<div id="navigation">
		<c:import url="/WEB-INF/views/navigation.jsp" />
	</div>


	<div id="content">
		<div class="ui-widget">
			<label class="search" for="searchPatient">Pesquisar:</label><input id="searchPatient" type="text" name="searchPatient" />
		</div>
		<br />
		<table>
			<tr>
				<th>Registro #</th>
				<th>Nome</th>
				<th>Sobrenome</th>
				<th>Data de Nascimento</th>
				<th>Contato</th>
			</tr>
			<c:forEach items="${patients}" var="patients">
				<tr>
					<td>${patients.id}</td>
					<td>${patients.firstName}</td>
					<td>${patients.lastName}</td>
					<td><fmt:formatDate value="${patients.birthDate.time}"
							pattern="dd/MM/yyy" /></td>
					<td>${patients.phoneNumber}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<div id="footer">
		<c:import url="/WEB-INF/views/footer.jsp" />
	</div>
</body>
</html>