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

<!-- page js  -->
<script type="text/javascript" src="resources/js/arrange_appointment.js"></script>

<title>Agendar horário</title>

<style>
label, input, button {
	display: block;
}

label {
	padding-top: 5px;
}

input.text {
	margin-bottom: 12px;
	width: 95%;
	padding: .4em;
}
</style>

</head>
<body>

	<div id="navigation">
		<c:import url="/WEB-INF/pages/common/navigation.jsp"></c:import>
	</div>

	<div id="content">
		<form id="arrangementForm"
			action="/DentalOfficeManager/arrangementForm" method="post">
			<fieldset>
				<div id="searchPatientDiv" title="Agendar consulta">
					<label id="patient-label" for="patient"> Nome: </label> <input
						id="patientName" type="text" name="patient"
						class="text ui-widget-content ui-corner-all" />

					<button id="searchPatient" name="searchPatient" type="button">buscar</button>

					<label for="patientBirthDate">Data de Nascimento: </label> 
					<input id= "patientBirthDate" type="text" name="patientBirthDate" disabled="disabled" class="text ui-widget-content ui-corner-all" /> 
					<label for="patientCpf">CPF:</label> 
					<input id="patient-ssn" type="text" name="patientCpf" disabled="disabled" class="text ui-widget-content ui-corner-all" /> 
					<label for="patientPhone">Telefone: </label> 
					<input id="patientPhone" type="text" name="patientPhone" disabled="disabled" class="text ui-widget-content ui-corner-all" />
				</div>
				<div id="patientAddressFields">
					<label id="PatientAddress" for="patientAddress"></label>
					<div id="inlineDiv">
						<label id="patientAddressStreet" for="patientAddressStreet">Logradouro:</label>
						<input id="patientAddressStreet" type="text"
							name="patientAddressStreet" disabled="disabled"
							class="text ui-widget-content ui-corner-all" /> <label
							id="patientAddressNumber" for="patientAddressNumber">No.:</label>
						<input id="patientAddressNumber" type="text"
							name="patientAddressNumber" disabled="disabled"
							class="text ui-widget-content ui-corner-all" />
					</div>
					<div id="inlineDiv">
						<label id="patientAddressDistrict" for="patientAddressDistrict">Bairro:</label>
						<input id="patientAddressDistrict" type="text"
							name="patientAddressDistrict" disabled="disabled"
							class="text ui-widget-content ui-corner-all" /> <label
							id="patientAddressState" for="patientAddressState">UF:</label> <input
							id="patientAddressState" type="text" name="patientAddressState"
							disabled="disabled" class="text ui-widget-content ui-corner-all" />
					</div>
					<div>
						<label id="patientAddressZipCode" for="patientAddressZipCode">CEP:</label>
						<input id="patientAddressZipCode" type="text"
							name="patientAddressZipCode" disabled="disabled"
							class="text ui-widget-content ui-corner-all" />
					</div>
				</div>
	</div>
	<div id="inlineDiv">
		<label id="date-label" for="data">data: </label><input type="text"
			id="datepicker" name="date" /> <select id="hour" name="hour">
			<option>9</option>
			<option>10</option>
			<option>11</option>
			<option>14</option>
			<option>15</option>
			<option>16</option>
			<option>17</option>
			<option>18</option>
		</select> <label id="time-label" for="hour">h</label> <select id="minute"
			name="minute">
			<option>00</option>
			<option>30</option>
		</select> <label id="time-label" for="minute">m</label>
		</fieldset>
		</form>
	</div>

	<div id="dialog-form" title="Create new user">
		<p class="validateTips">All form fields are required.</p>
		<form>
			<fieldset>
				<label for="name">Name</label> <input type="text" name="name"
					id="name" value="Jane Smith"
					class="text ui-widget-content ui-corner-all"> <label
					for="email">Email</label> <input type="text" name="email"
					id="email" value="jane@smith.com"
					class="text ui-widget-content ui-corner-all"> <label
					for="password">Password</label> <input type="password"
					name="password" id="password" value="xxxxxxx"
					class="text ui-widget-content ui-corner-all">

				<!-- Allow form submission with keyboard without duplicating the dialog button -->
				<input type="submit" tabindex="-1"
					style="position: absolute; top: -1000px">
			</fieldset>
		</form>
	</div>

	<div id="footer">
		<c:import url="/WEB-INF/pages/common/footer.jsp"></c:import>
	</div>
</body>

</html>