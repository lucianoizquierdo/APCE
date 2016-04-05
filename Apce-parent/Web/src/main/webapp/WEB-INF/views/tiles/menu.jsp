<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/views/tiles/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
var ordenProduccionList		= "Lista de Ordenes de produccion";
var solicitudProduccionList	= "Lista de Solicitud de produccion";
var solicitudProduccionAlta	= "Crear Solicitud de produccion";
var estandarProduccionList 	= "Lista de Estandares de produccion";
var estandarProduccionAlta 	= "Crear Estandar de produccion";
var materiaPrimaList 		= "Lista Materias Primas";
var materiaPrimaAlta 		= "Alta Materias Primas";
//var tipoMateriaPrimaList 	= "Lista Tipo Materia Prima";
//var tipoMateriaPrimaAlta 	= "Alta Tipo Materia Prima";
var sucursalList 			= "Lista Sucursales";
var sucursalAlta 			= "Alta Sucursales";
var usuarioList 			= "Lista Usuarios";
var usuarioAlta 			= "Alta Usuarios";
var prueba 					= "Prueba";

//Estadisticas
var materiaPrimaEstadistica 		= "Informe Materias Primas";
var solicitudProduccionEstadistica	= "Informe Solicitudes de Produccion";
var ordenProduccionEstadistica		= "Informe Ordenes de Produccion";
var solicitudProduccionPendiente 	= "Solicitudes de Produccion Pendientes";
var ordenProduccionPendiente 		= "Ordenes de Produccion Pendientes";

