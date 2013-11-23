<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<link href="<s:url value="/resources" />/css/tabtastic.css"
	rel="stylesheet" type="text/css" />


<script type="text/javascript"
	src="<s:url value="/resources" />/js/jquery-1.7.2.min.js"></script>

<script type="text/javascript"
	src="<s:url value="/resources" />/js/jquery-ui-1.8.9.custom.min.js"></script>

<script type="text/javascript"
	src="<s:url value="/resources" />/js/menu.js"></script>

<style type="text/css">
body {
	font: normal 11px auto "Trebuchet MS", Verdana, Arial, Helvetica,
		sans-serif;
	color: #4f6b72;
	background: #E6EAE9;
}

#protype1 {
	width: 800px;
	padding: 0;
	margin: 0;
}

caption {
	padding: 0 0 5px 0;
	width: 900px;
	font: italic 11px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
	text-align: right;
}

th {
	font: bold 11px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
	color: #4f6b72;
	border-right: 1px solid #C1DAD7;
	border-bottom: 1px solid #C1DAD7;
	border-top: 1px solid #C1DAD7;
	letter-spacing: 2px;
	text-transform: uppercase;
	text-align: left;
	padding: 6px 6px 6px 12px;
	background: #CAE8EA url(${request.contextPath}/images/bullet1.gif)
		no-repeat;
}

th.nobg {
	border-top: 0;
	border-left: 0;
	border-right: 1px solid #C1DAD7;
	background: none;
}

td {
	border-right: 1px solid #C1DAD7;
	border-bottom: 1px solid #C1DAD7;
	background: #fff;
	padding: 6px 6px 6px 12px;
	color: #4f6b72;
}

td.alt {
	background: #F5FAFA;
	color: #797268;
}

th.spec {
	border-left: 1px solid #C1DAD7;
	border-top: 0;
	background: #fff url(${request.contextPath}/images/bullet1.gif)
		no-repeat;
	font: bold 10px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
}

th.specalt {
	border-left: 1px solid #C1DAD7;
	border-top: 0;
	background: #f5fafa url(${request.contextPath}/images/bullet2.gif)
		no-repeat;
	font: bold 10px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
	color: #797268;
}
</style>
</head>
<body>
	<div class="body">


		<div id="show">


			<form:form action="search">
				<h3>Showing Your Products</h3> Search Anything ><input type="text"
					name="keywords" />
				<input type="submit" placeholder="Search by tag" />
			</form:form>

			<ul id="sddm">
				<li><a href="#" onmouseover="mopen('m1')"
					onmouseout="mclosetime()">Sort By</a>
					<div id="m1" onmouseover="mcancelclosetime()"
						onmouseout="mclosetime()">


						<a href="dashboard?page=0&by=id">ID</a> <a
							href="dashboard?page=0&by=title">Title</a> <a
							href="dashboard?page=0&by=dateCreated"> dateCreated</a>
					</div></li>

			</ul>

			<c:set var="counter" value="${0}" />
			<br> <br>
			<table id="protype1" name="protype1" cellpadding="5" cellspacing="4">
				<tr>
					<th>Select</th>
					<th>Product ID</th>
					<th>Product Title</th>
					<th>Sell Price</th>
					<th>Description</th>
					<th>Vendor</th>
					<th>Remove</th>
				</tr>
				<c:forEach var="next" items="${arr}">
					<c:choose>
						<c:when test="${counter % 2 == 0}">
							<tr class="alt">
						</c:when>
						<c:otherwise>
							<tr class="specalt">
						</c:otherwise>
					</c:choose>

					<td><input type="checkbox" value="${next.id}" /></td>
					<td>${next.id}</td>
					<td><a href="">${next.title}</a></td>
					<td>${next.sel_price}</td>
					<td>${next.description}</td>
					<td>${next.vendor.ven_name}</td>

					<td align="center"><a:href action="">
							<img src="<s:url value="/resources" />/images/delete.png" alt="">
						</a:href></td>
					</tr>
					<c:set var="counter" value="${counter + 1}" />
				</c:forEach>

			</table>
			<br>

			<c:set var="pg" value="0"></c:set>
			<c:set var="back" value="0"></c:set>
			<%
			    int pg, back = 0;
			    if (request.getParameter("page") != null)
					{

					pg = Integer.parseInt(request.getParameter("page"));
					back = pg - 4;
					pg = pg + 4;
					}
			    else
					{
					pg = 4;
					}
			    pageContext.setAttribute("pg", pg);
			    pageContext.setAttribute("back", back);
			%>

			<c:url value="/home/dashboard" var="next">
				<c:param name="page" value="${pg}"></c:param>
			</c:url>

			<c:url value="/home/dashboard" var="back">
				<c:param name="page" value="${back}"></c:param>
			</c:url>


			<a href="${next }">Next> </a> <a href="${back }"> Back</a>


			<!-- 		<g:link action="another" params="[page:pg]">    Next> </g:link>
			&nbsp;
			<g:link action="another" params="[page:back]">< Prev</g:link> -->


		</div>

	</div>
</body>
</html>