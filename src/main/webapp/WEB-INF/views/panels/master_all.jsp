<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>

<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" type="text/css" />
<script src="<c:url value="/resources/js/script.js" />" type="text/javascript"></script>

</head>
<body>
<table border="1" cellpadding="2" cellspacing="2" align="center" width="100%">
	<tr>
		<td height="30" colspan="2">
			<tiles:insertAttribute name="header" />
		</td>
	</tr>
	<tr>
		<td width="20%">
			<tiles:insertAttribute name="menu" />
		</td>
		<td width="80%">
			<tiles:insertAttribute name="body" />
		</td>
	</tr>
	<tr>
		<td height="30" colspan="2">
			<tiles:insertAttribute name="footer" />
		</td>
	</tr>
</table>
</body>
</html>
