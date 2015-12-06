<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
</head>
<body>
	<spring:message code="application.name" text="TM Check" />
	<h1>Student Sign Up Form</h1>
	<form:form method="post" modelAttribute="student" action="user">
		<table>
			<tr>
				<td colspan="2"><form:errors path="*" class="error" /></td>
			</tr>
			<tr>
				<td>Student ID :</td>
				<td><form:input path="studentId" /> <form:errors
						path="studentId" class="error" /></td>
			</tr>
			<tr>
				<td>Entry Year :</td>
				<td><form:input path="entryYear" /> <form:errors
						path="entryYear" class="error" /></td>
			</tr>
			<tr>
				<td>Entry Month :</td>
				<td><form:input path="entryMonth" /> <form:errors
						path="entryMonth" class="error" /></td>
			</tr>
			<tr>
				<td>Student Name :</td>
				<td><form:input path="user.name" /> <form:errors
						path="user.name" class="error" /></td>
			</tr>
			<tr>
				<td>Username :</td>
				<td><form:input path="user.username" /> <form:errors
						path="user.username" class="error" /></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><form:input path="user.password" /> <form:errors
						path="user.password" class="error" /></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><form:input path="user.email" /> <form:errors
						path="user.email" class="error" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Save Changes" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>