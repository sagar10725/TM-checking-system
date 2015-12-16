<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h2>Add Building</h2><hr>
<form:form commandName="building" method="POST">

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


</form:form>