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
</head>
<body>
	<spring:message code="application.name" text="TM Check" />
	<h1>Edit Form of ${user.name}</h1>
	<form:form modelAttribute="user" method="post" action="edit" enctype="multipart/form-data" >
		<table>
			<tr>
				<td colspan="2"><form:errors path="*" cssStyle="color : red;" /></td>
			</tr>
			<tr>
				<td>Student Id :</td>
				<td><form:input path="student.studentId" value="${user.student.studentId}"/> <form:errors
						path="student.entryYear" cssStyle="color : red;" /></td>
				 
			</tr>
			 <tr>
				<td>Entry Year :</td>
				<td><form:input path="student.entryYear" value="${user.student.entryYear}" /> <form:errors
						path="student.entryYear" cssStyle="color : red;" /></td>
			</tr>
			<tr>
				<td>Entry Month :</td>
				<td><form:input path="student.entryMonth" value="${user.student.entryMonth}" /> <form:errors
						path="student.entryMonth" cssStyle="color : red;" /></td>
			</tr>
			<tr>
				<td>Student Name :</td>
				<td><form:input path="name" value="${user.name}" /> <form:errors
						path="name" cssStyle="color : red;" /></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><form:input path="email" /> <form:errors
						path="email" cssStyle="color : red;" /></td>
			</tr> 
			<tr>
			  <td> Profile Image: </td>
			  <td>
			  <form:input id="profileImage" path="profileImage" type="file"/>
			  </td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Update" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>