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
					action="/web/Produccion/ProduccionAlta/addProduccion"
							modelAttribute="produccionForm" cssClass="cleanform">
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
						placeholder="Seleccione formato" suggest="true"
						value="${produccionForm.formato1}">
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
						placeholder="Seleccione formato" suggest="true"
						value="${produccionForm.formato2}">
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
						value="${produccionForm.fondo}">
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
						value="${produccionForm.film}">
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
						placeholder="Select" suggest="true"
						value="${produccionForm.impreso}">
						<kendo:dataSource data="${cantidadColoresImpreso}"></kendo:dataSource>
					</kendo:comboBox>
				</td>
				<td>
					Cantidad de colores
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="tinta">Tinta:</form:label>
				</td>
				<td>
					<form:input path="tinta" class="k-textbox"/>
				</td>
				<td>
				Litros x color impreso
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="adhesivo">Adhesivos:</form:label>
				</td>
				<td>
					<form:input path="adhesivo" class="k-textbox"/>
				</td>
				<td>
					Kilos
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="pigmento">Pigmentos:</form:label>
				</td>
				<td>
					<form:input path="pigmento" class="k-textbox"/>
				</td>
				<td>
					Kilos
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="diluyente">Diluyentes:</form:label>
				</td>
				<td>
					<form:input path="diluyente" class="k-textbox"/>
				</td>
				<td>
					Litros
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="aditivo">Aditivos:</form:label>
				</td>
				<td>
					<form:input path="aditivo" class="k-textbox"/>
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