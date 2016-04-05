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

<div class="demo-section" style="width:470px">
   	<label for="start">Start date:</label>
	<kendo:datePicker name="start" value="${start}" max="${end}" format="dd/MM/yyyy" change="startChange"></kendo:datePicker>
	
	<label for="end" style="margin-left:3em">End date:</label>
	<kendo:datePicker name="end" value="${end}" min="${start}" format="dd/MM/yyyy" change="endChange"></kendo:datePicker>
	   
	<button class="k-button" onclick="filtrar()">Filtrar</button>
</div>


<div>
	<table>
		<tr>
			<td>
			<h3>Adhesivos</h3>
				<c:url value="/EstadisticaMateriaPrima/adhesivo/" var="transportReadUrlAdhesivo" />
				<kendo:grid name="gridAdhesivo" pageable="true" groupable="true" sortable="true" filterable="true" >
			        <kendo:grid-columns>
			            <kendo:grid-column title="ID" field="id" filterable="false" />
			            <kendo:grid-column title="Codigo de Materia Prima" field="codigoMateriaPrima" filterable="false"  />
			            <kendo:grid-column title="Descripcion" field="descripcion" filterable="false" />
			            <kendo:grid-column title="Porcentaje %" field="porcentaje" />
			        </kendo:grid-columns>
			        <kendo:dataSource pageSize="10">
			             <kendo:dataSource-schema>
			                <kendo:dataSource-schema-model>
			                    <kendo:dataSource-schema-model-fields>
			                        <kendo:dataSource-schema-model-field name="id" type="string" />
			                        <kendo:dataSource-schema-model-field name="codigoMateriaPrima" type="string" />
			                        <kendo:dataSource-schema-model-field name="descripcion" type="string" />
			                        <kendo:dataSource-schema-model-field name="porcentaje" type="number" />
			                    </kendo:dataSource-schema-model-fields>
			                </kendo:dataSource-schema-model>
			            </kendo:dataSource-schema>
			            <kendo:dataSource-transport parameterMap="getFechas">
			                <kendo:dataSource-transport-read url="${transportReadUrlAdhesivo}"/>
			            </kendo:dataSource-transport>
			        </kendo:dataSource>
			    </kendo:grid>
			</td>
		</tr>
		<tr>
			<td>
				<kendo:chart name="chartAdhesivo">
						<kendo:chart-title text="Adhesivos mas utilizados" />
						<kendo:chart-legend position="top" />
						<kendo:chart-series>
							<kendo:chart-seriesItem type="pie" data="${adhesivoList}" categoryField="codigoMateriaPrima" field="porcentaje" >
								<kendo:chart-seriesItem-labels visible="true"
									template="#= category # - #= value #%" />
							</kendo:chart-seriesItem>
						</kendo:chart-series>
						<kendo:chart-tooltip visible="true"
							template="#= category # - #= value #%" />
				</kendo:chart>
			</td>
		</tr>
	</table>
