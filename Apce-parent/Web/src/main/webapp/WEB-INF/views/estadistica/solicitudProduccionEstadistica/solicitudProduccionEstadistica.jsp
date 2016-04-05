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
		<form:form id="form" method="get"
			action="/web/EstadisticaSolicitudProduccion/filtro"
			modelAttribute="solicitudProduccionEstadisticaForm"
			cssClass="cleanform">
			<table>
				<tr>
					<td><input type="submit" value="filtrar" class="k-button" />
					</td>
				</tr>
				<tr>
					<td><form:label path="anio">Año:</form:label></td>
					<td><kendo:comboBox name="anio" placeholder="Seleccione Año"
							value="${solicitudProduccionEstadisticaForm.anio}">
							<kendo:dataSource data="${anios}"></kendo:dataSource>
						</kendo:comboBox></td>
				</tr>
				<tr>
					<td><kendo:chart name="chart" >
							<kendo:chart-series>
								<kendo:chart-seriesItem type="column" data="${cantidadesAnio}" color="green" 
									aggregate="sum"  />
							</kendo:chart-series>
							<kendo:chart-categoryAxis>
								<kendo:chart-categoryAxisItem type="date" categories="${fechasAnio}" 
									baseUnit="months" >
									<kendo:chart-categoryAxisItem-majorGridLines visible="true"  />
								</kendo:chart-categoryAxisItem>
							</kendo:chart-categoryAxis>
							<kendo:chart-valueAxis>
								<kendo:chart-valueAxisItem>
									<kendo:chart-valueAxisItem-line visible="false"  />
								</kendo:chart-valueAxisItem>
							</kendo:chart-valueAxis>
						</kendo:chart></td>
				</tr>
				<tr>
					<td><form:label path="mes">Mes:</form:label></td>
					<td><kendo:comboBox name="mes" placeholder="Seleccione Mes"
							value="${solicitudProduccionEstadisticaForm.mes}">
							<kendo:dataSource data="${meses}"></kendo:dataSource>
						</kendo:comboBox></td>
				</tr>
				<tr>
					<td>
						<kendo:chart name="chart2">
							<kendo:chart-series>
								<kendo:chart-seriesItem type="column" data="${cantidadesMes}" 
									aggregate="sum" />
							</kendo:chart-series>
							<kendo:chart-categoryAxis>
								<kendo:chart-categoryAxisItem type="date" categories="${fechasMes}" 
									baseUnit="weeks">
									<kendo:chart-categoryAxisItem-majorGridLines visible="false" />
								</kendo:chart-categoryAxisItem>
							</kendo:chart-categoryAxis>
							<kendo:chart-valueAxis>
								<kendo:chart-valueAxisItem>
									<kendo:chart-valueAxisItem-line visible="false" />
								</kendo:chart-valueAxisItem>
							</kendo:chart-valueAxis>
						</kendo:chart>
					</td>
				</tr>
			</table>
		</form:form>
	</div>
	
	
<%-- 
<div style="overflow: scroll;overflow-y: hidden; width: 77%">
<kendo:chart name="chart3" style="width:150%">
							<kendo:chart-series>
								<kendo:chart-seriesItem type="column" data="${cantidadesMes}" 
									aggregate="sum" />
							</kendo:chart-series>
							<kendo:chart-categoryAxis>
								<kendo:chart-categoryAxisItem type="date" categories="${fechasMes}" 
									baseUnit="weeks">
									<kendo:chart-categoryAxisItem-majorGridLines visible="false" />
								</kendo:chart-categoryAxisItem>
							</kendo:chart-categoryAxis>
							<kendo:chart-valueAxis>
								<kendo:chart-valueAxisItem>
									<kendo:chart-valueAxisItem-line visible="false" />
								</kendo:chart-valueAxisItem>
							</kendo:chart-valueAxis>
						</kendo:chart>

</div>
 --%>
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


	<style>
.k-chart {
	height: 280px;
	padding: 37px;
	width: 590px;
}
</style>
</body>
</html>