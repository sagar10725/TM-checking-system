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
			<c:if test="${not empty user.student.studentId}">
				<tr>
					<th>Profile Picture :</th>
					<th>Details Info:</th>
				</tr>
				<tr>
					<td rowspan="5"><img
						src='data:image/jpg;base64,${user.imageFile}' width="200px"
						height="100" /></td>
					<td><b>Student ID :</b> ${user.student.studentId}</td>

				</tr>
			</c:if>
			<tr>
				<td><b>Name :</b> ${user.name}</td>
			</tr>
			<tr>
				<td><b>Email :</b> ${user.email}</td>
			</tr>
			<tr>
				<td><b>User Name :</b> ${user.username}</td>
			</tr>
			<c:if test="${not empty user.student}">
				<tr>
					<td><b>Entry Date :</b> ${user.student.entryMonth},
						${user.student.entryYear}</td>
				</tr>
			</c:if>


		</table>
		<a href="<spring:url value="/user/edit"/>">Edit User</a>
	</form>

</body>
</html>