<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<a href="<spring:url value="/login" />">Login</a>
<a href="<spring:url value="/student/register" />">Register as Student</a>
<a href="<spring:url value="/tmchecker/register" />">Register as TM Checker</a></br>
<a href="<spring:url value="/user/changepassword" />">Change Password</a>
</body>
</html>