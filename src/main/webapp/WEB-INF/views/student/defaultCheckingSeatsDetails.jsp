<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Default Checking Seats Detail</title>
</head>
<body>
	<form>
		<fieldset>
			<legend>list of Default Checking</legend>
			<table>
				<tr>
					<th>Checking Type</th>
					<th>Number Of Seats</th>
					
				</tr>
				<c:forEach items="${checkingSeats}" var="seats">
					<tr>
						<td><c:out value="${student.studentId}"></c:out></td>
						<td><c:out value="${student.user.name}"></c:out></td>
						
						
					</tr>
				</c:forEach>
			</table>
		</fieldset>

	</form>
</body>
</html>