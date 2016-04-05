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
import com.apce.modelo.Film;
import com.apce.modelo.Formato;
import com.apce.modelo.SolicitudProduccion;
import com.apce.modelo.TipoMateriaPrima;
import com.apce.modelo.kendo.DataSourceRequest;
import com.apce.modelo.kendo.DataSourceResult;
import com.apce.servicio.servicoInterfaz.EstandarProduccionService;
import com.apce.servicio.servicoInterfaz.MateriaPrimaService;
import com.apce.servicio.servicoInterfaz.OrdenProduccionService;
import com.apce.servicio.servicoInterfaz.ProduccionService;
import com.apce.servicio.servicoInterfaz.SolicitudProduccionService;
import com.apce.web.form.SolicitudProduccionForm;

@Controller
@RequestMapping("/SolicitudProduccion")
@SessionAttributes("solicitudProduccionForm") 
public class SolicitudProduccionController {
	

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

	@ModelAttribute("solicitudProduccionForm")
	public SolicitudProduccionForm createSolicitudProduccionForm() {
		return new SolicitudProduccionForm();
	}
	
	private String mensaje ="mensaje";
	
	@RequestMapping(value="/SolicitudProduccionAlta", method = RequestMethod.GET)
	public String showSolicitudProduccion(ModelMap model, SessionStatus status) {

		getModelAtributtes(model);
		model.put("solicitudProduccionForm", new SolicitudProduccionForm());
		
		return "solicitudProduccionAlta";
	}

	@RequestMapping(value="/SolicitudProduccionAlta/saveOrUpdate",method=RequestMethod.POST)
	public String saveOrUpdate(@Valid SolicitudProduccionForm solicitudProduccionForm, BindingResult result, 
			ModelMap model, RedirectAttributes redirectAttrs, SessionStatus status) {

		getModelAtributtes(model);
		
		if (!result.hasErrors()) 
		{
			SolicitudProduccion sp = new SolicitudProduccion();
			
			bindFormToEntity(solicitudProduccionForm, sp);

			//sp.setUsuarioAlta(usuarioAlta)
			
			sp.setFechaAlta(new Date());
			
			solicitudProduccionService.saveOrUpdate(sp);
		//	status.setComplete();

			// Success response handling
			// store a success message for rendering on the next request after redirect
			// redirect back to the form to render the success message along with newly bound values
			mensaje = "Solicitud Produccion ID: " + sp.getId() + " guardada EXITOSAMENTE.";
			redirectAttrs.addFlashAttribute("message", mensaje);
			//redirectAttrs.addFlashAttribute("tiposMateriaPrima", materiaPrimaService.getTiposMateriaPrima());
			return "redirect:/SolicitudProduccion/edit?id=" + sp.getId();
		}

		return "solicitudProduccionAlta";
		
	}

	private void bindFormToEntity(
			SolicitudProduccionForm solicitudProduccionForm,
			SolicitudProduccion sp) {
		
		sp.setId(solicitudProduccionForm.getId());
		sp.setNombre(solicitudProduccionForm.getNombre());
		sp.setDescripcion(solicitudProduccionForm.getDescripcion());
		sp.setFilm(solicitudProduccionForm.getFilm());
		sp.setFondo(solicitudProduccionForm.getFondo());
		sp.setFormato1(solicitudProduccionForm.getFormato1());
		sp.setFormato2(solicitudProduccionForm.getFormato2());
		sp.setImpreso(solicitudProduccionForm.getImpreso());
		sp.setCaja(solicitudProduccionForm.getCaja());
		sp.setCantidadRollos( ((CantidadRollos)CantidadRollos.getRolloByName(solicitudProduccionForm.getCantidadRollosName())).getNumero() );
		

		sp.setColor1(solicitudProduccionForm.getColor1());
		sp.setColor2(solicitudProduccionForm.getColor2());
		sp.setColor3(solicitudProduccionForm.getColor3());
		sp.setTinta1(materiaPrimaService.getMateriaPrimaById(solicitudProduccionForm.getIdTinta1()));
		sp.setTinta2(materiaPrimaService.getMateriaPrimaById(solicitudProduccionForm.getIdTinta2()));
		sp.setTinta3(materiaPrimaService.getMateriaPrimaById(solicitudProduccionForm.getIdTinta3()));

		sp.setAdhesivo(materiaPrimaService.getMateriaPrimaById(solicitudProduccionForm.getIdAdhesivo()));
		sp.setAditivo(materiaPrimaService.getMateriaPrimaById(solicitudProduccionForm.getIdAditivo()));
		sp.setDiluyente(materiaPrimaService.getMateriaPrimaById(solicitudProduccionForm.getIdDiluyente()));
		sp.setPigmento(materiaPrimaService.getMateriaPrimaById(solicitudProduccionForm.getIdPigmento()));
	}
	
