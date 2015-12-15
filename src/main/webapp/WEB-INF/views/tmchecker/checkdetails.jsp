<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

  	<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
	<script type="text/javascript" src="<spring:url value="/resource/js/ajax.js"/>"></script>
<title>Insert title here</title>
</head>
<body>
	<h1>Checking Details</h1>
	<form:form commandName="tmhistory" action="checkingform" method="POST">
		<table>
			<tr>
				<td colspan="2"><form:errors path="*" class="error" /></td>
			</tr>
			<tr>
				<td>Buildings:</td>
				<td><form:select path="" id="building" onchange="showRooms()">
					<form:option value="NONE" label="--- Select ---" />
						<c:forEach var="building" items="${buildings}">
							<form:option value="${building.id }">${building.buildingName }</form:option>
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td>Rooms:</td>
				<td><form:select id= "room" path="room.id">
						<form:option value="NONE" label="--- Select ---" />
					</form:select></td>
			</tr>
			 <tr>
				<td>Time: </td>
				<td>
				<form:select path="signUpDate">
						<form:option value="NONE" label="--- Select ---" />
						<form:options items="${signUpDate}" />
					</form:select>
			</tr> 

			<tr>
				<td>Checking Type:</td>
				<td><form:select path="checkingType">
						<form:option value="NONE" label="--- Select ---" />
						<form:options items="${checkingtype}" />
					</form:select></td>
			</tr>



			<tr>
				<td colspan="2"><input type="submit" value="Save Changes" /></td>
				<td colspan="2"><input type="reset" value="Cancel"
					name="cancel" /></td>
			</tr>
		</table>


	</form:form>
</body>
</html>