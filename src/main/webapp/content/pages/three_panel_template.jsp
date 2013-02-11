<%@ page language="java"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" lang="en" xml:lang="en">
<head>
<title>Sample Application</title>
</head>
<body>
	<div id="main">
		<tiles:insertAttribute name="header" />
		<div style="clear:both;"></div>
		<div id="content">
			<tiles:insertAttribute name="content" />
		</div>
		<div style="clear:both;"></div>
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>
