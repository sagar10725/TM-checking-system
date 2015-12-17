<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h2>Student TM Sign Up Form</h2>

<c:choose>
	<c:when test="${empty availableEntries}">
	No available dates for TM Sign up.
 </c:when>
	<c:otherwise>

		<table id="product-table">
			<tr>
				<th class="table-header-check"><a id="toggle-all"></a></th>
				<th class="table-header-repeat line-left"><a href="#">#</a></th>
				<th class="table-header-repeat line-left"><a href="#">Number
						of available seats</a></th>
				<th class="table-header-repeat line-left"><a href="#">Checking
						Type</a></th>
				<th class="table-header-repeat line-left"><a href="#">Building</a></th>
				<th class="table-header-repeat line-left"><a href="#">Room</a></th>
				<th class="table-header-repeat line-left"><a href="#">Checked
						By</a></th>
				<th class="table-header-repeat line-options"><a href="#">Available
						Date</a></th>
			</tr>
			<tbody>
				<c:forEach items="${availableEntries}" var="availableEntry"
					varStatus="count">
					<tr id="row-${availableEntry.id}">
						<td><input type="checkbox" /></td>
						<td>${count.count}</td>
						<td>${availableEntry.availableSeats}</td>
						<td>${availableEntry.checkingType}</td>
						<td>${availableEntry.room.building.buildingName}</td>
						<td>${availableEntry.room.roomNumber}</td>
						<td>${availableEntry.addedBy.user.name}</td>
						<td>
							<table id="product-table">
								<c:forEach var="checkingHour"
									items="${availableEntry.checkingHours }">
									<tr>
										<td><fmt:formatDate type="both"
												value="${checkingHour.checkingDate}" /></td>
										<td><c:if test="${checkingHour.signUpBy == null}">
												<button onclick="signupForTM(${checkingHour.id})">Sign
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
	</c:otherwise>
</c:choose>

