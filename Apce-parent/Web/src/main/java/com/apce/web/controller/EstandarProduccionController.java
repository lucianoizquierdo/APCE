package com.apce.web.controller;


import java.util.ArrayList;
import java.util.Arrays;
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

import com.apce.modelo.Caja;
import com.apce.modelo.CantidadRollos;
import com.apce.modelo.Color;
import com.apce.modelo.EstandarProduccion;
import com.apce.modelo.Film;
import com.apce.modelo.Formato;
import com.apce.modelo.TipoMateriaPrima;
import com.apce.modelo.kendo.DataSourceRequest;
import com.apce.modelo.kendo.DataSourceResult;
import com.apce.servicio.servicoInterfaz.EstandarProduccionService;
import com.apce.servicio.servicoInterfaz.MateriaPrimaService;
import com.apce.servicio.servicoInterfaz.OrdenProduccionService;
import com.apce.servicio.servicoInterfaz.ProduccionService;
import com.apce.web.form.EstandarProduccionForm;

@Controller
@RequestMapping("/EstandarProduccion")
@SessionAttributes("estandarProduccionForm") 
public class EstandarProduccionController {
	

	@Inject
	MateriaPrimaService materiaPrimaService;

	@Inject
	ProduccionService produccionService;
	
	@Inject
	EstandarProduccionService estandarProduccionService;
	
	@Inject
	OrdenProduccionService ordenProduccionService;

	@ModelAttribute("estandarProduccionForm")
	public EstandarProduccionForm createEstandarProduccionForm() {
		return new EstandarProduccionForm();
	}
	
	private String mensaje ="mensaje";
	
	@RequestMapping(value="/EstandarProduccionAlta", method = RequestMethod.GET)
	public String showEstandarProduccion(ModelMap model, SessionStatus status) {

		getModelAtributtes(model);
		//status.setComplete();
		
		return "estandarProduccionAlta";
	}

	@RequestMapping(value="/EstandarProduccionAlta/saveOrUpdate",method=RequestMethod.POST)
	public String saveOrUpdate(@Valid EstandarProduccionForm estandarProduccionForm, BindingResult result, 
			ModelMap model, RedirectAttributes redirectAttrs, SessionStatus status) {

		getModelAtributtes(model);
		
		if (!result.hasErrors()) 
		{
			EstandarProduccion ep = new EstandarProduccion();
			
			bindFormToEntity(estandarProduccionForm, ep);

			//sp.setUsuarioAlta(usuarioAlta)
			ep.setFechaAlta(new Date());
			
			estandarProduccionService.saveOrUpdate(ep);
		//	status.setComplete();

			// Success response handling
			// store a success message for rendering on the next request after redirect
			// redirect back to the form to render the success message along with newly bound values
			mensaje = "Estandar Produccion ID: " + ep.getId() + " guardada EXITOSAMENTE.";
			redirectAttrs.addFlashAttribute("message", mensaje);
			//redirectAttrs.addFlashAttribute("tiposMateriaPrima", materiaPrimaService.getTiposMateriaPrima());
			return "redirect:/EstandarProduccion/EstandarProduccionAlta";
		}

		return "estandarProduccionAlta";
		
	}

	private void bindFormToEntity(
			EstandarProduccionForm estandarProduccionForm,
			EstandarProduccion ep) {
		
		ep.setId(estandarProduccionForm.getId());
		ep.setFilm(estandarProduccionForm.getFilm());
		ep.setFondo(estandarProduccionForm.getFondo());
		ep.setFormato1(estandarProduccionForm.getFormato1());
		ep.setFormato2(estandarProduccionForm.getFormato2());
		ep.setImpreso(estandarProduccionForm.getImpreso());
		
		ep.setAdhesivoKilos(estandarProduccionForm.getAdhesivoKilos());
		ep.setAditivoKilos(estandarProduccionForm.getAditivoKilos());
		ep.setDiluyenteLitros(estandarProduccionForm.getDiluyenteLitros());
		ep.setPigmentoKilos(estandarProduccionForm.getPigmentoKilos());
		ep.setTintaLitros(estandarProduccionForm.getTintaLitros());
		ep.setTiempoEstimado(estandarProduccionForm.getTiempoEstimado());
	}
	
