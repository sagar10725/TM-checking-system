<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Internet Dreams</title>
<link rel="stylesheet"
	href='<spring:url value="resources/template/css/screen.css" />'
	type="text/css" media="screen" title="default" />
<script
	src='<spring:url value="resources/template/js/jquery/jquery-1.4.1.min.js" />'
	type="text/javascript"></script>
<script
	src='<spring:url value="resources/template/js/jquery/custom_jquery.js" />'
	type="text/javascript"></script>
</head>
<body id="login-bg">
	<div id="login-holder">
		<div id="logo-login">
			<a href="index.html"><img
				src='<spring:url value="resources/images/sias-logo.jpg"/>'
				width="
				156" height="40" alt="" /></a>
		</div>
		<div class="clear"></div>

		<div id="loginbox">
			<div id="login-inner">
				<form action="processLogin" method="post">
					<c:if test="${not empty error}">
						<div class="alert alert-danger">
							<spring:message code="AbstractUserDetailsAuthenticationProvider.badCredentials"/><br />
						</div>
					</c:if>
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<th>Username</th>
							<td><input type="text" name="username" class="login-inp"
								placeholder="Enter Username" /></td>
						</tr>
						<tr>
							<th>Password</th>
							<td><input type="password" name="password"
								value="************" onfocus="this.value=''" class="login-inp" /></td>
						</tr>
						<tr>
							<th></th>
							<td><input type="submit" class="submit-login" /></td>
						</tr>
					</table>
				</form>
			</div>
			<div class="clear"></div>
			<a href="" class="forgot-pwd">Forgot Password?</a>
		</div>

		<!--  start forgotbox ................................................................................... -->
		<div id="forgotbox">
			<div id="forgotbox-text">Please send us your email and we'll
				reset your password.</div>
			<!--  start forgot-inner -->
			<div id="forgot-inner">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<th>Email address:</th>
						<td><input type="text" value="" class="login-inp" /></td>
					</tr>
					<tr>
						<th></th>
						<td><input type="button" class="submit-login" /></td>
					</tr>
				</table>
			</div>
			<!--  end forgot-inner -->
			<div class="clear"></div>
			<a href="" class="back-login">Back to login</a>
		</div>
		<!--  end forgotbox -->

	</div>
	<!-- End: login-holder -->
</body>
</html>