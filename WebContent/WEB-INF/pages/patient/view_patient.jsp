<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- JSTL  -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!--  standard imports through out the app-->
<c:import url="/WEB-INF/pages/common/header.jsp" />

</head>

<body>
	<div id="navigation">
		<c:import url="/WEB-INF/pages/common/navigation.jsp" />
	</div>
	
	<div id="content">
		<h3>Paciente - ${patient.firstName} ${patient.lastName}</h3>
		<div>
			<div style="display: inline-block; width: 40%;">
				<label for="full-name">Nome:</label> <span>${patient.firstName}	${patient.lastName}</span><br />
				<label for="date-of-birth">Nascimento:</label><span><fmt:formatDate	value="${patient.dateOfBirth.time}" pattern="dd/MM/yyyy" /></span><br />
				<label for="ssn">CPF/RG:</label><span>${patient.ssnId}</span><br />
			</div>
			<div style="display: inline-block; width: 40%;">
				<label for="phone-number">Telefone:</label><span>${patient.phoneNumber}</span><br />
				<label for="mobile-number">Celular:</label><span>${patient.mobileNumber}</span><br />
				<label for="email">e-mail:</label><span>${patient.email}</span><br />
			</div>
		</div>
		<h3>Endereço</h3>
		<div>
			<c:forEach items="${patient.address}" var="address">
				<div>
					<div>
						<span>${address.street}&nbsp;${address.complements}&nbsp;${address.number}</span>
					</div>
					<div>
						<span>${address.district},&nbsp;${address.city}&nbsp;&#8211;&nbsp;${address.state},&nbsp;${address.zipcode}</span>
					</div>
					<div>
						<span>${address.country}</span>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>

	<div id="footer">
		<c:import url="/WEB-INF/pages/common/footer.jsp" />
	</div>
</body>
</html>