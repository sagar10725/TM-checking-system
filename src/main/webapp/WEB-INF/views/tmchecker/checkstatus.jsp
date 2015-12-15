<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="application.name" text="New Checking" /></title>
<style type="text/css">
@import url(resources/css/style.css);
</style>
</head>
<body>
	
	<spring:message code="application.name" text="New Checking" />
	<h1>Add New Checking Form</h1>
	<form:form modelAttribute="tmchecker" action="tmcheck" method="post">
		<table>
			<tr>
				<td colspan="2"><form:errors path="*" class="error" /></td>
			</tr>
			<tr>
				<td>Student ID :</td>
				<td><form:input path="studentId" /> <form:errors
						path="studentId" class="error" /></td>
			</tr>
			<%-- <tr>
				<td>Date: </td>
				<td><form:input path="checkedDate" /> <form:errors
						path="checkedDate" class="error" /></td>
			</tr> --%>
			<tr>
				<td>Time: </td>
				<td>
				<form:radiobutton path="time" items="3:00-3:30"/>3-3:30 
				<form:radiobutton path="time" items="3:30-4:00"/>3:30-4:00 
			</tr>
			
			<tr>
				<td>Checking Type: </td>
				<td><form:select path="checkingType">
   				<form:option value="NONE" label="--- Select ---"/>
  				 <form:options items="${checkingtype}"  />
				</form:select></td>
			</tr>
			
				<tr>
				<td>Status: </td>
				<td><form:select path="status">
   				<form:option value="NONE" label="--- Select ---"/>
  				 <form:options items="${status}"  />
				</form:select></td>
			</tr>
			
			
			<tr>
				<td colspan="2"><input type="submit" value="Save Changes" /></td>
			</tr>
		</table>
	
	</form:form>

</body>
</html>