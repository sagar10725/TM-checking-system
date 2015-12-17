<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script type="text/javascript"
	src='<spring:url value="/resources/js/jquery-1.10.1.min.js" />'></script>
<script type="text/javascript"
	src='<spring:url value="/resources/js/ajax.js"/>'></script>
<h1>New Checking Entry</h1>
	<form:form method="post" modelAttribute="tmhistory">
		<table>
			<tr>
				<td colspan="2"><form:errors path="*" class="error" /></td>
			</tr>
			<tr>
				<td>Student ID :</td>
				<td>
				<form:select path="student.id" id="student" >
						<form:option value="" label="Select Student" />
						<c:forEach var="student" items="${students}">
							<form:option value="${student.id }">${student.studentId }</form:option>
						</c:forEach>
					</form:select><form:errors
						path="student.studentId" class="error" /></td>
			</tr>
			<tr>
				<td>Buildings:</td>
				<td><form:select path="" id="building" onchange="showRooms()">
						<form:option value="" label="Select Building" />
						<c:forEach var="building" items="${buildings}">
							<form:option value="${building.id }">${building.buildingName }</form:option>
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td>Rooms:</td>
				<td><form:select id="room" path="room.id">
						<form:option value="" label="Select Room" />
					</form:select></td>
			</tr>
			<tr>
				<td>Checking Date :</td>
				<td><form:input path="checkedDate" /> <form:errors
						path="checkedDate" class="error" /></td>
			</tr>
			<tr>
				<td>Checking Type :</td>
				<td><form:select path="checkingType">
						<form:options items="${checkingtype}" />
					</form:select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Save Entry" />
				<input type="reset" value="Reset" /></td>
			</tr>
		</table>
	</form:form>