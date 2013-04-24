<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<link rel="stylesheet" type="text/css" href="css/main.css" />
</head>

<body>
	<div id="page">
		<div id="spinner" class="spinner" style="display: none;"></div>
		<div id="topbar">
		<tiles:insertAttribute name="topbar" />
		</div>
		<div id="header">
			<h1>Task Submission App</h1>
		</div>
		<div id="content">
			<tiles:insertAttribute name="body" />
		</div>
		<div id="sidebar">
			<tiles:insertAttribute name="menu" />
		</div>
		<div id="footer">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
</body>
</html>