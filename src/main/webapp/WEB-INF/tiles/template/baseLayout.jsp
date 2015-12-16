<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>TM Checking System</title>
<link rel="stylesheet"
	href="<spring:url value="/resources/template/css/screen.css" />"
	type="text/css" media="screen" title="default" />

<!--  jquery core -->
<script
	src="<spring:url value="/resources/template/js/jquery/jquery-1.4.1.min.js" />"></script>

<!--  checkbox styling script -->

<script
	src="<spring:url value="/resources/template/js/jquery/ui.core.js" />"
	type="text/javascript"></script>
<script
	src="<spring:url value="/resources/template/js/jquery/ui.checkbox.js" />"
	type="text/javascript"></script>
<script
	src="<spring:url value="/resources/template/js/jquery/jquery.bind.js" />"
	type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		$('input').checkBox();
		$('#toggle-all').click(function() {
			$('#toggle-all').toggleClass('toggle-checked');
			$('#mainform input[type=checkbox]').checkBox('toggle');
			return false;
		});
	});
</script>


<![if !IE 7]>

<!--  styled select box script version 1 -->
<script
	src="<spring:url value="/resources/template/js/jquery/jquery.selectbox-0.5.js" />"
	type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('.styledselect').selectbox({
			inputClass : "selectbox_styled"
		});
	});
</script>


<![endif]>


<!--  styled select box script version 2 -->
<script
	src="<spring:url value="/resources/template/js/jquery/jquery.selectbox-0.5_style_2.js" />"
	type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('.styledselect_form_1').selectbox({
			inputClass : "styledselect_form_1"
		});
		$('.styledselect_form_2').selectbox({
			inputClass : "styledselect_form_2"
		});
	});
</script>

<!--  styled select box script version 3 -->
<script
	src="<spring:url value="/resources/template/js/jquery/jquery.selectbox-0.5_style_2.js" />"
	type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('.styledselect_pages').selectbox({
			inputClass : "styledselect_pages"
		});
	});
</script>

<!--  styled file upload script -->
<script
	src="<spring:url value="/resources/template/js/jquery/jquery.filestyle.js" />"
	type="text/javascript"></script>
<script type="text/javascript" charset="utf-8">
	$(function() {
		$("input.file_1").filestyle({
			image : "images/forms/upload_file.gif",
			imageheight : 29,
			imagewidth : 78,
			width : 300
		});
	});
</script>

<!-- Custom jquery scripts -->
<script
	src="<spring:url value="/resources/template/js/jquery/custom_jquery.js" />"
	type="text/javascript"></script>

<!-- Tooltips -->
<script
	src="<spring:url value="/resources/template/js/jquery/jquery.tooltip.js" />"
	type="text/javascript"></script>
<script
	src="<spring:url value="/resources/template/js/jquery/jquery.dimensions.js" />"
	type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		$('a.info-tooltip ').tooltip({
			track : true,
			delay : 0,
			fixPNG : true,
			showURL : false,
			showBody : " - ",
			top : -35,
			left : 5
		});
	});
</script>

<!--  date picker script -->
<link rel="stylesheet"
	href="<spring:url value="/resources/template/css/datePicker.css" />"
	type="text/css" />
<script
	src="<spring:url value="/resources/template/js/jquery/date.js" />"
	type="text/javascript"></script>
<script
	src="<spring:url value="/resources/template/js/jquery/jquery.datePicker.js" />"
	type="text/javascript"></script>
<script type="text/javascript" charset="utf-8">
	$(function() {

		// initialise the "Select date" link
		$('#date-pick').datePicker(
		// associate the link with a date picker
		{
			createButton : false,
			startDate : '01/01/2005',
			endDate : '31/12/2020'
		}).bind(
		// when the link is clicked display the date picker
		'click', function() {
			updateSelects($(this).dpGetSelected()[0]);
			$(this).dpDisplay();
			return false;
		}).bind(
		// when a date is selected update the SELECTs
		'dateSelected', function(e, selectedDate, $td, state) {
			updateSelects(selectedDate);
		}).bind('dpClosed', function(e, selected) {
			updateSelects(selected[0]);
		});

		var updateSelects = function(selectedDate) {
			var selectedDate = new Date(selectedDate);
			$('#d option[value=' + selectedDate.getDate() + ']').attr(
					'selected', 'selected');
			$('#m option[value=' + (selectedDate.getMonth() + 1) + ']').attr(
					'selected', 'selected');
			$('#y option[value=' + (selectedDate.getFullYear()) + ']').attr(
					'selected', 'selected');
		}
		// listen for when the selects are changed and update the picker
		$('#d, #m, #y').bind('change', function() {
			var d = new Date($('#y').val(), $('#m').val() - 1, $('#d').val());
			$('#date-pick').dpSetSelected(d.asString());
		});

		// default the position of the selects to today
		var today = new Date();
		updateSelects(today.getTime());

		// and update the datePicker to reflect it...
		$('#d').trigger('change');
	});
</script>

<!-- MUST BE THE LAST SCRIPT IN <HEAD></HEAD></HEAD> png fix -->
<script
	src="<spring:url value="/resources/template/js/jquery/jquery.filestyle.js" />"
	type="text/javascript"></script>
<script
	src="<spring:url value="/resources/template/js/jquery/jquery.pngFix.pack.js" />"
	type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(document).pngFix();
	});
</script>
</head>

<body>

	<!-- 	<!-- Start: page-top-outer -->
	-->
	<!-- 	<div id="page-top-outer"></div> -->
	<!-- 	<!-- End: page-top-outer -->
	-->

	<div class="clear">&nbsp;</div>

	<!--  start nav-outer-repeat START -->
	<div class="nav-outer-repeat">
		<tiles:insertAttribute name="navigation" />
	</div>
	<!--  start nav-outer-repeat END -->

	<div class="clear"></div>

	<!-- start content-outer -->
	<div id="content-outer">
		<!-- start content -->
		<div id="content">
			<tiles:insertAttribute name="header" />
			<table id="content-table" style="width:100%" >
				<tr>
					<th rowspan="3" class="sized"><img
						src="<spring:url value="/resources/template/images/shared/side_shadowleft.jpg" />"
						width="20" height="300" alt="" /></th>
					<th class="topleft"></th>
					<td id="tbl-border-top">&nbsp;</td>
					<th class="topright"></th>
					<th rowspan="3" class="sized"><img
						src="<spring:url value="/resources/template/images/shared/side_shadowright.jpg" />"
						width="20" height="300" alt="" /></th>
				</tr>
				<tr>
					<td id="tbl-border-left"></td>
					<td>
						<!--  start content-table-inner -->
						<div id="content-table-inner">

							<table>
								<tr valign="top">
									<td><tiles:insertAttribute name="body" /></td>
								</tr>
							</table>
						</div>
					</td>
					<td id="tbl-border-right"></td>
				</tr>
				<tr>
					<th class="sized bottomleft"></th>
					<td id="tbl-border-bottom">&nbsp;</td>
					<th class="sized bottomright"></th>
				</tr>
			</table>
		</div>
		<!--  end content -->
	</div>
	<!--  end content-outer -->

	<div class="clear">&nbsp;</div>

	<!-- start footer -->
	<div id="footer">
		<tiles:insertAttribute name="footer" />
	</div>
	<!-- end footer -->

	<div class="clear">&nbsp;</div>
</body>
</html>
