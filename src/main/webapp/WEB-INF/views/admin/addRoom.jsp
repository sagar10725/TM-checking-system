<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h2>Add New Room</h2>
<hr>
<h3>
	<a href="<spring:url value="/admin/building" />" title="Back">Back</a>
</h3>
<form:form commandName="room" method="POST">
	<table>
		<tr>
			<td colspan="2"><form:errors path="*" class="error"
					cssStyle="color : red;" /></td>
		</tr>
		<tr>
			<td>Building: </td>
			<td><form:select id="building" path="building.id">
					<form:option value="0" label="--Select Building--" />
					<form:options items="${buildings}" itemLabel="buildingName" itemValue="id" />
				</form:select>
				<form:errors path="building.id" cssStyle="color : red;"></form:errors></td>
		</tr>
		<tr>
			<td>Room Number: </td>
			<td><form:input path="roomNumber" id="roomNumber" />
				<form:errors path="roomNumber" cssStyle="color : red;" /></td>
		</tr>
		<tr><td colspan="2">&nbsp;<td></tr>
		<tr>
			<td colspan="2"><input id="submit" type="submit" value="Save Room"></td>
		</tr>
	</table>


</form:form>

