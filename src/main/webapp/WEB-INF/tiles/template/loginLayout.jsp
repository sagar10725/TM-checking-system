<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Internet Dreams</title>
<link rel="stylesheet"
	href="<spring:url value="/resources/template/css/screen.css" />" type="text/css"
	media="screen" title="default" />


</head>
<body id="login-bg">

	<!-- Start: login-holder -->
	<div id="login-holder">

		<!-- start logo -->
		<div id="logo-login">
			<a href="index.html"><img src="images/shared/logo.png"
				width="156" height="40" alt="" /></a>
		</div>
		<!-- end logo -->

		<div class="clear"></div>

		<!--  start loginbox ................................................................................. -->
		<div id="loginbox">

			<!--  start login-inner -->
			<div id="login-inner">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<th>Username</th>
						<td><input type="text" class="login-inp" /></td>
					</tr>
					<tr>
						<th>Password</th>
						<td><input type="password" value="************"
							onfocus="this.value=''" class="login-inp" /></td>
					</tr>
					<tr>
						<th></th>
						<td valign="top"><input type="checkbox" class="checkbox-size"
							id="login-check" /><label for="login-check">Remember me</label></td>
					</tr>
					<tr>
						<th></th>
						<td><input type="button" class="submit-login" /></td>
					</tr>
				</table>
			</div>
			<!--  end login-inner -->
			<div class="clear"></div>
			<a href="" class="forgot-pwd">Forgot Password?</a>
		</div>
		<!--  end loginbox -->		
	</div>
	<!-- End: login-holder -->
	</body>
</html>