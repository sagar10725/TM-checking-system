<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h2>Add TM Checker</h2><hr>
<form:form method="post" modelAttribute="tmchecker" >
		<table>
			<tr>
				<td colspan="2"><form:errors path="*" cssStyle="color: red" /></td>
			</tr>
			<tr>
				<td>Full Name :</td>
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
				<td><form:password path="user.password" /> <form:errors
						path="user.password" class="error" /></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><form:input path="user.email" /> <form:errors
						path="user.email" class="error" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Save Changes" />
				<input type="reset" value="Reset" /></td>
			</tr>
		</table>
	</form:form>