</div>
 
    
    
    
<div>
	<table>
		<tr>
			<td>
				<h3>Pigmentos</h3>
				<c:url value="/EstadisticaMateriaPrima/pigmento/" var="transportReadUrlPigmento" />
   				<kendo:grid name="gridPigmento" pageable="true" groupable="true" sortable="true" filterable="true" >
			        <kendo:grid-columns>
			            <kendo:grid-column title="ID" field="id" filterable="false" />
			            <kendo:grid-column title="Codigo de Materia Prima" field="codigoMateriaPrima"  filterable="false" />
			            <kendo:grid-column title="Descripcion" field="descripcion" filterable="false" />
			            <kendo:grid-column title="Porcentaje %" field="porcentaje" filterable="true" />
			        </kendo:grid-columns>
			        <kendo:dataSource pageSize="10">
			             <kendo:dataSource-schema>
			                <kendo:dataSource-schema-model>
			                    <kendo:dataSource-schema-model-fields>
			                        <kendo:dataSource-schema-model-field name="id" type="string" />
			                        <kendo:dataSource-schema-model-field name="codigoMateriaPrima" type="string" />
			                        <kendo:dataSource-schema-model-field name="descripcion" type="string" />
			                        <kendo:dataSource-schema-model-field name="porcentaje" type="number" />
			                    </kendo:dataSource-schema-model-fields>
			                </kendo:dataSource-schema-model>
			            </kendo:dataSource-schema>
			            <kendo:dataSource-transport parameterMap="getFechas">
			                <kendo:dataSource-transport-read url="${transportReadUrlPigmento}"/>
			            </kendo:dataSource-transport>
       				</kendo:dataSource>
 				  </kendo:grid>
			</td>
		</tr>
		<tr>
			<td>
				<kendo:chart name="chartPigmento">
						<kendo:chart-title text="Pigmentos mas utilizados" />
						<kendo:chart-legend position="top" />
						<kendo:chart-series>
							<kendo:chart-seriesItem type="pie" data="${pigmentoList}" categoryField="codigoMateriaPrima" field="porcentaje" >
								<kendo:chart-seriesItem-labels visible="true"
									template="#= category # - #= value #%" />
							</kendo:chart-seriesItem>
						</kendo:chart-series>
						<kendo:chart-tooltip visible="true"
								template="#= category # - #= value #%" />
				</kendo:chart>
			</td>
		</tr>
	</table>
</div>    
   
<table>
	<tr>
		<td>
			<h3>Aditivos</h3>
			<c:url value="/EstadisticaMateriaPrima/aditivo/" var="transportReadUrlAditivo" />
		    <kendo:grid name="gridAditivo" pageable="true" sortable="true">
		        <kendo:grid-columns>
		            <kendo:grid-column title="ID" field="id" filterable="false" sortable="false" />
		            <kendo:grid-column title="Codigo de Materia Prima" field="codigoMateriaPrima" filterable="false" sortable="false" />
		            <kendo:grid-column title="Descripcion" field="descripcion" filterable="false" sortable="false" />
		            <kendo:grid-column title="Porcentaje %" field="porcentaje" filterable="true" sortable="true"  />
		        </kendo:grid-columns>
		        <kendo:dataSource pageSize="10" >
		             <kendo:dataSource-schema>
		                <kendo:dataSource-schema-model>
		                    <kendo:dataSource-schema-model-fields>
		                        <kendo:dataSource-schema-model-field name="id" type="string" />
		                        <kendo:dataSource-schema-model-field name="codigoMateriaPrima" type="string" />
		                        <kendo:dataSource-schema-model-field name="descripcion" type="string" />
		                        <kendo:dataSource-schema-model-field name="porcentaje" type="number"  />
		                    </kendo:dataSource-schema-model-fields>
		                </kendo:dataSource-schema-model>
		            </kendo:dataSource-schema>
		            <kendo:dataSource-transport parameterMap="getFechas">
		                <kendo:dataSource-transport-read url="${transportReadUrlAditivo}" />
		            </kendo:dataSource-transport>
		        </kendo:dataSource>
		    </kendo:grid>
		</td>
	</tr>
	<tr>
		<td>
			<kendo:chart name="chartAditivo">
						<kendo:chart-title text="Aditivos mas utilizados" />
						<kendo:chart-legend position="top" />
						<kendo:chart-series>
							<kendo:chart-seriesItem type="pie" data="${aditivoList}" categoryField="codigoMateriaPrima" field="porcentaje" >
								<kendo:chart-seriesItem-labels visible="true"
									template="#= category # - #= value #%" />
							</kendo:chart-seriesItem>
						</kendo:chart-series>
						<kendo:chart-tooltip visible="true"
								template="#= category # - #= value #%" />
			</kendo:chart>
		</td>
	</tr>
</table>    
    
