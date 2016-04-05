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

	<div>
		<c:url
			value="/EstadisticaOrdenProduccionPendiente/OrdenProduccionList/filtrarOrdenProduccion"
			var="transportReadUrl" />

		<kendo:grid name="grid" pageable="true" height="430px" sortable="true"
		filterable="true" groupable="true">
		<kendo:grid-scrollable />
		<kendo:grid-columns>
			<kendo:grid-column title="Id" field="id"  width="40px" />
			<kendo:grid-column title="Nombre" field="nombre"  width="80px" />
			<kendo:grid-column title="Id Solicitud Produccion" field="solicitudProduccion.id"  width="140px" />
			<kendo:grid-column title="Procesada" field="procesada"  width="90px" />
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
						<kendo:dataSource-schema-model-field name="nombre" type="string" />
						<kendo:dataSource-schema-model-field name="solicitudProduccion.id" type="number" />
						<kendo:dataSource-schema-model-field name="procesada" type="boolean" />
					</kendo:dataSource-schema-model-fields>
				</kendo:dataSource-schema-model>
			</kendo:dataSource-schema>
		</kendo:dataSource>
	</kendo:grid>
	</div>

	<div>
		<kendo:chart name="chartAdhesivo">
			<kendo:chart-title text="Adhesivos mas utilizados" />
			<kendo:chart-legend position="top" />
			<kendo:chart-series>
				<kendo:chart-seriesItem type="pie" data="${ordenProduccionList}"
					categoryField="descripcion" field="porcentaje">
					<kendo:chart-seriesItem-labels visible="true"
						template="#= category # - #= value #%" />
				</kendo:chart-seriesItem>
			</kendo:chart-series>
			<kendo:chart-tooltip visible="true"
				template="#= category # - #= value #%" />
		</kendo:chart>
	</div>

	<script>
	    $(document).ready(function() {
	        $(".configuration").bind("change", refresh);
	    });
	
	    function refresh() {
	        var chart = $("#chart").data("kendoChart"),
	            series = chart.options.series,
	            categoryAxis = chart.options.categoryAxis,
	            baseUnitInputs = $("input:radio[name=baseUnit]"),
	            aggregateInputs = $("input:radio[name=aggregate]");
	
	        for (var i = 0, length = series.length; i < length; i++) {
	            series[i].aggregate = aggregateInputs.filter(":checked").val();
	        }
	
	        categoryAxis.baseUnit = baseUnitInputs.filter(":checked").val();
	
	        chart.refresh();
	    }
	    
	    contextPath = '<%=request.getContextPath()%>';
	    
		function editar(e) {
			var tr = $(e.currentTarget).closest("tr");
			var id = $("#grid").data("kendoGrid").dataItem(tr).id;
			//window.location.href=contextPath + '/Usuario/edit?' + idUsuario;

			var f = document.createElement("form");
			f.setAttribute('method', "get");
			f.setAttribute('action', "edit");

			var i = document.createElement("input"); //input element, text
			i.setAttribute('type', "text");
			i.setAttribute('name', "id");
			i.setAttribute('value', id);

			var s = document.createElement("input"); //input element, Submit button
			s.setAttribute('type', "submit");
			s.setAttribute('value', "Submit");

			f.appendChild(i);
			f.appendChild(s);

			//and some more input elements here
			//and dont forget to add a submit button

			//document.getElementsByTagName('body')[0].appendChild(f);
			f.submit();
		}
	</script>


	<style>
.k-chart {
	height: 280px;
	padding: 37px;
	width: 590px;
}
</style>
</body>
</html>