<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Task Form</title>
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
</style>
</head>
<body>
	<h3>
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
	
		<s:property value="%{taskObj.displayName}" />
	</h3>
	<s:form action="fileTask" method="POST" enctype="multipart/form-data">
		<s:file name="attachment" label="Upload Attachements" size="20" />
		<s:textarea name="remark" label="Remarks" cols="20"></s:textarea>

		<s:submit value="submit" name="submit" />
	</s:form>
	<s:a action="home">Back to DashBoard</s:a>
</body>
</html>