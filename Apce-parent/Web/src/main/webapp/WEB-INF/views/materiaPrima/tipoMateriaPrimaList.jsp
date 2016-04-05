<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/views/tiles/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Tipo de Materia Prima</title>
</head>
<body>  

	<c:url value="/MateriaPrima/TipoMateriaPrimaList/filtrarTipoMateriaPrima" var="transportReadUrl" />

	<kendo:grid name="grid" pageable="true" height="430px" sortable="true"
		filterable="true" groupable="true">
		<kendo:grid-scrollable />
		<kendo:grid-columns>
			<kendo:grid-column title="Nombre" field="nombre"  width="70px" />
			<kendo:grid-column title="Descripcion" field="descripcion" width="100px" />
		</kendo:grid-columns>
		<kendo:dataSource pageSize="20" serverPaging="true"
			serverSorting="true" serverFiltering="true" serverGrouping="true">
			<kendo:dataSource-transport>
				<kendo:dataSource-transport-read url="${transportReadUrl}"
					type="POST" contentType="application/json" />
				<kendo:dataSource-transport-parameterMap>
                	function(options){return JSON.stringify(options);}
                </kendo:dataSource-transport-parameterMap>
			</kendo:dataSource-transport>
			<kendo:dataSource-schema data="data" total="total" groups="data">
				<kendo:dataSource-schema-model>
					<kendo:dataSource-schema-model-fields>
						<kendo:dataSource-schema-model-field name="nombre" type="string" />
						<kendo:dataSource-schema-model-field name="descripcion" type="string" />
					</kendo:dataSource-schema-model-fields>
				</kendo:dataSource-schema-model>
			</kendo:dataSource-schema>
		</kendo:dataSource>
	</kendo:grid>

</body>
</html>