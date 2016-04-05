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
	<form:form id="form" method="post"
		action="/Web/Sucursal/SucursalAlta/saveOrupdate" modelAttribute="sucursalForm"
		cssClass="cleanform">
		<table>
			<tr>
				<td><form:label path="ciudad">Ciudad:</form:label></td>
				<td><form:input path="ciudad" class="k-textbox" /></td>
				<td><form:errors path="ciudad" /></td>
			</tr>
			<tr>
				<td><form:label path="provincia">Provincia:</form:label></td>
				<td><form:input path="provincia" class="k-textbox" /></td>
				<td><form:errors path="provincia" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="direccion">Direccion:</form:label></td>
				<td><form:input path="direccion" class="k-textbox"  /></td>
				<td><form:errors path="direccion" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="telefono">Telefono:</form:label></td>
				<td><form:input path="telefono"  class="k-textbox"/></td>
				<td><form:errors path="telefono" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="idUsuario">Gerente general:</form:label></td>
				<td><form:select path="idUsuario">
						<form:option value="" label="-- Seleccionar --" />
						<form:options items="${gerentes}" itemValue="idUsuario"
							itemLabel="nombreApellido" />
					</form:select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Agregar Sucursal" class="k-button"/>
				</td>
			</tr>
		</table>

	</form:form>
</body>
</html>