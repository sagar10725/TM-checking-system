<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="application.name" text="TM Check" /></title>
<style type="text/css">
@import url(resources/css/style.css);
</style>
</head>
<body>
	<spring:message code="application.name" text="TM Check" />
	<h1>Student TM Sign Up Details</h1>

	<table>
		<thead>
			<tr>
				<th>SN</th>
				<th>Checking Type</th>
				<th>Checking Date</th>
				<th>Building</th>
				<th>Room</th>
				<th>Checked By</th>
				<th>Status</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="tmHistory" items="${tmHistories}">
				<tr>
					<td>${tmHistory.id}</td>
					<td>${tmHistory.checkingType}</td>
					<td><fmt:formatDate type="both"
								value="${tmHistory.checkingHours.checkingDate}" /></td>
					<td>${tmHistory.room.building.buildingName}</td>
					<td>${tmHistory.room.roomNumber}</td>
					<td><c:if test="${tmHistory.checkedBy != null}">
					${tmHistory.checkedBy.user.name}
					</c:if></td>
					<td>${tmHistory.status}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

</body>
</html>