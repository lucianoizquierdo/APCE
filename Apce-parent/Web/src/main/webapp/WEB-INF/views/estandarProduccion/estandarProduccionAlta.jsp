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
				action="/web/EstandarProduccion/EstandarProduccionAlta/saveOrUpdate"
							modelAttribute="estandarProduccionForm" cssClass="cleanform">
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
					<form:label path="formato1">Formato 1:</form:label>
				</td>
				<td>
				 	<kendo:comboBox name="formato1" 
						placeholder="Seleccione formato"  
						value="${estandarProduccionForm.formato1}">
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
						value="${estandarProduccionForm.formato2}">
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
						value="${estandarProduccionForm.fondo}">
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
						value="${estandarProduccionForm.film}">
						<kendo:dataSource data="${films}"></kendo:dataSource>
					</kendo:comboBox>
				</td>
				<td>
					Espesor en MM (Milimetros)
				</td>
			</tr> 
			<tr>
				<td>
					<form:label path="impreso" placeholder="Cantidad de colores">Impreso:</form:label>
				</td>
				<td>
					<kendo:comboBox name="impreso" 
						placeholder="Cantidad de colores" 
						value="${estandarProduccionForm.impreso}">
						<kendo:dataSource data="${cantidadColoresImpreso}"></kendo:dataSource>
					</kendo:comboBox>
				</td>
				<td>
					Cantidad de colores
				</td>
			</tr>  
			<tr>
				<td>
					<form:label path="tiempoEstimado">Tiempo Estimado:</form:label>
				</td>
				<td>
					<form:input path="tiempoEstimado"  placeholder="Expresado en minutos" class="k-textbox"/>
				</td>
				<td>
					(Expresado en minutos)
				</td>
			</tr>  
			<tr>
				<td>
					<form:label path="tintaLitros">Tinta:</form:label>
				</td>
				<td>
					<form:input path="tintaLitros" class="k-textbox"/>
				</td>
				<td>
				Litros x color impreso
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="adhesivoKilos">Adhesivos:</form:label>
				</td>
				<td>
					<form:input path="adhesivoKilos" class="k-textbox"/>
				</td>
				<td>
					Kilos
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="pigmentoKilos">Pigmentos:</form:label>
				</td>
				<td>
					<form:input path="pigmentoKilos" class="k-textbox"/>
				</td>
				<td>
					Kilos
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="diluyenteLitros">Diluyentes:</form:label>
				</td>
				<td>
					<form:input path="diluyenteLitros" class="k-textbox"/>
				</td>
				<td>
					Litros
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="aditivoKilos">Aditivos:</form:label>
				</td>
				<td>
					<form:input path="aditivoKilos" class="k-textbox"/>
				</td>
				<td>
					Kilos
				</td>
			</tr>
			<tr>  
				<td>
				<input type="submit" value="Guardar" class="k-button" />
				</td>
			</tr>
			
		</table>
			<div>
				<label>Medida del Buje 1 Metro.</label>
			</div>
</div>
	</form:form>

        
        
</body>
</html>