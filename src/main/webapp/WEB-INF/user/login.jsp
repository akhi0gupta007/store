<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>

<link href="<s:url value="/resources" />/css/tabtastic.css"
	rel="stylesheet" type="text/css" />

<style type="text/css">
.errors {
	background-color: #FFCCCC;
	border: 1px solid #CC0000;
	width: 400px;
	margin-bottom: 8px;
}

.errors li {
	list-style: none;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>
<body>
	<div align="center" id="login">
		<h2>User Login Here</h2>

		<form:form method="POST" commandName="customer" action="/store/authenticate">
			<form:errors path="*" cssClass="errorblock" element="div" />

			<table>
				<tr>
					<td>User Name :</td>
					<td><form:input path="userId" /></td>
					<td><form:errors path="userId" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Password :</td>
					<td><form:password path="password" /></td>
					<td><form:errors path="password" cssClass="error" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Submit"></td>
				</tr>
			</table>

		</form:form>

		<%-- <form:form method="POST" <%-- commandName="user" --%>
		<%-- 	<table>
				<tr>
					<td>User Name :</td>
					<td><form:input path="name" /></td>
				</tr>
				<tr>
					<td>Password :</td>
					<td><form:password path="password" /></td>
				</tr>
				<tr>
					<td>Gender :</td>
					<td><form:radiobutton path="gender" value="M" label="M" /> <form:radiobutton
							path="gender" value="F" label="F" /></td>
				</tr>
				<tr>
					<td>Country :</td>
					<td><form:select path="country">
							<form:option value="0" label="Select" />
							<form:options items="${countryList}" itemValue="countryId"
								itemLabel="countryName" />
						</form:select></td>
				</tr>
				<tr>
					<td>About you :</td>
					<td><form:textarea path="aboutYou" /></td>
				</tr>
				<tr>
					<td>Community :</td>
					<td><form:checkboxes path="communityList"
							items="${communityList}" itemValue="key" itemLabel="value" /></td>
				</tr>
				<tr>
					<td></td>
					<td><form:checkbox path="mailingList"
							label="Would you like to join our mailinglist?" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Register"></td>
				</tr>
			</table> --%>
		<%-- 	</form:form> --%>

	</div>


</body>
</html>