<table>
	<tr>
		<td>
			<h3>Diluyentes</h3>
			<c:url value="/EstadisticaMateriaPrima/diluyente/" var="transportReadUrlDiluyente" />
    		<kendo:grid name="gridDiluyente" pageable="true" groupable="true" sortable="true" filterable="false">
      			<kendo:grid-columns>
            		<kendo:grid-column title="ID" field="id" filterable="false" />
            		<kendo:grid-column title="Codigo de Materia Prima" field="codigoMateriaPrima"  />
            		<kendo:grid-column title="Descripcion" field="descripcion" />
            		<kendo:grid-column title="Porcentaje %" field="porcentaje" filterable="true" />
        		</kendo:grid-columns>
        		<kendo:dataSource pageSize="10">
             		<kendo:dataSource-schema>
                		<kendo:dataSource-schema-model>
                    		<kendo:dataSource-schema-model-fields>
                        	<kendo:dataSource-schema-model-field name="id" type="string" />
                        	<kendo:dataSource-schema-model-field name="codigoMateriaPrima" type="string" />
                        	<kendo:dataSource-schema-model-field name="descripcion" type="string" />
                        	<kendo:dataSource-schema-model-field name="porcentaje" type="number" />
                    </kendo:dataSource-schema-model-fields>
                </kendo:dataSource-schema-model>
            	</kendo:dataSource-schema>
            		<kendo:dataSource-transport parameterMap="getFechas">>
                	<kendo:dataSource-transport-read url="${transportReadUrlDiluyente}"/>
            	</kendo:dataSource-transport>
        	</kendo:dataSource>
    	</kendo:grid>
		</td>
	</tr>
	<tr>
		<td>
			<kendo:chart name="chartDiluyente">
						<kendo:chart-title text="Diluyente mas utilizados" />
						<kendo:chart-legend position="top" />
						<kendo:chart-series>
							<kendo:chart-seriesItem type="pie" data="${diluyenteList}" categoryField="codigoMateriaPrima" field="porcentaje" >
								<kendo:chart-seriesItem-labels visible="true" template="#= category # - #= value #%" />
							</kendo:chart-seriesItem>
						</kendo:chart-series>
						<kendo:chart-tooltip visible="true" template="#= category # - #= value #%" />
			</kendo:chart>
		</td>
	</tr>
</table>    
    
	
<script>

	contextPath = '<%=request.getContextPath()%>';
	var endPicker;
	var startPicker;

	$(document).ready(function() {
		$(".configuration").bind("change", refresh);
	});

	function getFechas() {
		endPicker = $("#end").data("kendoDatePicker");
		startPicker = $("#start").data("kendoDatePicker");

		return "fi=" + startPicker.value() + "&ff=" + endPicker.value();
	}

	function filtrar() {
		//$("#gridAdhesivo").data("kendoGrid").dataSource.read();
		//$("#gridAditivo").data("kendoGrid").dataSource.read();
		//$("#gridPigmento").data("kendoGrid").dataSource.read();
		//$("#gridADiluyente").data("kendoGrid").dataSource.read();
		
		window.location.href=contextPath + '/EstadisticaMateriaPrima/filtro?' + getFechas();
	}

	function startChange() {
		var endPicker = $("#end").data("kendoDatePicker"), startDate = this
				.value();

		if (startDate) {
			startDate = new Date(startDate);
			startDate.setDate(startDate.getDate() + 1);
			endPicker.min(startDate);
		}
	}

	function endChange() {
		var startPicker = $("#start").data("kendoDatePicker"), endDate = this
				.value();

		if (endDate) {
			endDate = new Date(endDate);
			endDate.setDate(endDate.getDate() - 1);
			startPicker.max(endDate);
		}
	}

	function refresh() {
		var chart = $("#chart").data("kendoChart"), pieSeries = chart.options.series[0], labels = $(
				"#labels").prop("checked"), alignInputs = $("input[name='alignType']"), alignLabels = alignInputs
				.filter(":checked").val();

		chart.options.transitions = false;
		pieSeries.labels.visible = labels;
		pieSeries.labels.align = alignLabels;

		alignInputs.attr("disabled", !labels);

		chart.refresh();
	}
</script>
         
    <style>
	    .k-chart {
	        height: 280px;
	        padding: 37px;
	        margin: 0 0 50px 0;
	        width: 390px;
	    }
	</style>
</body>
</html>