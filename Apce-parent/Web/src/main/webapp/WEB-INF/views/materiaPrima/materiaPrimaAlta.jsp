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
					action="/web/MateriaPrima/MateriaPrimaAlta/addMateriaPrima"
							modelAttribute="materiaPrimaForm" cssClass="cleanform">
		<div id="example" class="k-content">
			<div>
				<ul class="forms">
					<li>
						<c:if test="${not empty message}">
							<div id="message">${message}</div>
						</c:if>
						<form:errors path="*" cssClass="errorblock" element="li" />
					</li>
					<li>
						<form:label path="codigoMateriaPrima">Codigo Materia Prima:</form:label>
						<form:input path="codigoMateriaPrima" class="k-textbox"/>
					</li>
					<li>
						<form:label path="tipoMateriaPrima">Tipo Materia Prima:</form:label>
						<kendo:comboBox name="tipoMateriaPrima" select="onSelectTipo" 
								placeholder="Seleccion el tipo" 
								value="${materiaPrimaForm.tipoMateriaPrima}">
								<kendo:dataSource data="${tiposMateriaPrima}"></kendo:dataSource>
						</kendo:comboBox>
					</li>
					<li id="li_color" style="display: none;">
						<form:label path="color">Color :</form:label>
						<kendo:comboBox name="color" 
								placeholder="Seleccione color"
								value="${materiaPrimaForm.color}">
								<kendo:dataSource data="${colores}"></kendo:dataSource>
						</kendo:comboBox>
					</li>
					<li>
						<form:label path="descripcion">Descripcion:</form:label>
						<form:input path="descripcion"  class="k-textbox"/>
					</li>
					<li>
						<input type="submit" value="Agregar Materia Prima" class="k-button" />
					</li>
				</ul>
</div>
</div>
	</form:form>

        <style scoped>
            .forms {
                float: left;
            }
            
            .forms label {
                float: left;
            }
            
            .forms li {
                margin-bottom: 5px;
                list-style: none;
            }

            .forms li > * {
                width: 200px;
            }
        </style>
        
        <script type="text/javascript">

function onSelectTipo(e) {
        var dataItem = this.dataItem(e.item.index());
    
    switch (dataItem) {
	case "TINTA":
		$("#li_color").show('slow');
		break;
    
	case "PIGMENTO":
		$("#li_color").show('slow');
		break;
		
	default:
		$("#li_color").hide('slow');
    }
}
</script>   
</body>
</html>