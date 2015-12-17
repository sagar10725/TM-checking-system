<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h2>Change Checking Status</h2>
<hr>
<c:choose>
	<c:when test="${empty tmHistories}">
	No record of TM History found.
 </c:when>
	<c:otherwise>

		<table id="product-table">
			<tr>
				<th class="table-header-check"><a id="toggle-all"></a></th>
				<th class="table-header-repeat line-left"><a href="#">#</a></th>
				<th class="table-header-repeat line-left"><a href="#">Checking
						Type</a></th>
				<th class="table-header-repeat line-left"><a href="#">Checking
						Date</a></th>
				<th class="table-header-repeat line-left"><a href="#">Room & Building</a></th>
				<th class="table-header-repeat line-left"><a href="#">Student Name</a></th>
				<th class="table-header-repeat line-left"><a href="#">Student ID</a></th>
				<th class="table-header-repeat line-left"><a href="#">Status</a></th>
				<th class="table-header-repeat line-left"><a href="#">Option</a></th>
			</tr>
			<tbody>
				<c:forEach items="${tmHistories}" var="tmHistory" varStatus="count">
					<tr id="row-${tmhistory.id}">
						<td><input type="checkbox" /></td>
						<td>${count.count}</td>
						<td>${tmHistory.checkingType}</td>
						<td><fmt:formatDate type="both"
								value="${tmHistory.checkingHours.checkingDate}" /></td>
						<td>${tmHistory.room.building.buildingName}, ${tmHistory.room.roomNumber}</td>
						<td>${tmHistory.student.user.name}</td>
						<td>${tmHistory.student.studentId}</td>
						<td>${tmHistory.status}</td>
						<td><a
							href="<spring:url value='/tmchecker/changetmstatus/${tmHistory.id}?status=PENDING' />">PENDING</a> -
							<a
							href="<spring:url value='/tmchecker/changetmstatus/${tmHistory.id}?status=CHECKED' />">CHECKED</a> -
							<a
							href="<spring:url value='/tmchecker/changetmstatus/${tmHistory.id}?status=MISSED' />">MISSED</a> -
							<a
							href="<spring:url value='/tmchecker/changetmstatus/${tmHistory.id}?status=CANCELLED' />">CANCELLED</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:otherwise>
</c:choose>