</script>
</head>
<body>
	<div id="menu">
		<kendo:menu name="Menu" open="onOpen" close="onClose"
			select="onSelect">
			<kendo:menu-items>
				<kendo:menu-item text="Products">
					<kendo:menu-items>
						<kendo:menu-item text="Furniture">
							<kendo:menu-items>
								<kendo:menu-item text="Tables & Chairs"></kendo:menu-item>
								<kendo:menu-item text="Sofas"></kendo:menu-item>
								<kendo:menu-item text="Occasional Furniture"></kendo:menu-item>
								<kendo:menu-item text="Childerns Furniture"></kendo:menu-item>
								<kendo:menu-item text="Beds"></kendo:menu-item>
							</kendo:menu-items>
						</kendo:menu-item>
						<kendo:menu-item text="Decor">
							<kendo:menu-items>
								<kendo:menu-item text="Bed Linen"></kendo:menu-item>
								<kendo:menu-item text="Throws"></kendo:menu-item>
								<kendo:menu-item text="Curtains & Blinds"></kendo:menu-item>
								<kendo:menu-item text="Rugs"></kendo:menu-item>
								<kendo:menu-item text="Carpets"></kendo:menu-item>
							</kendo:menu-items>
						</kendo:menu-item>
						<kendo:menu-item text="Storage">
							<kendo:menu-items>
								<kendo:menu-item text="Wall Shelving"></kendo:menu-item>
								<kendo:menu-item text="Kids Storage"></kendo:menu-item>
								<kendo:menu-item text="Baskets"></kendo:menu-item>
								<kendo:menu-item text="Multimedia Storage"></kendo:menu-item>
								<kendo:menu-item text="Floor Shelving"></kendo:menu-item>
								<kendo:menu-item text="Toilet Roll Holders"></kendo:menu-item>
								<kendo:menu-item text="Storage Jars"></kendo:menu-item>
								<kendo:menu-item text="Drawers"></kendo:menu-item>
								<kendo:menu-item text="Boxes"></kendo:menu-item>
							</kendo:menu-items>
						</kendo:menu-item>
						<kendo:menu-item text="Lights">
							<kendo:menu-items>
								<kendo:menu-item text="Ceiling"></kendo:menu-item>
								<kendo:menu-item text="Table"></kendo:menu-item>
								<kendo:menu-item text="Floor"></kendo:menu-item>
								<kendo:menu-item text="Shades"></kendo:menu-item>
								<kendo:menu-item text="Wall Lights"></kendo:menu-item>
								<kendo:menu-item text="Spotlights"></kendo:menu-item>
								<kendo:menu-item text="Push Light"></kendo:menu-item>
								<kendo:menu-item text="String Lights"></kendo:menu-item>
							</kendo:menu-items>
						</kendo:menu-item>
					</kendo:menu-items>
				</kendo:menu-item>
				<kendo:menu-item text="Stores">
					<kendo:menu-items>
						<kendo:menu-item>
							<kendo:menu-item-content>
								<h2>Around the Globe</h2>
								<ol>
									<li>United States</li>
									<li>Europe</li>
									<li>Canada</li>
									<li>Australia</li>
								</ol>
								<!-- <img src="../../resources/web/menu/map.png"
									alt="Stores Around the Globe" /> -->
								<button class="k-button">See full list</button>
							</kendo:menu-item-content>
						</kendo:menu-item>
					</kendo:menu-items>
				</kendo:menu-item>
				<kendo:menu-item text="Blog"></kendo:menu-item>
				<kendo:menu-item text="Company"></kendo:menu-item>
				<kendo:menu-item text="Produccion">
						<kendo:menu-items>
						<kendo:menu-item text="Lista de Ordenes de produccion"/>
						<kendo:menu-item text="Estandares de Produccion">
							<kendo:menu-items>
								<kendo:menu-item text="Lista de Estandares de produccion" />
								<kendo:menu-item text="Crear Estandar de produccion" />
							</kendo:menu-items>
						</kendo:menu-item>
						<kendo:menu-item text="Solicitudes de Produccion">
							<kendo:menu-items>
								<kendo:menu-item text="Lista de Solicitud de produccion" />
								<kendo:menu-item text="Crear Solicitud de produccion" />
							</kendo:menu-items>
						</kendo:menu-item>
					</kendo:menu-items>
				</kendo:menu-item>
				
				<kendo:menu-item text="News" enabled="false"></kendo:menu-item>
				<kendo:menu-item text="Estadisticas">
					<kendo:menu-items>
						<kendo:menu-item text="Informes">
							<kendo:menu-items>
								<kendo:menu-item text="Informe Materias Primas"/>
								<kendo:menu-item text="Informe Solicitudes de Produccion"/>
								<kendo:menu-item text="Informe Ordenes de Produccion"/>
							</kendo:menu-items>
						</kendo:menu-item>
						<kendo:menu-item text="Pendientes">
							<kendo:menu-items>
								<kendo:menu-item text="Solicitudes de Produccion Pendientes"/>
								<kendo:menu-item text="Ordenes de Produccion Pendientes"/>
							</kendo:menu-items>
						</kendo:menu-item>
					</kendo:menu-items>
				</kendo:menu-item>
				
				<kendo:menu-item text="ABM">
					<kendo:menu-items>
						<kendo:menu-item text="Materia Prima">
							<kendo:menu-items>
							<%-- 	<kendo:menu-item text="Alta Tipo Materia Prima" />
								<kendo:menu-item text="Lista Tipo Materia Prima" /> --%>
								<kendo:menu-item text="Alta Materias Primas" />
								<kendo:menu-item text="Lista Materias Primas" />
							</kendo:menu-items>
						</kendo:menu-item>
					</kendo:menu-items>
					<kendo:menu-items>
						<kendo:menu-item text="Sucursales">
							<kendo:menu-items>
								<kendo:menu-item text="Alta Sucursales"/>
								<kendo:menu-item text="Lista Sucursales" />
							</kendo:menu-items>
						</kendo:menu-item>
					</kendo:menu-items>
					<kendo:menu-items>
						<kendo:menu-item text="Usuarios">
							<kendo:menu-items>
								<kendo:menu-item text="Alta Usuarios" />
								<kendo:menu-item text="Lista Usuarios" />
							</kendo:menu-items>
						</kendo:menu-item>
					</kendo:menu-items>
				</kendo:menu-item>
				<kendo:menu-item text="Pruebas">
					<kendo:menu-items>
						<kendo:menu-item text="Prueba" ></kendo:menu-item>
						<kendo:menu-item text="Throws"></kendo:menu-item>
						<kendo:menu-item text="Curtains & Blinds"></kendo:menu-item>
						<kendo:menu-item text="Rugs"></kendo:menu-item>
						<kendo:menu-item text="Carpets"></kendo:menu-item>
					</kendo:menu-items>
				</kendo:menu-item>
			</kendo:menu-items>
		</kendo:menu>
	</div>
	<!-- <div class="demo-section">
		<h3 class="title">Console log</h3>
		<div class="console"></div>
	</div> -->
	<script>
	
	
	
		function onOpen(e) {
			//kendoConsole.log("Opened: " + $(e.item).children(".k-link").text());
		}

		function onClose(e) {
			//kendoConsole.log("Closed: " + $(e.item).children(".k-link").text());
		}

		function onSelect(e) {
			//kendoConsole.log("Selected: " + $(e.item).children(".k-link").text());
			contextPath = '<%=request.getContextPath()%>';
			menuSelected = $(e.item).children(".k-link").text();

			switch (menuSelected) {
			case solicitudProduccionPendiente:
				window.location.href=contextPath + '/EstadisticaSolicitudProduccionPendiente/';
				break;
			case ordenProduccionPendiente:
				window.location.href=contextPath + '/EstadisticaOrdenProduccionPendiente/';
				break;
			case ordenProduccionEstadistica:
				window.location.href=contextPath + '/EstadisticaOrdenProduccion/filtro/';
				break;
			case solicitudProduccionEstadistica:
				window.location.href=contextPath + '/EstadisticaSolicitudProduccion/filtro/';
				break;
			case ordenProduccionList:
				window.location.href=contextPath + '/OrdenProduccion/OrdenProduccionList';
				break;
			case materiaPrimaEstadistica:
				window.location.href=contextPath + '/EstadisticaMateriaPrima/';
				break;
			case solicitudProduccionList:
				window.location.href=contextPath + '/SolicitudProduccion/SolicitudProduccionList';
				break;
			case solicitudProduccionAlta:
				window.location.href=contextPath + '/SolicitudProduccion/SolicitudProduccionAlta';
				break;
			case estandarProduccionList:
				window.location.href=contextPath + '/EstandarProduccion/EstandarProduccionList';
				break;
			case estandarProduccionAlta:
				window.location.href=contextPath + '/EstandarProduccion/EstandarProduccionAlta';
				break;
			case materiaPrimaList:
				window.location.href=contextPath + '/MateriaPrima/MateriaPrimaList';
				break;
			case materiaPrimaAlta:
				window.location.href=contextPath + '/MateriaPrima/MateriaPrimaAlta';
				break;
			/* case tipoMateriaPrimaList:
				window.location.href=contextPath + '/MateriaPrima/TipoMateriaPrimaList';
				break;
			case tipoMateriaPrimaAlta:
				window.location.href=contextPath + '/MateriaPrima/TipoMateriaPrimaAlta';
				break; */
			case sucursalList:
				window.location.href=contextPath + '/Sucursal/SucursalList';
				break;
			case sucursalAlta:
				window.location.href=contextPath + '/Sucursal/SucursalAlta';
				break;
			case usuarioList:
				window.location.href=contextPath + '/Usuario/UsuarioList';
				break;
			case usuarioAlta:
				window.location.href=contextPath + '/Usuario/UsuarioAlta';
				break;
			case prueba:
				window.location.href=contextPath + '/Prueba/';
				break;
			default:
				alert('Nobody Wins!');
			}
		}
	</script>
	<!-- <div class="console"></div> -->




<style scoped>
#megaStore {
	width: 600px;
	margin: 30px auto;
	padding-top: 120px;
	/* background: url('../../resources/web/menu/header.jpg') no-repeat 0 0; */
}

#menu h2 {
	font-size: 1em;
	text-transform: uppercase;
	padding: 5px 10px;
}

#template img {
	margin: 5px 20px 0 0;
	float: left;
}

#template {
	width: 380px;
}

#template ol {
	float: left;
	margin: 0 0 0 30px;
	padding: 10px 10px 0 10px;
}

#template:after {
	content: ".";
	display: block;
	height: 0;
	clear: both;
	visibility: hidden;
}

#template .k-button {
	float: left;
	clear: left;
	margin: 5px 0 5px 12px;
}
</style>
</body>
</html>
