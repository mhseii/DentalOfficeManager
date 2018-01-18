<head>
	<title>teste</title>
	<!--  standard imports through out the app-->
	<%@ include file="/WEB-INF/pages/common/header.jsp" %>
	<!-- page javascript  -->
	<script src="${pageContext.request.contextPath}/resources/js/test.js"></script>
	<!-- test page custom css only -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/test.css"></link>
</head>

<body>
	<section>
		<div class="navigation">
			<c:import url="/WEB-INF/pages/common/navigation.jsp" />	
		</div>
		<div class="main">
		
			<form id="testform">
				<ul id="progressbar">
					<li class="active">personal data</li>
					<li>address</li>
					<li>anamnesis</li>		
				</ul>
				
				<fieldset>
					<h2 class="fs-title">personal data</h2>
					<input type="text" name="name" placeholder="first name"/>
					<input type="text" name="lastname" placeholder="last name"/>
					<input type="text" name="email" placeholder="email"/>
					<input class="next action-button" type="button" name="next" value="next"/>
				</fieldset>
				
				<fieldset>
					<h2 class="fs-title">address</h2>
					<input type="text" name="street" placeholder="1001 av. paulista, jd bela vista"/>
					<input type="text" name="city" placeholder="são paulo"/>
					<input type="text" name="state" placeholder="sp"/>
					<input class="previous action-button" type="button" name="previous" value="previous"/>
					<input class="next action-button" type="button" name="next" value="next"/>
				</fieldset>
				
				<fieldset>
					<h2 class="fs-title">anamnesis</h2>
					<input type="text" name="name" placeholder="first name"/>
					<input type="text" name="lastname" placeholder="last name"/>
					<input type="text" name="email" placeholder="email"/>
					<input class="previous action-button" type="button" name="previous" value="previous"/>
					<input class="submit action-button" type="submit" name="submit" value="submit"/>
				</fieldset>
			</form>
		</div>
	</section>
</body>