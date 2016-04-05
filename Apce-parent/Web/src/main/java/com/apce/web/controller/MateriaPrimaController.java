package com.apce.web.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
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

import com.apce.modelo.Color;
import com.apce.modelo.MateriaPrima;
import com.apce.modelo.TipoMateriaPrima;
import com.apce.modelo.kendo.DataSourceRequest;
import com.apce.modelo.kendo.DataSourceResult;
import com.apce.servicio.servicoInterfaz.MateriaPrimaService;
import com.apce.web.form.MateriaPrimaForm;
import com.apce.web.helper.MateriaPrimaHelper;

@Controller
@RequestMapping("/MateriaPrima")
@SessionAttributes({"materiaPrimaForm", "tipoMateriaPrimaForm"} ) 
public class MateriaPrimaController {
	
//	private String[] ignoreProperties = {"tipoMateriaPrima"};    

	@Inject
	MateriaPrimaService materiaPrimaService;
	
	@Inject
	MateriaPrimaHelper materiaPrimaHelper;

	@ModelAttribute("materiaPrimaForm")
	public MateriaPrimaForm createMateriaPrimaForm() {
		return new MateriaPrimaForm();
	}
	
//	@ModelAttribute("tipoMateriaPrimaForm")
//	public TipoMateriaPrimaForm createTipoMateriaPrimaForm() {
//		return new TipoMateriaPrimaForm();
//	}

	private String mensaje ="mensaje";
	
	@RequestMapping(value="/MateriaPrimaAlta", method = RequestMethod.GET)
	public String showAlta(ModelMap model, SessionStatus status) {

		getModel(model);
		model.put("materiaPrimaForm", new MateriaPrimaForm());
		
		return "materiaPrimaAlta";
	}

	@RequestMapping(value="/MateriaPrimaAlta/addMateriaPrima",method=RequestMethod.POST)
	public String saveOrUpdate(@Valid MateriaPrimaForm materiaPrimaForm, BindingResult result, 
			ModelMap model, RedirectAttributes redirectAttrs, SessionStatus status) {
		
		getModel(model);
		
		if (!result.hasErrors()) 
		{
			mensaje = "Materia Prima: " + materiaPrimaForm.getCodigoMateriaPrima() + " guardada EXITOSAMENTE.";
			
			// Typically you would save to a db and clear the "form" attribute from the session 
			// via SessionStatus.setCompleted(). For the demo we leave it in the session.
			MateriaPrima mp = new MateriaPrima();
			BeanUtils.copyProperties(materiaPrimaForm, mp);
			materiaPrimaService.saveOrUpdate(mp);
			status.setComplete();
			
			// Success response handling
			// store a success message for rendering on the next request after redirect
			// redirect back to the form to render the success message along with newly bound values
			redirectAttrs.addFlashAttribute("message", mensaje);
			
			return "redirect:/MateriaPrima/edit?id=" + mp.getId();
			//return "redirect:/MateriaPrima/MateriaPrimaAlta";
		}
		
		return "materiaPrimaAlta";
	}
	
//	@RequestMapping(value="/MateriaPrimaAlta/addTipoMateriaPrima",method=RequestMethod.POST)
//	public String addTipoMateriaPrima(@Valid TipoMateriaPrimaForm tipoMateriaPrimaForm, BindingResult result, 
//			Model model, RedirectAttributes redirectAttrs) {
//
//		if (!result.hasErrors()) 
//		{
//			mensaje = "Tipo Materia Prima: " + tipoMateriaPrimaForm.getNombre() + " guardado EXITOSAMENTE.";
//			
//			// Typically you would save to a db and clear the "form" attribute from the session 
//			// via SessionStatus.setCompleted(). For the demo we leave it in the session.
//			//TipoMateriaPrima tmp = new TipoMateriaPrima();
////			BeanUtils.copyProperties(tipoMateriaPrimaForm, tmp);
////			materiaPrimaService.altaTipoMateriaPrima(tmp);
//			
//			// Success response handling
//			// store a success message for rendering on the next request after redirect
//			// redirect back to the form to render the success message along with newly bound values
//			//redirectAttrs.addFlashAttribute("message", message);
//		}
//		return "tipoMateriaPrimaAlta";
//	}

	@RequestMapping(value="/edit", method = RequestMethod.GET)
	public String editMateriaPrima(@RequestParam Long id, ModelMap model) {

		MateriaPrima mp = materiaPrimaService.getMateriaPrimaById(id);
		MateriaPrimaForm materiaPrimaForm = new MateriaPrimaForm();
		
		BeanUtils.copyProperties(mp, materiaPrimaForm);
////		estandarProduccionForm.setIdSucursal(ep.getSucursal().getIdSucursal());
////		estandarProduccionForm.setActivo(ep.isActivo());
////		List<Rol> rolesNoAsignados = rolService.getRoles(); 
////		rolesNoAsignados.removeAll(user.getRoles());
////		
		//model.addAttribute("formatos1", Formato.getListFormatos1());
		//model.addAttribute("formatos1", Formato.values());
		getModel(model);
		model.put("materiaPrimaForm", materiaPrimaForm);
//		model.put("rolesNoAsignados", rolesNoAsignados);
//		model.put("rolesAsignados", user.getRoles());
		return "materiaPrimaAlta";
	}


	
	
//	@RequestMapping(value="/TipoMateriaPrimaAlta", method = RequestMethod.GET)
//	public String showTipoMateriaPrima(ModelMap model) {
//		
//
//		return "tipoMateriaPrimaAlta";
//	}

	@RequestMapping(value="/MateriaPrimaList", method = RequestMethod.GET)
	public String getListMateriaPrima(ModelMap model) {

		return "materiaPrimaList";
	}

	@RequestMapping(value = "/MateriaPrimaList/filtrarMateriaPrima", method = RequestMethod.POST)
	public @ResponseBody DataSourceResult readMateriaPrima(@RequestBody DataSourceRequest request) {
		return materiaPrimaService.getListaMateriaPrima(request);
	}

//	@RequestMapping(value="/TipoMateriaPrimaList", method = RequestMethod.GET)
//	public String getListTipoMateriaPrima(ModelMap model) {
//
//		return "tipoMateriaPrimaList";
//	}
//
//	@RequestMapping(value = "/TipoMateriaPrimaList/filtrarTipoMateriaPrima", method = RequestMethod.POST)
//	public @ResponseBody DataSourceResult readTipoMateriaPrima(@RequestBody DataSourceRequest request) {
//		return materiaPrimaService.getListaTipoMateriaPrima(request);
//	}
	
	private void getModel(ModelMap model) {
		model.addAttribute("tiposMateriaPrima", TipoMateriaPrima.getListTiposMateriaPrima());
		model.addAttribute("colores", Color.getListColores());
	}
}
