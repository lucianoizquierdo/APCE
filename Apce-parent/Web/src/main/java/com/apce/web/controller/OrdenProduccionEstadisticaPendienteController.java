package com.apce.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.apce.modelo.OrdenProduccion;
import com.apce.modelo.kendo.DataSourceRequest;
import com.apce.modelo.kendo.DataSourceResult;
import com.apce.servicio.servicoInterfaz.OrdenProduccionService;
import com.apce.web.dto.OrdenProduccionDTO;
import com.apce.web.form.OrdenProduccionEstadisticaForm;
import com.apce.web.form.OrdenProduccionForm;
import com.apce.web.form.SolicitudProduccionEstadisticaForm;
import com.apce.web.helper.OrdenProduccionHelper;

@Controller
@RequestMapping("/EstadisticaOrdenProduccionPendiente")
@SessionAttributes({"ordenProduccionEstadisticaForm"} ) 
public class OrdenProduccionEstadisticaPendienteController {

	@Inject
	OrdenProduccionService ordenProduccionService;

	@Inject
	OrdenProduccionHelper ordenProduccionHelper;


	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

	@ModelAttribute("ordenProduccionEstadisticaForm")
	public OrdenProduccionEstadisticaForm createOrdenProduccionEstadisticaForm() {
		return new OrdenProduccionEstadisticaForm();
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getGraficoBarrasFiltrado(Model model, SolicitudProduccionEstadisticaForm spef) throws ParseException {

		List<OrdenProduccionDTO> ordenProduccionDTOList = ordenProduccionHelper.getOrdenProduccionDTO();

		//Collections.sort(adhesivoList);

		model.addAttribute("ordenProduccionList", ordenProduccionDTOList);

		return "ordenProduccionEstadisticaPendiente";
	}


	@RequestMapping(value = "/OrdenProduccionList/filtrarOrdenProduccion", method = RequestMethod.POST)
	public @ResponseBody DataSourceResult readOrdenProduccion(@RequestBody DataSourceRequest request) {
		return ordenProduccionService.getListaOrdenProduccionSinProcesar(request);
	}

	@RequestMapping(value="/edit", method = RequestMethod.GET)
	public String edit(@RequestParam Long id, ModelMap model) {

		OrdenProduccion op = ordenProduccionService.getOrdenProduccionById(id);
		OrdenProduccionForm ordenProduccionForm = new OrdenProduccionForm();

		bindEntityToForm(op,ordenProduccionForm);
		////		estandarProduccionForm.setIdSucursal(ep.getSucursal().getIdSucursal());
		////		estandarProduccionForm.setActivo(ep.isActivo());
		////		List<Rol> rolesNoAsignados = rolService.getRoles(); 
		////		rolesNoAsignados.removeAll(user.getRoles());
		////		
		//solicitudProduccionForm.setFormato1(ep.getFormato1());
		//model.addAttribute("formatos1", Formato.getListFormatos1());
		//model.addAttribute("formatos1", Formato.values());
		model.put("ordenProduccionForm", ordenProduccionForm);
		getModelAtributtes(model);
		//		model.put("rolesNoAsignados", rolesNoAsignados);
		//		model.put("rolesAsignados", user.getRoles());
		return "ordenProduccionAlta";
	}

	private void bindEntityToForm(
			OrdenProduccion op,OrdenProduccionForm ordenProduccionForm) {

		ordenProduccionForm.setId(op.getId());
		ordenProduccionForm.setDescripcion(op.getDescripcion());
		ordenProduccionForm.setNombre(op.getNombre());
		ordenProduccionForm.setSolicitudProduccion(op.getSolicitudProduccion());

		ordenProduccionForm.setAdhesivoKilos(op.getAdhesivoKilos());
		ordenProduccionForm.setPigmentoKilos(op.getPigmentoKilos());
		ordenProduccionForm.setDiluyenteLitros(op.getDiluyenteLitros());
		ordenProduccionForm.setAditivoKilos(op.getAditivoKilos());
		ordenProduccionForm.setCajas(op.getEmpaque());
		ordenProduccionForm.setTinta1Litros(op.getTinta1Litros());
		ordenProduccionForm.setTinta2Litros(op.getTinta2Litros());
		ordenProduccionForm.setTinta3Litros(op.getTinta3Litros());
		if(op.getProcesada() != null && op.getProcesada() == true)
		{
			ordenProduccionForm.setProcesada(op.getProcesada());
			ordenProduccionForm.setFechaProcesada(op.getFechaProcesada());
		}

		ordenProduccionForm.setTiempoEstimado(getTiempoEstimadoToString(op.getTiempoEstimado()));
	}

	private String getTiempoEstimadoToString(Integer tiempoEstimado) {

		int minutos = tiempoEstimado; 
		int hours = minutos / 60; //since both are ints, you get an int
		int minutes = minutos % 60;

		String tiempo = String.format("%d:%02d", hours, minutes);

		return tiempo;
	}

	private void getModelAtributtes(ModelMap model) {

		//      model.addAttribute("formatos1", Formato.getListFormatos1());
		//		model.addAttribute("formatos2", Formato.getListFormatos2());
		//		model.addAttribute("colores", Color.getListColores());
		//		model.addAttribute("films", Film.getListFilms());
		//		model.addAttribute("cantidadColoresImpreso", new ArrayList<Integer>(Arrays.asList(1,2,3)));
		//		model.addAttribute("cajas", Caja.getTipoCajas());
		//		model.addAttribute("tintasAseleccionar",  materiaPrimaService.getMateriasPrimasByTipo(TipoMateriaPrima.TINTA));
		//		model.addAttribute("pigmentos", materiaPrimaService.getMateriasPrimasByTipo(TipoMateriaPrima.PIGMENTO));
		//		model.addAttribute("adhesivos", materiaPrimaService.getMateriasPrimasByTipo(TipoMateriaPrima.ADHESIVO));
		//		model.addAttribute("aditivos", materiaPrimaService.getMateriasPrimasByTipo(TipoMateriaPrima.ADITIVO));
		//		model.addAttribute("diluyentes", materiaPrimaService.getMateriasPrimasByTipo(TipoMateriaPrima.DILUYENTE));
		//		model.addAttribute("cantidadRollos", CantidadRollos.getListCantidadRollos());

	}

}
