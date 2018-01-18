<head>
	<title>DentalOfficeManager - Login</title>
	<!--  standard imports through out the app-->
	<%@ include file="/WEB-INF/pages/common/header.jsp" %>
	<script type="application/javascript" src="${pageContext.request.contextPath}/resources/js/login.js" ></script>
</head>

<body>
	<div class="content">
		<div>
			<div style="text-align: center;">
				<h1><spring:message code="navigation.title"/></h1>
			</div>
			<div>
				<form id="login-form" class="login" method="post">
					<fieldset>
						<div>
							<label for="username"><input type="text" id="username" name="username"/>
								<span class="ui-icon ui-icon-person"></span>
							</label>
						</div>
						<div>
							<label for="password"><input type="password" id="password" name="password"/>
								<span class="ui-icon ui-icon-key"></span>
							</label>
						</div>
					</fieldset>
					<div style="text-align: center;">
						<input type="submit" id="sign-in" value="<spring:message code="login.sign-in"/>"/>
					</div>
				</form>
				<input type="submit" id="recover-password" value="<spring:message code="login.pass-recover"/>"/>
			</div>
		</div>
	</div>
</body>