<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h2>User List</h2>
<hr>
<h3>
	<a href="<spring:url value="/admin/student/verify" />"
		title="Verify Student">Verify Student</a>
</h3>
<hr>
<c:choose>
	<c:when test="${empty students}">
	No record of students found.
 </c:when>
	<c:otherwise>

		<table id="product-table">
			<tr>
				<th class="table-header-check"><a id="toggle-all"></a></th>
				<th class="table-header-repeat line-left"><a href="#">#</a></th>
				<th class="table-header-repeat line-left"><a href="#">Student
						Name</a></th>
				<th class="table-header-repeat line-left"><a href="#">Student
						ID</a></th>
				<th class="table-header-repeat line-left"><a href="#">Email</a></th>
				<th class="table-header-repeat line-left"><a href="#">Entry
						Year</a></th>
				<th class="table-header-repeat line-left"><a href="#">Entry
						Month</a></th>
				<th class="table-header-repeat line-left"><a href="#">Status</a></th>
			</tr>
			<tbody>
				<c:forEach items="${students}" var="student" varStatus="count">
					<tr id="row-${student.id}">
						<td><input type="checkbox" /></td>
						<td>${count.count}</td>
						<td>${student.user.name}</td>
						<td>${student.studentId}</td>
						<td>${student.user.email}</td>
						<td>${student.entryYear}</td>
						<td>${student.entryMonth}</td>
						<td>${student.user.status}</td>						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:otherwise>
</c:choose>