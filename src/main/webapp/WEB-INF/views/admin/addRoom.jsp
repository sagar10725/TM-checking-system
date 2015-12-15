<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

	<h2>Add Room</h2><hr>
	<form:form commandName="room" method="POST">
			<p>
				<form:errors path="*" cssStyle="color : red;" />
			</p>
			<p>
			<form:label path="building" for="building">
					<spring:message code="building.buildingName" />
				</form:label>
				<form:select id="building" path="building.id">
					<form:option value="0" label="--Select Building--" />
					<form:options items="${buildings}" itemLabel="buildingName" itemValue="id" />
				</form:select>
				<form:errors path="building.id" cssStyle="color : red;"></form:errors>
			</p>
			<p>
				<form:label path="roomNumber" for="roomNumber">
					<spring:message code="room.roomNumber" />
				</form:label>
				<form:input path="roomNumber" id="roomNumber" />
				<form:errors path="roomNumber" cssStyle="color : red;" />
			</p>
			<p id="buttons">
				<input id="submit" type="submit" value="Save Room">
			</p>


	</form:form>
