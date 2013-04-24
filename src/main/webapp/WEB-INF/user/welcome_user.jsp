<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>

<html>
<head>
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

.msgs {
	background-color: #FFCCCC;
	border: 1px solid #CC0000;
	width: 400px;
	margin-bottom: 8px;
}

.msgs li {
	list-style: none;
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
	<h1>DashBoard</h1>



	<s:if test="hasActionErrors()">
		<div class="errors">
			<s:actionerror />
		</div>
	</s:if>

	<s:if test="hasActionMessages()">
		<div class="errors">
			<s:actionmessage />
		</div>
	</s:if>

	<s:form action="taskForm" cssStyle="none">
		<s:select label="Fill the task" headerValue="--- Select ---"
			list="pending" name="task" listKey="fileId" listValue="displayName" />
		<s:submit label="Go"></s:submit>
	</s:form>
	<br />

	<display:table export="true" id="data" name="taskHistory" pagesize="5"
		requestURI="">
		<display:column property="task" title="Task Name" sortable="true" />
		<display:column property="dateCreated" title="Completed On"
			sortable="true" />
		<display:column property="task.locationId.locationName"
			title="Location" sortable="true" />

		<display:column title="Download Attachments">
			<a href="/notifier/<s:property value="%{#session.user.userId}" />/<s:property value="#attr.data.attachment" />">Download</a>
		</display:column>

		<display:column property="remarks" title="Remarks" sortable="true" />

	</display:table>

	<%-- <table>
		<tr>
			<th>Task Name</th>
			<th>Periodicity</th>
			<th>Completed On</th>
			<th>Location</th>
			<th>Remarks</th>
			<th>Attachments</th>
		</tr>
		<s:iterator value="taskHistory" status="x">
			<tr>
				<td><s:property value="task" /></td>
				<td><s:if test="task.periodicity == 2">
						MONTHLY
				</s:if> <s:if test="task.periodicity == 1">
						DAILY
				</s:if> <s:if test="task.periodicity == 3">
						QUATERLY
				</s:if> <s:if test="task.periodicity == 4">
						HALF YEARLY
				</s:if> <s:if test="task.periodicity == 5">
						ANNUALY
				</s:if></td>
				<td><s:property value="dateCreated" /></td>
				<td><s:property value="task.locationId.locationName" /></td>
				<td><s:property value="remarks" /></td>
				<td><a
					href="/notifier/<s:property value="%{#session.user.userId}" />/<s:property value="attachment" />">Download</a></td>
			</tr>
		</s:iterator>
	</table> --%>
	<br>
	<br>
</body>
</html>