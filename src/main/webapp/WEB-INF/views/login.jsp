<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<form role="form" name="formlogin" id="formlogin"
	action="<spring:url value="/postLogin" />" method="post">
	
	<p class="text-danger"><c:if test="${not empty error}">Unable to login: ${error}</c:if></p>
	<p class="text-danger">  <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/></p>
	
	
	<fieldset>
		<p>
			<input class="form-control" placeholder="Username" name="username"
				type="text" autofocus>
		</p>
		<p>
			<input class="form-control" placeholder="Password" name="password"
				type="password" value="">
		</p>
		<input type="submit" name="btnLoginSubmit" value="Login"/>
		<input type="reset" name="btnLoginReset" value="Reset"/>
	</fieldset>

</form>