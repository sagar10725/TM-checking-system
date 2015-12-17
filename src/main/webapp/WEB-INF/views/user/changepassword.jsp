<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Your Password</title>
</head>
<body>
	<h1>Change Password</h1>
	
	<form:form method="post" action="changepassword" commandName="passwordchange">
	<table>
	
	<tr><td colspan="2"><form:errors path="*" cssStyle="color: red;" /></td> </tr>
				
			<tr>
				<td>Current Password: </td>
				<td><form:password  path="oldpassword"/></td>
			</tr>
			
			<tr>
				<td>New-Password</td>
				<td><form:password path="newpassword" /></td>
			</tr>
			
			<tr>
				<td>Confirm-Password</td>
				<td><form:password path="confirmpassword" /></td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit" value="Save Changes" /></td>
			</tr>
	</table>
	</form:form>
	
	
</body>
</html>