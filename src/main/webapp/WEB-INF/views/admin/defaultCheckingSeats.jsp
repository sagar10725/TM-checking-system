<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="application.name" text="TM Check" /></title>
<style type="text/css">
@import url(resources/css/style.css);
</style>
<title>Default-Checking-seats</title>
</head>
<body>
	<h1>Default-Checking-Seats</h1>
	<form:form modelAttribute="checkingSeats" method="POST">
		<table>
			<tr>
				<td colspan="2"><form:errors path="*" class="error" /></td>
			</tr>

			<tr>
				<td>Checking Type:</td>
				<td><form:select path="checkingType" name="checkingType" onchange="showCheckingSeats()">
						<form:option value="0" label="Checking Type" />
						<form:options items="${checking}" />
					</form:select> <form:errors path="checkingType" class="error" /></td>
			</tr>
			<tr>
				<td>Number of Seats :</td>
				<td><form:input path="numberOfSeats" name="numberOfSeats"/> <form:errors
						path="numberOfSeats" class="error" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Change" /></td>
			</tr>
		</table>



	</form:form>
</body>
</html>