	private void bindEntityToForm(
			EstandarProduccionForm estandarProduccionForm,
			EstandarProduccion ep) {
		
		estandarProduccionForm.setId(ep.getId());
		estandarProduccionForm.setFilm(ep.getFilm());
		estandarProduccionForm.setFondo(ep.getFondo());
		estandarProduccionForm.setFormato1(ep.getFormato1());
		estandarProduccionForm.setFormato2(ep.getFormato2());
		estandarProduccionForm.setImpreso(ep.getImpreso());
		
		estandarProduccionForm.setAdhesivoKilos(ep.getAdhesivoKilos());
		estandarProduccionForm.setAditivoKilos(ep.getAditivoKilos());
		estandarProduccionForm.setDiluyenteLitros(ep.getDiluyenteLitros());
		estandarProduccionForm.setPigmentoKilos(ep.getPigmentoKilos());
		estandarProduccionForm.setTintaLitros(ep.getTintaLitros());
		estandarProduccionForm.setTiempoEstimado(ep.getTiempoEstimado());
	}



	

	private void getModelAtributtes(ModelMap model) {
		
        model.addAttribute("formatos1", Formato.getListFormatos1());
		model.addAttribute("formatos2", Formato.getListFormatos2());
		model.addAttribute("colores", Color.getListColores());
		model.addAttribute("films", Film.getListFilms());
		model.addAttribute("cantidadColoresImpreso", new ArrayList<Integer>(Arrays.asList(1,2,3)));
		model.addAttribute("cajas", Caja.getTipoCajas());
		model.addAttribute("tintasAseleccionar",  materiaPrimaService.getMateriasPrimasByTipo(TipoMateriaPrima.TINTA));
		model.addAttribute("pigmentos", materiaPrimaService.getMateriasPrimasByTipo(TipoMateriaPrima.PIGMENTO));
		model.addAttribute("adhesivos", materiaPrimaService.getMateriasPrimasByTipo(TipoMateriaPrima.ADHESIVO));
		model.addAttribute("aditivos", materiaPrimaService.getMateriasPrimasByTipo(TipoMateriaPrima.ADITIVO));
		model.addAttribute("diluyentes", materiaPrimaService.getMateriasPrimasByTipo(TipoMateriaPrima.DILUYENTE));
		model.addAttribute("cantidadRollos", CantidadRollos.getListCantidadRollos());
		
	}
	
	@RequestMapping(value="/EstandarProduccionList", method = RequestMethod.GET)
	public String showEstandarProduccionList(ModelMap model) {

		return "estandarProduccionList";
	}

	@RequestMapping(value = "/EstandarProduccionList/filtrarEstandarProduccion", method = RequestMethod.POST)
	public @ResponseBody DataSourceResult readProduccion(@RequestBody DataSourceRequest request) {
		return estandarProduccionService.getListaEstandarProduccion(request);
	}
	
	@RequestMapping(value="/edit", method = RequestMethod.GET)
	public String edit(@RequestParam Long id, ModelMap model) {

		EstandarProduccion sp = estandarProduccionService.getEstandarProduccionById(id);
		EstandarProduccionForm estandarProduccionForm = new EstandarProduccionForm();
		
			bindEntityToForm(estandarProduccionForm, sp);
////		estandarProduccionForm.setIdSucursal(ep.getSucursal().getIdSucursal());
////		estandarProduccionForm.setActivo(ep.isActivo());
////		List<Rol> rolesNoAsignados = rolService.getRoles(); 
////		rolesNoAsignados.removeAll(user.getRoles());
////		
		//estandarProduccionForm.setFormato1(ep.getFormato1());
		//model.addAttribute("formatos1", Formato.getListFormatos1());
		//model.addAttribute("formatos1", Formato.values());
		model.put("estandarProduccionForm", estandarProduccionForm);
		getModelAtributtes(model);
//		model.put("rolesNoAsignados", rolesNoAsignados);
//		model.put("rolesAsignados", user.getRoles());
		return "estandarProduccionAlta";
	}
}