	private void bindEntityToForm(
			SolicitudProduccionForm solicitudProduccionForm,
			SolicitudProduccion sp) {
		
		solicitudProduccionForm.setId(sp.getId());
		solicitudProduccionForm.setNombre(sp.getNombre());
		solicitudProduccionForm.setFilm(sp.getFilm());
		solicitudProduccionForm.setFondo(sp.getFondo());
		solicitudProduccionForm.setFormato1(sp.getFormato1());
		solicitudProduccionForm.setFormato2(sp.getFormato2());
		solicitudProduccionForm.setImpreso(sp.getImpreso());
		solicitudProduccionForm.setCaja(sp.getCaja());

		solicitudProduccionForm.setColor1(sp.getColor1());
		solicitudProduccionForm.setColor2(sp.getColor2());
		solicitudProduccionForm.setColor3(sp.getColor3());
		if(sp.getTinta1()!= null)
			solicitudProduccionForm.setIdTinta1(sp.getTinta1().getId());
		if(sp.getTinta2()!= null)
			solicitudProduccionForm.setIdTinta2(sp.getTinta2().getId());
		if(sp.getTinta3()!= null)
			solicitudProduccionForm.setIdTinta3(sp.getTinta3().getId());

		solicitudProduccionForm.setIdAdhesivo(sp.getAdhesivo().getId());
		solicitudProduccionForm.setIdAditivo(sp.getAditivo().getId());
		solicitudProduccionForm.setIdDiluyente(sp.getDiluyente().getId());
		solicitudProduccionForm.setIdPigmento(sp.getPigmento().getId());
		
		solicitudProduccionForm.setCantidadRollosName( ((CantidadRollos)CantidadRollos.getRolloByNumero(sp.getCantidadRollos())).name() );
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
	
	@RequestMapping(value="/SolicitudProduccionList", method = RequestMethod.GET)
	public String showSolicitudProduccionList(ModelMap model) {

		return "solicitudProduccionList";
	}

	@RequestMapping(value = "/SolicitudProduccionList/filtrarSolicitudProduccion", method = RequestMethod.POST)
	public @ResponseBody DataSourceResult readProduccion(@RequestBody DataSourceRequest request) {
		return solicitudProduccionService.getListaSolicitudProduccion(request);
	}
	
	@RequestMapping(value="/edit", method = RequestMethod.GET)
	public String edit(@RequestParam Long id, ModelMap model) {

		SolicitudProduccion sp = solicitudProduccionService.getSolicitudProduccionById(id);
		SolicitudProduccionForm solicitudProduccionForm = new SolicitudProduccionForm();
		
			bindEntityToForm(solicitudProduccionForm, sp);
////		estandarProduccionForm.setIdSucursal(ep.getSucursal().getIdSucursal());
////		estandarProduccionForm.setActivo(ep.isActivo());
////		List<Rol> rolesNoAsignados = rolService.getRoles(); 
////		rolesNoAsignados.removeAll(user.getRoles());
////		
		//solicitudProduccionForm.setFormato1(ep.getFormato1());
		//model.addAttribute("formatos1", Formato.getListFormatos1());
		//model.addAttribute("formatos1", Formato.values());
		model.put("solicitudProduccionForm", solicitudProduccionForm);
		getModelAtributtes(model);
//		model.put("rolesNoAsignados", rolesNoAsignados);
//		model.put("rolesAsignados", user.getRoles());
		return "solicitudProduccionAlta";
	}
}
