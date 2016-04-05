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
					action="/web/OrdenProduccion/OrdenProduccionAlta/saveOrUpdate"
							modelAttribute="ordenProduccionForm" cssClass="cleanform">
		<div id="example" class="k-content">
			<div>
				<span> <c:if test="${not empty message}">
						<div id="message">${message}</div>
					</c:if> <form:errors path="*" cssClass="errorblock" element="span" />
				</span>
			</div>
			<div>
				<label>Estandar de Produccion para : 100 rollos.</label>
			</div>
		<table class="forms">
		<tr>
			<td>
				<form:label path="id">ID Orden Produccion:</form:label>
			</td>
			<td>
			 	 <form:input path="id" class="k-textbox" disabled="true"/>
			</td>
			<td>
				<form:label path="tiempoEstimado">Tiempo Estimado para la produccion:</form:label>
			</td>
			<td>
			 	 <form:input path="tiempoEstimado" class="k-textbox" disabled="true"/>
			</td>
			<td>
			 	 HH:MM
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="solicitudProduccion.id">ID Solicitud Produccion:</form:label>
			</td>
			<td>
			 	 <form:input path="solicitudProduccion.id" class="k-textbox" disabled="true"/>
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="nombre">Nombre:</form:label>
			</td>
			<td>
			 	 <form:input path="nombre" class="k-textbox" disabled="true"/>
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="descripcion">Descripcion:</form:label>
			</td>
			<td>
			 	 <form:input path="descripcion" class="k-textbox" disabled="true"/>
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="solicitudProduccion.formato1">Formato1:</form:label>
			</td>
			<td>
			 	 <form:input path="solicitudProduccion.formato1" class="k-textbox" disabled="true"/>
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="solicitudProduccion.formato2">Formato2:</form:label>
			</td>
			<td>
			 	 <form:input path="solicitudProduccion.formato2" class="k-textbox" disabled="true"/>
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="solicitudProduccion.fondo">Fondo:</form:label>
			</td>
			<td>
			 	 <form:input path="solicitudProduccion.fondo" class="k-textbox" disabled="true"/>
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="solicitudProduccion.film.numero">Film:</form:label>
			</td>
			<td>
			 	 <form:input path="solicitudProduccion.film.numero" class="k-textbox" disabled="true"/>
			</td>
			<td>
			 	 <label>Milimetros</label>
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="solicitudProduccion.cantidadRollos">Rollos:</form:label>
			</td>
			<td>
			 	 <form:input path="solicitudProduccion.cantidadRollos" class="k-textbox" disabled="true"/>
			</td>
			
		</tr>
		<tr>
			<td>
				<form:label path="cajas">Empaque:</form:label>
			</td>
			<td>
			 	 <form:input path="cajas" class="k-textbox"/>
			</td>
			<td>
			 	 <label>Cajas de ${solicitudProduccionForm.caja.descripcion}</label>
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="solicitudProduccion.impreso">Impreso:</form:label>
			</td>
			<td>
			 	 <form:input path="solicitudProduccion.impreso" class="k-textbox" disabled="true" id="impreso"/>
			</td>
			<td>
			 	 <label>Cantidad de colores</label>
			</td>
		</tr>
			<tr id="colores1" style="display: none;"> 
				<td>
					<form:label path="color1">Color 1:</form:label>
				</td>
				<td>
					<form:input path="solicitudProduccion.color1" class="k-textbox" disabled="true"/>
				</td>
			</tr>
			<tr id="colores2" style="display: none;" > 
				<td>
					<form:label path="color2">Color 2:</form:label>
				</td>
				<td>
					<form:input path="solicitudProduccion.color2" class="k-textbox" disabled="true"/>
				</td>
			</tr>
			 <tr id="colores3" style="display: none;"> 
				<td>
					<form:label path="color3">Color 3:</form:label>
				</td>
				<td>
					<form:input path="solicitudProduccion.color3" class="k-textbox" disabled="true"/>
				</td>
			</tr>
		<tr>
			<td>
				<form:label path="solicitudProduccion.adhesivo.codigoMateriaPrima">Adhesivo:</form:label>
			</td>
			<td>
			 	 <form:input path="solicitudProduccion.adhesivo.codigoMateriaPrima" class="k-textbox" disabled="true"/>
			</td>
			<td>
				<form:label path="adhesivoKilos">Kilos:</form:label>
			</td>
			<td>
			 	 <form:input path="adhesivoKilos" class="k-textbox" disabled="true"/>
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="solicitudProduccion.pigmento.codigoMateriaPrima">Pigmento:</form:label>
			</td>
			<td>
			 	 <form:input path="solicitudProduccion.pigmento.codigoMateriaPrima" class="k-textbox" disabled="true"/>
			</td>
			<td>
				<form:label path="pigmentoKilos">Kilos:</form:label>
			</td>
			<td>
			 	 <form:input path="pigmentoKilos" class="k-textbox" disabled="true"/>
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="solicitudProduccion.diluyente.codigoMateriaPrima">Diluyente:</form:label>
			</td>
			<td>
			 	 <form:input path="solicitudProduccion.diluyente.codigoMateriaPrima" class="k-textbox" disabled="true"/>
			</td>
			<td>
				<form:label path="diluyenteLitros">Litros:</form:label>
			</td>
			<td>
			 	 <form:input path="diluyenteLitros" class="k-textbox" disabled="true"/>
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="solicitudProduccion.aditivo.codigoMateriaPrima">Aditivo:</form:label>
			</td>
			<td>
			 	 <form:input path="solicitudProduccion.aditivo.codigoMateriaPrima" class="k-textbox" disabled="true"/>
			</td>
			<td>
				<form:label path="aditivoKilos">Kilos:</form:label>
			</td>
			<td>
			 	 <form:input path="aditivoKilos" class="k-textbox" disabled="true"/>
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="observaciones">Observaciones:</form:label>
			</td>
			<td>
			 	 <form:input path="observaciones" class="k-textbox" />
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="procesada">Orden procesada:</form:label>
			</td>
			<td>
			 	 <form:checkbox path="procesada" />
			</td>
			<td>
				<form:label path="fechaProcesada">Fecha de proceso:</form:label>
			</td>
			<td>
			 	 <form:input path="fechaProcesada" class="k-textbox" disabled="true" />
			</td>
		</tr>
			<tr>   
				<td>
				<input type="submit" value="Guardar" class="k-button" />
				</td>
				<td>
				<%-- <c:if test="${solicitudProduccionForm.id} > 0">
				<input type="button" value="Guardar" class="k-button" onclick="generarOrdenProduccion(${solicitudProduccionForm.id})"/>
				</c:if> --%>
				</td>
			</tr> 
			
		</table>
			<div>
				<label>Medida del Buje 1 Metro.</label>
			</div>
</div>
	</form:form>

        
<script type="text/javascript">

function generarOrdenProduccion(id)
{
	alert("id: "+ id);
}

$(document).ready(function(){
	
    
    impreso = $("#impreso").val(); 

    if(impreso == 1)
    {
		$("#colores1").show();
    }
    if(impreso == 2)
    {
		$("#colores1").show();
		$("#colores2").show();
    }
    if(impreso == 3)
    {
    	$("#colores1").show();
		$("#colores2").show();
		$("#colores3").show();
    }
});


        

</script>   
</body>
</html>