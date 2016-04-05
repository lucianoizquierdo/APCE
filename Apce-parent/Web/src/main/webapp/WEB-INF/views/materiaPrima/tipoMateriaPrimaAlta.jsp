<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/views/tiles/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>  
<form:form id="form" method="post" action="/web/MateriaPrima/MateriaPrimaAlta/addTipoMateriaPrima" modelAttribute="tipoMateriaPrimaForm" cssClass="cleanform">
 
    <table>
    <tr>
        <td><form:label path="nombre">Nombre:</form:label></td>
        <td><form:input path="nombre" /></td>
         <td><form:errors path="nombre" cssClass="error" /></td>
    </tr>
    <tr>
        <td><form:label path="descripcion">Descripcion:</form:label></td>
        <td><form:input path="descripcion" /></td>
         <td><form:errors path="descripcion" cssClass="error" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Guardar Tipo Materia Prima"/>
        </td>
    </tr>
</table>  
     
</form:form>
</body>
</html>