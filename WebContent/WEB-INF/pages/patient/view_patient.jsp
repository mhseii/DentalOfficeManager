<head>
	<title>Paciente</title>

	<!--  standard imports through out the app-->
	<%@ include file="/WEB-INF/pages/common/header.jsp" %>
	
	<!-- page javascript  -->
	<script src="${pageContext.request.contextPath}/resources/js/view-patient.js"></script>
</head>

<body>
	<c:import url="/WEB-INF/pages/common/modal/confirmation-dialog.jsp" />
	<c:set var="patientFullName" value="${patient.firstName} ${patient.lastName}" />
	
	<input type="hidden" id="dialog-title" value="<spring:message code="dialog.title.update-patient"/>"/>
	<input type="hidden" id="dialog-confirm" value="<spring:message code="dialog.button.confirm" />"/>
	<input type="hidden" id="dialog-cancel" value="<spring:message code="dialog.button.cancel" />"/>
	<input type="hidden" id="dialog-span-message" value="<spring:message code="dialog.message" arguments="${patientFullName}"/>"/>
	
	<div class="content justified">
	
	<%@ include file="/WEB-INF/pages/common/navigation.jsp" %>
	
	<section class="main">
		<input type="hidden" id="isEditing" value=""/> 
		<form id="patient-udpate-form">
			<fieldset>
				<legend><spring:message code="patient" /> - ${patientFullName}</legend>
				<div class="div-table">
					<input name="patientId" hidden="true" value="${patient.id}" />
					<div class="div-table-row">
						<div class="div-table-cell">
							<label for="first-name">
								<spring:message code="firstName" />:<span id="firstName" class="patient-info non-editable">${patient.firstName}</span>
								<input type="hidden" name="firstName" value="${patient.firstName}" />
							</label>
						</div>
						<div class="div-table-cell right">
							<label for="last-name">
								<spring:message code="lastName" />:<span id="lastName" class="patient-info non-editable">${patient.lastName}</span>
								<input type="hidden" name="lastName" value="${patient.lastName}" />
							</label>
						</div>
					</div>
					<div class="div-table-row">
						<div class="div-table-cell">
							<label for="date-of-birth">
								<spring:message code="dateOfBirth" />:<span id="dateOfBirth" class="patient-info non-editable"><fmt:formatDate value="${patient.dateOfBirth.time}" pattern="dd/MM/yyyy" /></span>
								<input type="hidden" name="dateOfBirth" value="${patient.dateOfBirth}" />
							</label>
						</div>
						<div class="div-table-cell right">
							<label for="ssn">
								<spring:message code="document" />:<span id="ssn.id" class="patient-info non-editable">${patient.ssnId}</span>
								<input type="hidden" name="ssnType" value="${patient.ssnType}" />
								<input type="hidden" name="ssnId" value="${patient.ssnId}" />
							</label><br />
						</div>
					</div>
					<div class="div-table-row">
						<div class="div-table-cell">
							<label for="phone-number">
								<spring:message code="phone" />:<span id="phoneNumber" class="patient-info editable">${patient.phoneNumber}</span>
							</label>
						</div>
						<div class="div-table-cell right">
							<label for="mobile-number">
								<spring:message code="mobile" />:<span id="mobileNumber" class="patient-info editable">${patient.mobileNumber}</span>
							</label>
						</div>
					</div>
					<div class="div-table-row">
						<div class="div-table-cell">
							<label for="email">
								<spring:message code="email" />:<span id="email" class="patient-info editable">${patient.email}</span>
							</label>
						</div>
					</div>
				</div>
			</fieldset>
			<fieldset>
				<legend><spring:message code="address" /></legend>
				<div class="div-table">
					<c:forEach items="${patient.address}" var="address">
						<div>
							<div>
								<input name="addressId" hidden="true" value="${address.id}" />
								<span id="addressStreet" class="patient-info editable">${address.street}</span>&nbsp;
								<span id="addressComplements" class="patient-info editable">${address.complements}</span>&nbsp;
								<span id="addressNumber" class="patient-info editable">${address.number}</span>
							</div>
							<div>
								<span id="addressDistrict" class="patient-info editable">${address.district}</span>,
								<span id="addressCity" class="patient-info editable">${address.city}</span>&nbsp;&#8211;
								<span id="addressState" class="patient-info editable">${address.state}</span>&nbsp;
							</div>
							<div>
								<span id="addressZipCode" class="patient-info editable">${address.zipcode}</span>&nbsp;
								<span id="addressCountry" class="patient-info editable">${address.country}</span>
							</div>
						</div>
					</c:forEach>
				</div>
				<div style="float:right;">
					<input type="button" id="update" value="<spring:message code="button.update"/>">
					<input type="button" id="edit" value="<spring:message code="button.edit"/>">
				</div>
			</fieldset>
		</form>
	</section>
	
	<div class="footer"><c:import url="/WEB-INF/pages/common/footer.jsp" /></div>
	
	</div>

</body>