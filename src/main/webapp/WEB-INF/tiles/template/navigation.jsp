<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<!--  start nav-outer -->
<div class="nav-outer">

	<!-- start nav-right -->
	<div id="nav-right">

		<security:authorize access="isAuthenticated()">
			<div class="nav-divider">&nbsp;</div>
			<div class="showhide-account">
				<img
					src="<spring:url value="/resources/template/images/shared/nav/nav_myaccount.gif" />"
					width="93" height="14" alt="" />
			</div>

			<div class="nav-divider">&nbsp;</div>
			<a href="<spring:url value="/processLogout" />" id="logout"><img
				src="<spring:url value="/resources/template/images/shared/nav/nav_logout.gif" />"
				width="64" height="14" alt="" /></a>
			<div class="clear">&nbsp;</div>
		</security:authorize>


		<!--  start account-content -->
		<div class="account-content">
			<div class="account-drop-inner">
				<a href="<spring:url value="/user/changepassword" />"
					id="acc-settings">Change Password</a>
				<div class="clear">&nbsp;</div>
				<div class="acc-line">&nbsp;</div>
				<a href="<spring:url value="/user/profile" />" id="acc-details">View
					Profile </a>
				<div class="clear">&nbsp;</div>
				<div class="acc-line">&nbsp;</div>
				<a href="<spring:url value="/user/edit" />" id="acc-project">Edit
					Profile</a>
				<div class="clear">&nbsp;</div>
			</div>
		</div>
		<!--  end account-content -->

	</div>
	<!-- end nav-right -->


	<!--  start nav -->
	<div class="nav">
		<div class="table">
			<ul class="select">
				<li><a href="<spring:url value="/" />"><b>Home</b></a></li>
			</ul>
			<div class="nav-divider">&nbsp;</div>
			<security:authorize access="!isAuthenticated()">
				<ul class="select">
					<li><a href="<spring:url value="/login" />"><b>Login</b></a></li>
				</ul>
				<div class="nav-divider">&nbsp;</div>
				<ul class="select">
					<li><a href="<spring:url value="/signup" />"><b>Register
								as Student</b></a></li>
				</ul>
				<div class="nav-divider">&nbsp;</div>
			</security:authorize>

			<security:authorize access="hasAnyRole('ROLE_ADMIN')">
				<ul class="select">
					<li><a href="<spring:url value="/admin/home" />"><b>Admin</b>
					</a>
						<div class="select_sub">
							<ul class="sub">
								<li><a href="<spring:url value="/admin/" />">Admin Home</a></li>
								<li><a href="<spring:url value="/admin/building" />">Building</a></li>
								<li><a href="<spring:url value="/admin/user" />">User</a></li>
								<li><a href="<spring:url value="/admin/student" />">Student</a></li>
								<li><a href="<spring:url value="/admin/tmchecker" />">TM
										Checker</a></li>
								<li><a
									href="<spring:url value="/admin/defaultCheckingSeats" />">Settings</a></li>

							</ul>
						</div></li>
				</ul>
				<div class="nav-divider">&nbsp;</div>
			</security:authorize>

			<security:authorize access="hasAnyRole('ROLE_TMCHECKER')">
				<ul class="select">
					<li><a href="<spring:url value="/tmchecker/home" />"><b>TM
								Checker</b></a>
					<div class="select_sub">
							<ul class="sub">
								<li><a href="<spring:url value="/tmchecker/" />">TMChecker Home</a></li>
								<li><a href="<spring:url value="/tmchecker/available_dates/add" />">Add Checking</a></li>
								<li><a href="<spring:url value="/tmchecker/viewsignups" />">View Signups</a></li>
								<li><a href="<spring:url value="/tmchecker/changetmstatus" />">Change TM Status</a></li>
								<li><a href="<spring:url value="/tmchecker/addnewcheckingentry" />">Add Checking Entry</a></li>
								
							</ul>
						</div></li>
				</ul>
				<div class="nav-divider">&nbsp;</div>
			</security:authorize>

			<security:authorize access="hasAnyRole('ROLE_STUDENT')">
				<ul class="select">
					<li><a href="<spring:url value="/student/home" />"><b>Students</b>
							</a><div class="select_sub">
							<ul class="sub">
								<li><a href="<spring:url value="/student/" />">TMChecker Home</a></li>
								<li><a href="<spring:url value="/student/available_dates" />">Add Checking</a></li>
								<li><a href="<spring:url value="/mysignups/" />">View Signups</a></li>								
							</ul>
						</div></li>
				</ul>
				<div class="nav-divider">&nbsp;</div>
			</security:authorize>

			<div class="clear"></div>
		</div>
		<div class="clear"></div>
	</div>
	<!--  start nav -->

</div>
<div class="clear"></div>
<!--  start nav-outer -->
