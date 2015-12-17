<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h2>TM Checker List</h2>
<hr>
<h3>
	<a href="<spring:url value="/admin/tmchecker/add" />"
	title="Add TM Checker">Add New TM Checker</a>
</h3>
<hr>
<c:choose>
	<c:when test="${empty tmCheckers}">
	No recored of TM Checkers found.
 </c:when>
	<c:otherwise>
		<table id="product-table">
				<tr>
					<th class="table-header-check"><a id="toggle-all"></a></th>
					<th class="table-header-repeat line-left"><a href="#">#</a></th>
					<th class="table-header-repeat line-left"><a href="#">TM Checker
							Name</a></th>
					<th class="table-header-repeat line-left"><a href="#">Email</a></th>
					<th class="table-header-repeat line-left"><a href="#">Status</a></th>
					<th class="table-header-options line-left"><a href="#">Options</a></th>
				</tr>
				<tbody>
					<c:forEach items="${tmCheckers}" var="tmChecker"
						varStatus="count">
						<tr id="row-${tmChecker.id}">
							<td><input type="checkbox" /></td>
							<td>${count.count}</td>
							<td>${tmChecker.user.name}</td>
							<td>${tmChecker.user.email}</td>
							<td>${tmChecker.user.status}</td>
							<td><a
							href="<spring:url value="/admin/tmchecker/disable/${tmChecker.id}" />"
							title="DISABLED" class="icon-2 info-tooltip"
							onclick="return confirm('Are you sure to disable this TM Checker?')"></a>
							<a
							href="<spring:url value="/admin/tmchecker/enable/${tmChecker.id}" />"
							title="ENABLED" class="icon-5 info-tooltip"
							onclick="return confirm('Are you sure to enable this TM Checker?')"></a></td>
						</tr>
					</c:forEach>
				</tbody>
		</table>
	</c:otherwise>
</c:choose>