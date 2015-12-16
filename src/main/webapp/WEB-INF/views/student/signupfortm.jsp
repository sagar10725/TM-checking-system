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
<script type="text/javascript"
	src='<spring:url value="/resources/js/jquery-1.10.1.min.js" />'></script>
<script type="text/javascript"
	src='<spring:url value="/resources/js/ajax.js"/>'></script>
</head>
<body>
	<spring:message code="application.name" text="TM Check" />
	<h1>Student TM Sign Up Form</h1>

	<table>
		<thead>
			<tr>
				<th>Entry ID</th>
				<th>Number of available seats</th>
				<th>Checking Type</th>
				<th>Building</th>
				<th>Room</th>
				<th>Checked By</th>
				<th>Available Date</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="availableEntry" items="${availableEntries}">
				<tr>
					<td>${availableEntry.id}</td>
					<td>${availableEntry.availableSeats}</td>
					<td>${availableEntry.checkingType}</td>
					<td>${availableEntry.room.building.buildingName}</td>
					<td>${availableEntry.room.roomNumber}</td>
					<td>${availableEntry.addedBy.user.name}</td>
					<td>
						<table>
							<c:forEach var="checkingHour"
								items="${availableEntry.checkingHours }">
								<tr>
									<td><fmt:formatDate type="both"
											value="${checkingHour.checkingDate}" /></td>
									<td><c:if test="${availableEntry.availableSeats > 0}">
											<button
												onclick="signupForTM(${checkingHour.id})">Sign
												Up</button>
										</c:if></td>
								</tr>

							</c:forEach>
						</table>
					</td>

				</tr>
			</c:forEach>

		</tbody>
	</table>

</body>
</html>