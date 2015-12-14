<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Building List</title>
</head>
<body>
<a href="<spring:url value="/admin/building/add" />" title="Add Buidling">Add Building</a>
<a href="<spring:url value="/admin/room/add" />" title="Add Room">Add Room</a>
	<table class="table">
		<thead>
			<tr>
				<th width="5%">#</th>
				<th width="30%">Building Name</th>
				<th width="25%">Rooms</th>
				<th width="15%">Action</th>
			</tr>
		</thead>
		<tbody id="buildinglist">
			<c:forEach items="${buildings}" var="building" varStatus="count">
				<tr id="row-${count.count}">
					<td>${count.count}</td>
					<td>${building.buildingName}</td>
					<td><c:forEach items="${building.rooms}" var="room">
										      	${room.roomNumber } ,
						</c:forEach></td>
					<td>
						<a
						href="<spring:url value="/admin/building/delete/${building.id}" />"
						title="Delete"
						onclick="return confirm('Are you sure to delete this building?')">Delete</a></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

</body>
</html>