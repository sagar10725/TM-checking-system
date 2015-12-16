<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<!--  start nav-outer -->
<div class="nav-outer">

	<!-- start nav-right -->
	<div id="nav-right">

		<div class="nav-divider">&nbsp;</div>
		<div class="showhide-account">
			<img
				src="<spring:url value="/resources/template/images/shared/nav/nav_myaccount.gif" />"
				width="93" height="14" alt="" />
		</div>

		<security:authorize access="isAuthenticated()">
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
				<a href="<spring:url value="/user/viewprofile" />" id="acc-details">View
					Profile </a>
				<div class="clear">&nbsp;</div>
				<div class="acc-line">&nbsp;</div>
				<a href="<spring:url value="/user/editProfile" />" id="acc-project">Edit
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
			<security:authorize access="!isAuthenticated()">
				<ul class="select">
					<li><a href="<spring:url value="/login" />"><b>Login</b> <!--[if IE 7]><!--></a></li>
					<!--<![endif]-->
				</ul>
			</security:authorize>
			<div class="nav-divider">&nbsp;</div>
			<ul class="select">
				<li><a href="/home"><b>Home</b> <!--[if IE 7]><!--></a> <!--<![endif]--></li>
			</ul>

			<div class="nav-divider">&nbsp;</div>

			<security:authorize access="hasAnyRole('ROLE_ADMIN')">
				<ul class="select">
					<li><a href="<spring:url value="/admin/home" />"><b>Admin</b>
							<!--[if IE 7]><!--></a> <!--<![endif]--> <!--[if lte IE 6]><table><tr><td><![endif]-->
						<div class="select_sub">
							<ul class="sub">
								<li><a href="<spring:url value="/admin/building" />">Building</a></li>
								<li><a href="<spring:url value="/admin/user" />">User</a></li>
								<li><a href="<spring:url value="/admin/student" />">Student</a></li>
								<li><a href="<spring:url value="/admin/tmchecker" />">TM
										Checker</a></li>
								<li><a
									href="<spring:url value="/admin/defaultCheckingSeats" />">Settings</a></li>

							</ul>
						</div> <!--[if lte IE 6]></td></tr></table></a><![endif]--></li>
				</ul>
			</security:authorize>
			<div class="nav-divider">&nbsp;</div>
			<security:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_TMCHECKER')">
				<ul class="select">
					<li><a href="<spring:url value="/tmchecker/home" />"><b>TM
								Checker</b> <!--[if IE 7]><!--></a> <!--<![endif]--></li>
				</ul>
			</security:authorize>

			<div class="nav-divider">&nbsp;</div>
			<security:authorize
				access="hasAnyRole('ROLE_TMCHECKER','ROLE_STUDENT')">
				<ul class="select">
					<li><a href="<spring:url value="/student/home" />"><b>Students</b>
							<!--[if IE 7]><!--></a> <!--<![endif]--></li>
				</ul>
			</security:authorize>
			<div class="nav-divider">&nbsp;</div>

			<div class="clear"></div>
		</div>
		<div class="clear"></div>
	</div>
	<!--  start nav -->

</div>
<div class="clear"></div>
<!--  start nav-outer -->
