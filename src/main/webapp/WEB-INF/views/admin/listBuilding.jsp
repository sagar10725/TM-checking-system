<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h2>Building List</h2>
<hr>
<h3>
	<a href="<spring:url value="/admin/building/add" />"
	title="Add Buidling">Add Building</a> - 
	<a href="<spring:url value="/admin/room/add" />" title="Add Room">Add
	Room</a></h3>
<hr>
<c:choose>
	<c:when test="${empty buildings}">
	No recored of buildings found.
 </c:when>
	<c:otherwise>
		<table id="product-table">
			<tr>
				<th class="table-header-check"><a id="toggle-all"></a></th>
				<th class="table-header-repeat line-left"><a href="#">#</a></th>
				<th class="table-header-repeat line-left"><a href="#">Building
						Name</a></th>
				<th class="table-header-repeat line-left"><a href="#">Rooms</a></th>
				<th class="table-header-options line-left"><a href="#">Options</a></th>
			</tr>
			<tbody>
				<c:forEach items="${buildings}" var="building" varStatus="count">
					<tr id="row-${count.count}">
						<td><input type="checkbox" /></td>
						<td>${count.count}</td>
						<td>${building.buildingName}</td>
						<td><c:forEach items="${building.rooms}" var="room">
										      	${room.roomNumber } <br />
							</c:forEach></td>
						<td><a
							href="<spring:url value="/admin/building/delete/${building.id}" />"
							title="Delete"
							onclick="return confirm('Are you sure to delete this building?')"
							class="icon-2 info-tooltip"></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:otherwise>
</c:choose>