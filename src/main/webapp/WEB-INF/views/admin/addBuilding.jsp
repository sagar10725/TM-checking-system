<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h2>Add New Building</h2>
<hr>
<h3>
	<a href="<spring:url value="/admin/building" />" title="Back">Back</a>
</h3>
<form:form commandName="building" method="POST">
	<table>
		<tr>
			<td colspan="2"><form:errors path="*" class="error"
					cssStyle="color : red;" /></td>
		</tr>
		<tr>
			<td>Building Name</td>
			<td><form:input path="buildingName" id="buildingName" /> <form:errors
					path="buildingName" cssStyle="color : red;" /></td>
		</tr>
		<tr><td colspan="2">&nbsp;<td></tr>
		<tr>
			<td colspan="2"><input id="submit" type="submit"
				value="Save Building"></td>
		</tr>
	</table>


</form:form>