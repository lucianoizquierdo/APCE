<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/views/tiles/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/kendo/web/kendo.common.min.css"/>" rel="stylesheet" />  
<link href="<c:url value="/resources/css/kendo/web/kendo.rtl.min.css"/>" rel="stylesheet" />
<link href="<c:url value="/resources/css/kendo/web/kendo.default.min.css"/>" rel="stylesheet" />
<link href="<c:url value="/resources/css/kendo/dataviz/kendo.dataviz.min.css"/>" rel="stylesheet" />
<link href="<c:url value="/resources/css/kendo/dataviz/kendo.dataviz.default.min.css"/>" rel="stylesheet" />
<link href="<c:url value="/resources/js/kendo/shared/styles/examples-offline.css"/>"  rel="stylesheet" />
		
<script src="<c:url value="/resources/js/kendo/jquery.min.js"/>"></script>  
<script src="<c:url value="/resources/js/kendo/kendo.all.min.js"/>"></script>
<script src="<c:url value="/resources/js/kendo/shared/js/console.js"/>"></script>
<script src="<c:url value="/resources/js/kendo/shared/js/prettify.js"/>"></script>

<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>
	<table border="1" cellpadding="2" cellspacing="2" align="center">
		<tr>
			<td height="30" colspan="2"><tiles:insertAttribute name="header"
					ignore="true" /></td>
		</tr>
		<tr>
			<td><tiles:insertAttribute name="menu"
					ignore="false" /></td>
		</tr>
		<tr>
			<td height="400" width="550"><tiles:insertAttribute name="body" ignore="true" /></td>

		</tr>
		<tr>
			<td height="30" colspan="2"><tiles:insertAttribute name="footer"
					ignore="true" /></td>
		</tr>
	</table>
</body>
</html>