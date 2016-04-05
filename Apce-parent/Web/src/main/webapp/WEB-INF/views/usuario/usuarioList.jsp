<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/views/tiles/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Usuarios</title>
</head>
<body>

	<c:url value="/Usuario/UsuarioList/filtrar" var="transportReadUrl" />
	<c:url value="/Usuario/update" var="updateUrl" />
	<c:url value="/Usuario/destroy" var="destroyUrl" />

	<kendo:grid name="grid" pageable="true" height="300px" sortable="true"
		filterable="true" groupable="true">
		<kendo:grid-editable mode="inline"
			confirmation="Seguro que desea borrar este Usuario?" />

		<kendo:grid-scrollable />
		<kendo:grid-columns>
			<kendo:grid-column title="ID usuario" field="idUsuario" width="80px"
				filterable="false" />
			<kendo:grid-column title="Nombre" field="nombre" width="80px" />
			<kendo:grid-column title="Apellido" field="apellido" width="90px" />
			<kendo:grid-column title="Alias Usuario" field="aliasUsuario"
				width="120px" />
			<kendo:grid-column title="DNI" field="dni" width="60px" />
			<%-- <kendo:grid-column title="Sucursal" field="dni" width="100px" />
			<kendo:grid-column title="Fecha Nacimiento" field="fecha_nacimiento"
				width="130px" /> --%>
			<kendo:grid-column title="Telefono" field="telefono" width="100px" />
			<kendo:grid-column title="Direccion" field="direccion" width="130px" />
			<kendo:grid-column title="Activo" field="activo" width="130px" />
			<kendo:grid-column title="&nbsp;" width="172px">
				<kendo:grid-column-command> 
					<kendo:grid-column-commandItem text="Editar" click="editar"  />
					<kendo:grid-column-commandItem name="destroy" />
				</kendo:grid-column-command>
			</kendo:grid-column>
		</kendo:grid-columns>


		<kendo:dataSource pageSize="20" serverPaging="true"
			serverSorting="true" serverFiltering="true" serverGrouping="true">
			<kendo:dataSource-transport>
				<kendo:dataSource-transport-read url="${transportReadUrl}"
					type="POST" contentType="application/json" />
				<kendo:dataSource-transport-update url="${updateUrl}"
					dataType="json" type="POST" contentType="application/json" />
				<kendo:dataSource-transport-destroy url="${destroyUrl}"
					dataType="json" type="POST" contentType="application/json" />
				<kendo:dataSource-transport-parameterMap>
					<script>
	                	function parameterMap(options,type) { 	                		
	                		return JSON.stringify(options);	                		
	                	}
                	</script>
				</kendo:dataSource-transport-parameterMap>
			</kendo:dataSource-transport>
			<kendo:dataSource-schema data="data" total="total" groups="data">
				<kendo:dataSource-schema-model id="idUsuario">
					<kendo:dataSource-schema-model-fields>
						<kendo:dataSource-schema-model-field name="idUsuario"
							type="number" />
						<kendo:dataSource-schema-model-field name="nombre" type="string" />
						<kendo:dataSource-schema-model-field name="apellido" type="string" />
						<kendo:dataSource-schema-model-field name="aliasUsuario"
							type="string" />
						<kendo:dataSource-schema-model-field name="dni" type="number" />
						<kendo:dataSource-schema-model-field name="telefono" type="number" />
						<kendo:dataSource-schema-model-field name="direccion"
							type="string" />
							<kendo:dataSource-schema-model-field name="activo" type="boolean" />
					</kendo:dataSource-schema-model-fields>
				</kendo:dataSource-schema-model>
			</kendo:dataSource-schema>
		</kendo:dataSource>
	</kendo:grid>
	
	
	
<script type="text/javascript">
contextPath = '<%=request.getContextPath()%>';
function editar(e)
{
	 var tr = $(e.currentTarget).closest("tr");
	 var idUsuario = $("#grid").data("kendoGrid").dataItem(tr).idUsuario;
	 //window.location.href=contextPath + '/Usuario/edit?' + idUsuario;
	 
	 var f = document.createElement("form");
	 f.setAttribute('method',"get");
	 f.setAttribute('action',"edit");

	 var i = document.createElement("input"); //input element, text
	 i.setAttribute('type',"text");
	 i.setAttribute('name',"idUsuario");
	 i.setAttribute('value',idUsuario);

	 var s = document.createElement("input"); //input element, Submit button
	 s.setAttribute('type',"submit");
	 s.setAttribute('value',"Submit");

	 f.appendChild(i);
	 f.appendChild(s);

	 //and some more input elements here
	 //and dont forget to add a submit button

	 //document.getElementsByTagName('body')[0].appendChild(f);
	 f.submit();
}

</script>
</body>
</html>