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
	<fieldset>
		<legend>Add Checking Times</legend>
		<form:form modelAttribute="" method="post" action="/settings">
			<form:input path=""/>
			<form:errors path=""/>
		</form:form>
	</fieldset>
</body>
</html>