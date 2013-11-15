<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<p align="right">
	<c:choose>
		<c:when test="${sessionScope.customer.userId != null}">
	You are : ${sessionScope.customer.userId} <br />
			<a href="/store/logout">Logout</a>
		</c:when>
		<c:otherwise>
			<a href="/store">Login</a>
		</c:otherwise>
	</c:choose>

</p>
