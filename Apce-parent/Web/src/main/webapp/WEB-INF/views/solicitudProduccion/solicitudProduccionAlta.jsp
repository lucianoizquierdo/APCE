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
					action="/web/SolicitudProduccion/SolicitudProduccionAlta/saveOrUpdate"
							modelAttribute="solicitudProduccionForm" cssClass="cleanform">
		<div id="example" class="k-content">
			<div>
				<span> <c:if test="${not empty message}">
						<div id="message">${message}</div>
					</c:if> <form:errors path="*" cssClass="errorblock" element="span" />
				</span>
			</div>
		<table class="forms">
		 <tr>
				<td>
					<form:label path="id">Id:</form:label>
				</td>
				<td>
				 	 <form:input path="id" class="k-textbox" disabled="true"/>
				</td>
		</tr>
		<tr>
				<td>
					<form:label path="nombre">Nombre:</form:label>
				</td>
				<td>
				 	 <form:input path="nombre" class="k-textbox"/>
				</td>
		</tr>
		<tr>
				<td>
					<form:label path="descripcion">Descripcion:</form:label>
				</td>
				<td>
				 	 <form:input path="descripcion" class="k-textbox"/>
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
					<form:label path="cantidadRollosName">Cantidad de rollos:</form:label>
				</td>
				<td>
				 	<kendo:comboBox name="cantidadRollosName" 
						placeholder="Seleccione rollos"  
						value="${solicitudProduccionForm.cantidadRollosName}">
						<kendo:dataSource data="${cantidadRollos}"></kendo:dataSource>
					</kendo:comboBox> 
				</td>
			</tr>
		 	 <tr>
				<td>
					<form:label path="formato1">Formato 1:</form:label>
				</td>
				<td>
				 	<kendo:comboBox name="formato1" 
						placeholder="Seleccione formato"  
						value="${solicitudProduccionForm.formato1}">
						<kendo:dataSource data="${formatos1}"></kendo:dataSource>
					</kendo:comboBox> 
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="formato2">Formato 2:</form:label>
				</td>
				<td>
					<kendo:comboBox name="formato2" 
						placeholder="Seleccione formato" 
						value="${solicitudProduccionForm.formato2}">
						<kendo:dataSource data="${formatos2}"></kendo:dataSource>
					</kendo:comboBox>
				</td>
			</tr>
			<tr> 
				<td>
					<form:label path="fondo">Fondo:</form:label>
				</td>
				<td>
					<kendo:comboBox name="fondo" 
						placeholder="Seleccione color de fondo" suggest="true"
						value="${solicitudProduccionForm.fondo}">
						<kendo:dataSource data="${colores}"></kendo:dataSource>
					</kendo:comboBox>
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="film">Film:</form:label>
				</td>
				<td>
					<kendo:comboBox name="film" 
						placeholder="Select" suggest="true"
						value="${solicitudProduccionForm.film}">
						<kendo:dataSource data="${films}"></kendo:dataSource>
					</kendo:comboBox>
				</td>
				<td>
					Espesor en MM (Milimetros)
				</td>
			</tr>
			<tr> 
				<td>
					<form:label path="caja">Empaque:</form:label>
				</td>
				<td>
					<kendo:comboBox name="caja" 
						placeholder="Seleccione caja" 
						value="${solicitudProduccionForm.caja}">
						<kendo:dataSource data="${cajas}"></kendo:dataSource>
					</kendo:comboBox>
				</td>
				<td>
					Rollos por caja
				</td>
			</tr>  
			<tr>
				<td>
					<form:label path="impreso" placeholder="Cantidad de colores">Impreso:</form:label>
				</td>
				<td>
					<kendo:comboBox name="impreso" 
						placeholder="Select" select="onSelectImpreso"
						value="${solicitudProduccionForm.impreso}">
						<kendo:dataSource data="${cantidadColoresImpreso}"></kendo:dataSource>
					</kendo:comboBox>
				</td>
				<td>
					Cantidad de colores
				</td>
			</tr>  
			<tr id="colores1" style="display: none;"> 
				<td>
					<form:label path="color1">Color 1:</form:label>
				</td>
				<td>
					<kendo:comboBox name="color1"  
							placeholder="Seleccion el color" 
							value="${solicitudProduccionForm.color1}">
							<kendo:dataSource data="${colores}"></kendo:dataSource>
					</kendo:comboBox>
				</td>
				<td>
					<form:label path="idTinta1">Tinta 1:</form:label>
				</td>
				<td>
					<kendo:comboBox name="idTinta1"  
								placeholder="Seleccione tinta" 
								value="${solicitudProduccionForm.idTinta1}" dataTextField="codigoMateriaPrima" dataValueField="id">
								<kendo:dataSource data="${tintasAseleccionar}"></kendo:dataSource>
					</kendo:comboBox>
				</td>
			</tr>
			<tr id="colores2" style="display: none;" > 
				<td>
					<form:label path="color2">Color 2:</form:label>
				</td>
				<td>
					<kendo:comboBox name="color2"  
							placeholder="Seleccion el color" 
							value="${solicitudProduccionForm.color2}">
							<kendo:dataSource data="${colores}"></kendo:dataSource>
					</kendo:comboBox>
				</td>
				<td>
					<form:label path="idTinta2">Tinta 2:</form:label>
				</td>
				<td>
					<kendo:comboBox name="idTinta2"  
								placeholder="Seleccione tinta" 
								value="${solicitudProduccionForm.idTinta2}" dataTextField="codigoMateriaPrima" dataValueField="id">
								<kendo:dataSource data="${tintasAseleccionar}"></kendo:dataSource>
					</kendo:comboBox>
				</td>
			</tr>
			 <tr id="colores3" style="display: none;"> 
				<td>
					<form:label path="color3">Color 3:</form:label>
				</td>
				<td>
					<kendo:comboBox name="color3"  
							placeholder="Seleccion el color" 
							value="${solicitudProduccionForm.color3}">
							<kendo:dataSource data="${colores}"></kendo:dataSource>
					</kendo:comboBox>
				</td>
			 	<td>
					<form:label path="idTinta3">Tinta 3:</form:label>
				</td>
				<td>
					<kendo:comboBox name="idTinta3"  
								placeholder="Seleccione tinta" 
								value="${solicitudProduccionForm.idTinta3}" dataTextField="codigoMateriaPrima" dataValueField="id">
								<kendo:dataSource data="${tintasAseleccionar}"></kendo:dataSource>
					</kendo:comboBox>
				</td> 
			</tr>
			<tr> 
				<td>
					<form:label path="idAdhesivo">Adhesivo:</form:label>
				</td>
				<td>
					<kendo:comboBox name="idAdhesivo" 
						placeholder="Seleccione Adhesivo" 
						value="${solicitudProduccionForm.idAdhesivo}" dataTextField="codigoMateriaPrima" dataValueField="id">
						<kendo:dataSource data="${adhesivos}"></kendo:dataSource>
					</kendo:comboBox>
				</td>
			</tr>  
			<tr> 
				<td>
					<form:label path="idPigmento">Pigmento:</form:label>
				</td>
				<td>
					<kendo:comboBox name="idPigmento" 
						placeholder="Seleccione Pigmento" 
						value="${solicitudProduccionForm.idPigmento}" dataTextField="codigoMateriaPrima" dataValueField="id">
						<kendo:dataSource data="${pigmentos}"></kendo:dataSource>
					</kendo:comboBox>
				</td>
			</tr>  
			<tr> 
				<td>
					<form:label path="idDiluyente">Diluyente:</form:label>
				</td>
				<td>
					<kendo:comboBox name="idDiluyente" 
						placeholder="Seleccione Diluyente" 
						value="${solicitudProduccionForm.idDiluyente}" dataTextField="codigoMateriaPrima" dataValueField="id">
						<kendo:dataSource data="${diluyentes}"></kendo:dataSource>
					</kendo:comboBox>
				</td>
			</tr>
			<tr> 
				<td>
					<form:label path="idAditivo">Aditivo:</form:label>
				</td>
				<td>
					<kendo:comboBox name="idAditivo" 
						placeholder="Seleccione Aditivo" 
						value="${solicitudProduccionForm.idAditivo}" dataTextField="codigoMateriaPrima" dataValueField="id">
						<kendo:dataSource data="${aditivos}"></kendo:dataSource>
					</kendo:comboBox>
				</td>
			</tr>
			<tr>  
				<td>
				<input type="submit" value="Guardar" class="k-button" />
				</td>
				<td>
				<c:if test="${solicitudProduccionForm.id > 0}">
				<a href="/web/OrdenProduccion/generarOrdenProduccion?id=${solicitudProduccionForm.id}" class="k-button">Generar Orden Produccion</a>
				</c:if>
				</td>
			</tr> 
			
		</table>
			<div>
				<label>Medida del Buje 1 Metro.</label>
			</div>
</div>
	</form:form>

        
<script type="text/javascript">
function onSelectImpreso(e) {
        var dataItem = this.dataItem(e.item.index());
    
    switch (dataItem) {
	case 1:
		$("#colores1").show('slow');
		$("#colores2").hide('slow');
		$('#color2').data('kendoComboBox').value("");
		$("#colores3").hide('slow');
		$('#color3').data('kendoComboBox').value("");
		break;
    
	case 2:
		$("#colores1").show('slow');
		$("#colores2").show('slow');
		$("#colores3").hide('slow');
		$('#color3').data('kendoComboBox').value("");
		break;
	case 3:
		$("#colores1").show('slow');
		$("#colores2").show('slow');
		$("#colores3").show('slow');
		break;
    }
}
    

$(document).ready(function(){
	
    if($('#color1').val() != "" )
    	$("#colores1").show();
    
    if($("#color2").val() != "")
    	$("#colores2").show();
    
    if($("#colores3").val() != "")
    	$("#colores3").show();
});

</script>   
</body>
</html>