package com.apce.web.controller;


import java.util.Date;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.apce.modelo.EstandarProduccion;
import com.apce.modelo.OrdenProduccion;
import com.apce.modelo.SolicitudProduccion;
import com.apce.modelo.kendo.DataSourceRequest;
import com.apce.modelo.kendo.DataSourceResult;
import com.apce.servicio.servicoInterfaz.EstandarProduccionService;
import com.apce.servicio.servicoInterfaz.MateriaPrimaService;
import com.apce.servicio.servicoInterfaz.OrdenProduccionService;
import com.apce.servicio.servicoInterfaz.ProduccionService;
import com.apce.servicio.servicoInterfaz.SolicitudProduccionService;
import com.apce.web.form.OrdenProduccionForm;

@Controller
@RequestMapping("/OrdenProduccion")
@SessionAttributes("ordenProduccionForm") 
public class OrdenProduccionController {
	

	@Inject
	MateriaPrimaService materiaPrimaService;

	@Inject
	ProduccionService produccionService;
	
	@Inject
	SolicitudProduccionService solicitudProduccionService;
	
	@Inject
	OrdenProduccionService ordenProduccionService;
	
	@Inject
	EstandarProduccionService estandarProduccionService;

	@ModelAttribute("ordenProduccionForm")
	public OrdenProduccionForm createOrdenProduccionForm() {
		return new OrdenProduccionForm();
	}
	
	private String mensaje ="mensaje";
	
	@RequestMapping(value="/OrdenProduccionAlta", method = RequestMethod.GET)
	public String showEstandarProduccion(ModelMap model, SessionStatus status) {

		getModelAtributtes(model);
		//status.setComplete();
		
		return "ordenProduccionAlta";
	}

	@RequestMapping(value="/OrdenProduccionAlta/saveOrUpdate",method=RequestMethod.POST)
	public String saveOrUpdate(@Valid OrdenProduccionForm OrdenProduccionForm, BindingResult result, 
			ModelMap model, RedirectAttributes redirectAttrs, SessionStatus status) {

		getModelAtributtes(model);
		
		if (!result.hasErrors()) 
		{
			OrdenProduccion op = new OrdenProduccion();
			
			bindFormToEntity(OrdenProduccionForm, op);
			
			ordenProduccionService.saveOrUpdate(op);
		//	status.setComplete();

			// Success response handling
			// store a success message for rendering on the next request after redirect
			// redirect back to the form to render the success message along with newly bound values
			mensaje = "Orden Produccion ID: " + op.getId() + " guardada EXITOSAMENTE.";
			redirectAttrs.addFlashAttribute("message", mensaje);
			//redirectAttrs.addFlashAttribute("tiposMateriaPrima", materiaPrimaService.getTiposMateriaPrima());
			return "redirect:/OrdenProduccion/OrdenProduccionAlta";
		}

		return "ordenProduccionAlta";
		
	}

	private void bindFormToEntity(
			OrdenProduccionForm ordenProduccionForm,
			OrdenProduccion op) {
		
		op.setId(ordenProduccionForm.getId());
		op.setDescripcion(ordenProduccionForm.getDescripcion());
		op.setNombre(ordenProduccionForm.getNombre());
		op.setSolicitudProduccion(ordenProduccionForm.getSolicitudProduccion());
		
		op.setAdhesivoKilos(ordenProduccionForm.getAdhesivoKilos());
		op.setPigmentoKilos(ordenProduccionForm.getPigmentoKilos());
		op.setDiluyenteLitros(ordenProduccionForm.getDiluyenteLitros());
		op.setAditivoKilos(ordenProduccionForm.getAditivoKilos());
		op.setEmpaque(ordenProduccionForm.getCajas());
		op.setTinta1Litros(ordenProduccionForm.getTinta1Litros());
		op.setTinta2Litros(ordenProduccionForm.getTinta2Litros());
		op.setTinta3Litros(ordenProduccionForm.getTinta3Litros());
		if(ordenProduccionForm.getProcesada() == true)
		{
			op.setProcesada(true);
			op.setFechaProcesada(new Date());
		}
		else
		{
			op.setProcesada(false);
		}
		
		op.setFechaAlta(new Date());
		op.setTiempoEstimado(getTiempoEstimadoToMinutes(ordenProduccionForm.getTiempoEstimado()));
	}
	
	private Integer getTiempoEstimadoToMinutes(String tiempoEstimado) {
		
		String[] s = tiempoEstimado.split(":");
		Integer minutos = ( ( Integer.valueOf( s[0]) ) * 60 ) + Integer.valueOf(s[1]) + ( Integer.valueOf(s[1]) / 60 ) ;
		
		return minutos;
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
		
//        model.addAttribute("formatos1", Formato.getListFormatos1());
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
	
	@RequestMapping(value="/OrdenProduccionList", method = RequestMethod.GET)
	public String showOrdenProduccionList(ModelMap model) {

		return "ordenProduccionList";
	}

	@RequestMapping(value = "/OrdenProduccionList/filtrarOrdenProduccion", method = RequestMethod.POST)
	public @ResponseBody DataSourceResult readOrdenProduccion(@RequestBody DataSourceRequest request) {
		return ordenProduccionService.getListaOrdenProduccion(request);
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
	
	
	@RequestMapping(value="/generarOrdenProduccion",method=RequestMethod.GET)
	public String generarOrdenProduccion(@RequestParam Long id,ModelMap model, RedirectAttributes redirectAttrs) {

		
		SolicitudProduccion sp = solicitudProduccionService.getSolicitudProduccionById(id);
		EstandarProduccion ep = estandarProduccionService.findEstandarProduccionByUnique(sp.getFormato1(),sp.getFormato2(),sp.getFondo(),sp.getFilm(),sp.getImpreso());
			
		if(ep == null)
		{
			mensaje ="No existe un Estandar de Produccion para la Solicitud de Produccion numero:" + sp.getId();
			redirectAttrs.addFlashAttribute("message", mensaje);
			//redirectAttrs.addFlashAttribute("tiposMateriaPrima", materiaPrimaService.getTiposMateriaPrima());
			return "redirect:/SolicitudProduccion/edit?id=" + sp.getId();
		}
			
		OrdenProduccion op = ordenProduccionService.generarOrdenProduccion(sp,ep);
		//ordenProduccionService.saveOrUpdate(op);
		OrdenProduccionForm ordenProduccionForm = new OrdenProduccionForm();
		bindEntityToForm(op, ordenProduccionForm );
		model.put("ordenProduccionForm", ordenProduccionForm);
		
		return "ordenProduccionAlta";
		
	}
	

}
