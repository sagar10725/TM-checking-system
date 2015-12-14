<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javascript"
	src="<spring:url value="/resource/js/ajax.js"/>"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Building</title>
</head>
<body>
	<h2>Registration</h2>
	<form:form commandName="building" method="POST">
		<fieldset>
			<legend>New Building Entry</legend>
			<p>
				<form:errors path="*" cssStyle="color : red;" />
			</p>
			<p>
				<form:label path="buildingName" for="buildingName">
					<spring:message code="building.buildingName" />
				</form:label>
				<form:input path="buildingName" id="buildingName" />
				<form:errors path="buildingName" cssStyle="color : red;" />
			</p>
			<p id="buttons">
				<input id="submit" type="submit" value="Save Building">
			</p>


		</fieldset>
	</form:form>

	<form:form id="roomForm" method="POST">
		<p>
			<spring:message code="room.roomNumber" />
			<input type="text" name="roomNumber" /> <input type="button"
				value="Add Room" onclick="saveRoom();">
		</p>
		<!-- Success and Validation errors -->
		<div id="errors" style="display: none"></div>
		<div id="formInput" style="display: none"></div>


	</form:form>

</body>
</html>