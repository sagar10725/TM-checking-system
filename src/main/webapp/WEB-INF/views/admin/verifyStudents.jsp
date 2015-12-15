<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Verify Students</title>
</head>
<body>
	<table border="0" width="100%" cellpadding="0" cellspacing="0"
		id="product-table">
		<tr>
			<th class="table-header-check"><a id="toggle-all"></a></th>
			<th class="table-header-repeat line-left"><a href="#">#</a></th>
			<th class="table-header-repeat line-left"><a href="#">Student Name</a></th>
			<th class="table-header-repeat line-left"><a href="#">Student ID</a></th>
			<th class="table-header-repeat line-left"><a href="#">Email</a></th>
			<th class="table-header-repeat line-left"><a href="#">Entry Year</a></th>
			<th class="table-header-repeat line-left"><a href="#">Entry Month</a></th>
			<th class="table-header-repeat line-left"><a href="#">Status</a></th>
			<th class="table-header-options line-left"><a href="#">Options</a></th>
		</tr>
		<tbody>
			<c:forEach items="${students}" var="student" varStatus="count">
				<tr id="row-${count.count}">
					<td><input type="checkbox" /></td>
					<td>${count.count}</td>
					<td>${student.user.name}</td>
					<td>${student.studentId}</td>
					<td>${student.user.email}</td>
					<td>${student.entryYear}</td>
					<td>${student.entryMonth}</td>
					<td>
					<form:select id="statusType" path="student.user.statusType">
					<form:option value="0" label="--Select Status--" />
					<form:options items="${statusTypes}" />
				</form:select>
				<a
						href="<spring:url value="/admin/student/verifyStudents/${student.id}" />"
						title="Change Status"
						onclick="return confirm('Are you sure to change status of this student?')">Change Status</a>
					<a
						href="<spring:url value="/admin/student/delete/${student.id}" />"
						title="Delete"
						onclick="return confirm('Are you sure to delete this student?')">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>