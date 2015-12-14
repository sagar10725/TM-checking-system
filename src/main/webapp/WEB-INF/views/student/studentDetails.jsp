<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student List</title>
</head>
<body>
	<form>
		<fieldset>
			<legend>List of Students :</legend>
			<table>
				<tr>
					<th>Student Id</th>
					<th>Student Name</th>
					<th>Email</th>
					<th>Entry Date</th>
					<th>User Name</th>
					<th>Action</th>
				</tr>
				<c:forEach items="${studentList}" var="student">
					<tr>
						<td><c:out value="${student.studentId}"></c:out></td>
						<td><c:out value="${student.user.name}"></c:out></td>
						<td><c:out value="${student.user.email}"></c:out></td>
						<td><c:out value="${student.entryMonth}"></c:out>, <c:out
								value="${student.entryYear}"></c:out></td>
						<td><c:out value="${student.user.username }"></c:out></td>
						<td><a href="<c:url value="/studentEdit?id=${student.id}" />">Edit</a> /<a href="<c:url value="/studentDelete?id=${student.id}" />">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</fieldset>

	</form>


</body>
</html>