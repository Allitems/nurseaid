<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/bootstrap-theme.min.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/font-awesome.min.css" />" rel="stylesheet" type="text/css" /> 
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-datepicker.css" />" type="text/css" />
<link href="<c:url value="/resources/style.css" />" rel="stylesheet" type="text/css" /> 

<!--[if lt IE 9]>                
<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->

<link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Fira+Sans" />   

<script type="text/javascript" src="<c:url value="/resources/js/jquery-latest.min.js" />"></script>  
<script type="text/javascript" src="<c:url value="/resources/js/custom.js" />"></script>

<script type="text/javascript" src="<c:url value="/resources/js/tinymce/tinymce.min.js" />"></script>  

</head>
<body>

<div class="container-fluid">
     <div class="row"> 
     	<tiles:insertAttribute name="header" />  
     	<tiles:insertAttribute name="breadcrumb" />
     	<tiles:insertAttribute name="body" />
     </div>
</div>
<tiles:insertAttribute name="footer" />

</body>
</html>
