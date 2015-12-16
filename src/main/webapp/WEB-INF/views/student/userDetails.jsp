<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form>


		<table border="2">
			<tr>
				<th>Profile Picture :</th>
				<th>Details Info:</th>
			</tr>
			<tr>
				<td rowspan="5"><img alt="pict" src="images/${employee.id}.png"></td>
				<td><b>Student Id : :</b> ${user.student.studentId}</td>

			</tr>
			<tr>
				<td><b>Student Name :</b> ${user.name}</td>
			</tr>
			<tr>
				<td><b>Email :</b> ${user.email}</td>
			</tr>
			<tr>
				<td><b>User Name :</b> ${user.username}</td>
			</tr>
			<tr>
				<td><b>Entry Date :</b>
					${user.student.entryYear},${user.student.entryMonth}</td>
			</tr>


		</table>
		<a href="<spring:url value="/user/edit"/>">Edit User</a>
	</form>

</body>
</html>