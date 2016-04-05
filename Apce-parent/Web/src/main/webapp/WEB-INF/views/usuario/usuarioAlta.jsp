<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/views/tiles/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<script type="text/javascript">
	
</script>

<style type="text/css">
a {
	display: block;
	border: 1px solid #aaa;
	text-decoration: none;
	background-color: #fafafa;
	color: #123456;
	margin: 2px;
	clear: both;
}


select {
	width: 200px;
	height: 80px;
}



</style>
</head>
<body>
	<form:form id="form" method="post"
		action="/web/Usuario/UsuarioAlta/saveOrupdate"
		modelAttribute="usuarioForm" cssClass="cleanform">
		<table>
			<tr>
				<form:errors path="*" cssClass="errorblock" element="div" />
				<c:if test="${not empty message}">
					<div id="message">${message}</div>
				</c:if>
			</tr>
			<tr>
				<td><form:label path="nombre">Nombre:</form:label></td>
				<td><form:input path="nombre" class="k-textbox" /></td>
			</tr>
			<tr>
				<td><form:label path="apellido">Apellido:</form:label></td>
				<td><form:input path="apellido" class="k-textbox" /></td>
			</tr>
			<tr>
				<td><form:label path="aliasUsuario">Usuario:</form:label></td>
				<td><form:input path="aliasUsuario" class="k-textbox" /></td>
			</tr>
			<tr>
				<td><form:label path="dni">DNI:</form:label></td>
				<td><form:input path="dni" class="k-textbox"/></td>
			</tr>
			<tr>
				<td><form:label path="idSucursal">Sucursal:</form:label></td>
				<td>
					<%-- <form:select id="idSucursal" path="idSucursal">
						<form:option value="" label="-- Seleccionar --" />
						<form:options items="${sucursales}" itemValue="idSucursal"
							itemLabel="ciudad" />
					</form:select> --%>
					<form:select id="idSucursal" path="idSucursal" >
							<form:option value="" label="-- Seleccionar --" />
  						  	<form:options items="${sucursales}" itemValue="idSucursal" itemLabel="ciudad" />
					</form:select>
				</td>
			</tr>
			<tr>
				<td><form:label path="direccion">Direccion:</form:label></td>
				<td><form:input path="direccion" class="k-textbox"/></td>
			</tr>
			<tr>
				<td><form:label path="pass">Password:</form:label></td>
				<td><form:password path="pass" class="k-textbox"/></td>
			</tr>
			<tr>
				<td><form:label path="activo">Activo:</form:label></td>
				<td><form:select id="activo" path="activo">
						<form:option value="" label="-- Seleccionar --" />
						<form:options items="${comboActivo}" />
					</form:select></td>
			</tr>
			<tr>
			<td>
				<form:select id="select1" multiple="true" path="" items="${rolesNoAsignados}" itemLabel="descripcion" itemValue="idRol"/>
				 <a href="#" id="add" class="k-button">add >></a>
			</td>
			<td>
					<form:select id="select2" path="roles" items="${rolesAsignados}" itemLabel="descripcion" itemValue="idRol"/>
					<a href="#" id="remove" class="k-button"><< remove</a>	
			</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" class="k-button" value="Guardar" /></td>
			</tr>
		</table>
	</form:form>
	<script type="text/javascript">
	$(document).ready(function(){
		
		$("#idSucursal").kendoComboBox();
	    $("#activo").kendoComboBox();
	    
		$('#add').click(
				function() {
					return !$('#select1 option:selected').remove()
							.appendTo('#select2');
				});
		$('#remove').click(
				function() {
					return !$('#select2 option:selected').remove()
							.appendTo('#select1');
				});
	    
	});
	
	</script>
</body>
</html>