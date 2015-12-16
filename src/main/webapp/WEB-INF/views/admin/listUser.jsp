<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h2>User List</h2>
<hr>
<a href="<spring:url value="/admin/verifyStudents" />"
	title="Verify Student">Verify Student</a>
<hr>
<c:choose>
	<c:when test="${empty users}">
	No record of users found.
 </c:when>
	<c:otherwise>

		<table id="product-table">
			<tr>
				<th class="table-header-check"><a id="toggle-all"></a></th>
				<th class="table-header-repeat line-left"><a href="#">#</a></th>
				<th class="table-header-repeat line-left"><a href="#">User
						Name</a></th>
				<th class="table-header-repeat line-left"><a href="#">Email</a></th>
				<th class="table-header-repeat line-left"><a href="#">Status</a></th>
				<th class="table-header-repeat line-left"><a href="#">Options</a></th>
			</tr>
			<tbody>
				<c:forEach items="${users}" var="user" varStatus="count">
					<tr id="row-${user.id}">
						<td><input type="checkbox" /></td>
						<td>${count.count}</td>
						<td>${user.name}</td>
						<td>${user.email}</td>
						<td>${user.status}</td>	
						<td><a
							href="<spring:url value='/admin/user/changestatus/${user.id}?status=INACTIVE' />"
							>InActive</a>
							<a
							href="<spring:url value='/admin/user/changestatus/${user.id}?status=ACTIVE' />"
							>Active</a>
							<a
							href="<spring:url value='/admin/user/changestatus/${user.id}?status=DISABLED' />"
							>Disabled</a>
												
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:otherwise>
</c:choose>