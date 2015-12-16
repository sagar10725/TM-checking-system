<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<!--  start nav-outer -->
<div class="nav-outer">

	<!-- start nav-right -->
	<div id="nav-right">

		<div class="nav-divider">&nbsp;</div>
		<div class="showhide-account">
			<img src="<spring:url value="/resources/template/images/shared/nav/nav_myaccount.gif" />" width="93" height="14"
				alt="" />
		</div>
		<div class="nav-divider">&nbsp;</div>
		<a href="" id="logout"><img src="<spring:url value="/resources/template/images/shared/nav/nav_logout.gif" />"
			width="64" height="14" alt="" /></a>
		<div class="clear">&nbsp;</div>

		<!--  start account-content -->
		<div class="account-content">
			<div class="account-drop-inner">
				<a href="" id="acc-settings">Settings</a>
				<div class="clear">&nbsp;</div>
				<div class="acc-line">&nbsp;</div>
				<a href="/userProfile" id="acc-details">Personal details </a>
				<div class="clear">&nbsp;</div>
				<div class="acc-line">&nbsp;</div>
				<a href="" id="acc-project">Project details</a>
				<div class="clear">&nbsp;</div>
				<div class="acc-line">&nbsp;</div>
				<a href="" id="acc-inbox">Inbox</a>
				<div class="clear">&nbsp;</div>
				<div class="acc-line">&nbsp;</div>
				<a href="" id="acc-stats">Statistics</a>
			</div>
		</div>
		<!--  end account-content -->

	</div>
	<!-- end nav-right -->


	<!--  start nav -->
	<div class="nav">
		<div class="table">

			<ul class="select">
				<li><a href="#nogo"><b>Dashboard</b>
					<!--[if IE 7]><!--></a>
				<!--<![endif]-->
			</ul>

			<div class="nav-divider">&nbsp;</div>

			<ul class="select">
				<li><a href="#nogo"><b>TM Checking</b>
					<!--[if IE 7]><!--></a>
				<!--<![endif]-->
			</ul>

			<div class="nav-divider">&nbsp;</div>

			<ul class="select">
				<li><a href="#nogo"><b>Manage</b>
					<!--[if IE 7]><!--></a>
				<!--<![endif]-->
			</ul>

			<div class="nav-divider">&nbsp;</div>

			<ul class="select">
				<li><a href="#nogo"><b>Students</b>
					<!--[if IE 7]><!--></a>
				<!--<![endif]-->
			</ul>

			<div class="nav-divider">&nbsp;</div>

			<ul class="select">
				<li><a href="#nogo"><b>News</b>
					<!--[if IE 7]><!--></a>
				<!--<![endif]-->
			</ul>

			<div class="clear"></div>
		</div>
		<div class="clear"></div>
	</div>
	<!--  start nav -->

</div>
<div class="clear"></div>
<!--  start nav-outer -->
