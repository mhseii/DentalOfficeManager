<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<link href="resources/css/jquery-ui.css" rel="stylesheet"></link>
<link href="resources/css/custom.css" rel="stylesheet"></link>

<script type="text/javascript">
	$(function() {
		$("a").button();
	});
</script>

<td>${task.id}</td>
<td>${task.description}</td>
<td>Finalizada</td>
<td><fmt:formatDate value="${task.endDate.time}"
		pattern="dd/MM/yyyy" /></td>
<td><a href="removeTask?id=${task.id}">Remover</a></td>
<td><a href="viewTask?id=${task.id}">Visualizar</a></td>
