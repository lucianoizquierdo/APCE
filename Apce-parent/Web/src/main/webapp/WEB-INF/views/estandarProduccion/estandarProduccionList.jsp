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

	<c:url value="/EstandarProduccion/EstandarProduccionList/filtrarEstandarProduccion" var="transportReadUrl" />

	<kendo:grid name="grid" pageable="true" height="430px" sortable="true"
		filterable="true" groupable="true">
		<kendo:grid-scrollable />
		<kendo:grid-columns>
			<kendo:grid-column title="Id" field="id"  width="40px" />
			<kendo:grid-column title="Formato1" field="formato1"  width="80px" />
			<kendo:grid-column title="Formato2" field="formato2"  width="80px" />
			<kendo:grid-column title="Fondo" field="fondo"  width="90px" />
			<kendo:grid-column title="Film" field="film"  width="70px" />
			<kendo:grid-column title="Impreso" field="impreso"  width="70px" />
			<kendo:grid-column title="Tinta(litros)" field="tintaLitros" width="90px" />
			<kendo:grid-column title="Adhesivos(Kilos)" field="adhesivoKilos" width="120px" />
			<kendo:grid-column title="Pigmentos(Kilos)" field="pigmentoKilos" width="120px" />
			<kendo:grid-column title="Diluyentes(Litros)" field="diluyenteLitros" width="130px" />
			<kendo:grid-column title="Aditivos(Kilos)" field="aditivoKilos" width="110px" />
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
                	function(options){return JSON.stringify(options);}
                </kendo:dataSource-transport-parameterMap>
			</kendo:dataSource-transport>
			<kendo:dataSource-schema data="data" total="total" groups="data">
				<kendo:dataSource-schema-model>
					<kendo:dataSource-schema-model-fields>
						<kendo:dataSource-schema-model-field name="id" type="number" />
						<kendo:dataSource-schema-model-field name="formato1" type="string" />
						<kendo:dataSource-schema-model-field name="formato2" type="string" />
						<kendo:dataSource-schema-model-field name="fondo" type="string" />
						<kendo:dataSource-schema-model-field name="film" type="string" />
						<kendo:dataSource-schema-model-field name="impreso" type="integer" />
						<kendo:dataSource-schema-model-field name="tintaLitros" type="double" />
						<kendo:dataSource-schema-model-field name="adhesivosKilos" type="double" />
						<kendo:dataSource-schema-model-field name="pigmentoKilos" type="double" />
						<kendo:dataSource-schema-model-field name="diluyenteLitros" type="double" />
						<kendo:dataSource-schema-model-field name="aditivoKilos" type="double" />
						
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
	 var id= $("#grid").data("kendoGrid").dataItem(tr).id;
	 //window.location.href=contextPath + '/Usuario/edit?' + idUsuario;
	 
	 var f = document.createElement("form");
	 f.setAttribute('method',"get");
	 f.setAttribute('action',"edit");

	 var i = document.createElement("input"); //input element, text
	 i.setAttribute('type',"text");
	 i.setAttribute('name',"id");
	 i.setAttribute('value',id);

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