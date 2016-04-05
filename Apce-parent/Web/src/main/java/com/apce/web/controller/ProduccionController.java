//package com.apce.web.controller;
//
//
//import java.util.ArrayList;
//import java.util.Arrays;
//
//import javax.inject.Inject;
//import javax.validation.Valid;
//
//import org.apache.commons.beanutils.BeanUtils;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import com.apce.modelo.Color;
//import com.apce.modelo.Film;
//import com.apce.modelo.Formato;
//import com.apce.modelo.Produccion;
//import com.apce.modelo.TipoMateriaPrima;
//import com.apce.modelo.kendo.DataSourceRequest;
//import com.apce.modelo.kendo.DataSourceResult;
//import com.apce.servicio.servicoInterfaz.MateriaPrimaService;
//import com.apce.servicio.servicoInterfaz.ProduccionService;
//import com.apce.web.form.EstandarProduccionForm;
//
//@Controller
//@RequestMapping("/Produccion")
//@SessionAttributes("produccionForm") 
//public class ProduccionController {
//	
//
//	@Inject
//	MateriaPrimaService materiaPrimaService;
//
//	@Inject
//	ProduccionService produccionService;
//
//	@ModelAttribute("produccionForm")
//	public EstandarProduccionForm createProduccionForm() {
//		return new EstandarProduccionForm();
//	}
//	
//	private String mensaje ="mensaje";
//
//	@RequestMapping(value="/ProduccionAlta/addProduccion",method=RequestMethod.POST)
//	public String addProduccion(@Valid EstandarProduccionForm produccionForm, BindingResult result, 
//			ModelMap model, RedirectAttributes redirectAttrs) {
//
//		getModelAtributtes(model);
//		
//		if (!result.hasErrors()) 
//		{
//			mensaje = "Produccion ID: " + produccionForm.getId() + " guardada EXITOSAMENTE.";
//
//			// Typically you would save to a db and clear the "form" attribute from the session 
//			//via SessionStatus.setCompleted(). For the demo we leave it in the session.
//			Produccion p = new Produccion();
//			BeanUtils.copyProperties(produccionForm, p);
//			produccionService. altaMateriaPrima(mp);
//
//
//			// Success response handling
//			// store a success message for rendering on the next request after redirect
//			// redirect back to the form to render the success message along with newly bound values
//			redirectAttrs.addFlashAttribute("message", mensaje);
//			redirectAttrs.addFlashAttribute("tiposMateriaPrima", materiaPrimaService.getTiposMateriaPrima());
//			return "redirect:/MateriaPrima/MateriaPrimaAlta";
//		}
//
//		return "materiaPrimaAlta";
//	}
//
//
//
//	@RequestMapping(value="/ProduccionAlta", method = RequestMethod.GET)
//	public String showProduccion(ModelMap model) {
//
//		getModelAtributtes(model);
//		
//		
//		
////		List<TipoMateriaPrima> formatos3 = new ArrayList<TipoMateriaPrima>();
////		TipoMateriaPrima t = new TipoMateriaPrima();
////		t.setId(1L);
////		t.setNombre("aa");
////		formatos3.add(t);
////		model.addAttribute("tiposMateriaPrima",formatos3);
//		
//		
//		return "produccionAlta";
//	}
//
//
//
//	private void getModelAtributtes(ModelMap model) {
//		model.addAttribute("formatos1", Formato.getListFormatos1());
//		model.addAttribute("formatos2", Formato.getListFormatos2());
//		model.addAttribute("colores", Color.getListColores());
//		model.addAttribute("films", Film.getListFilms());
//		model.addAttribute("cantidadColoresImpreso", new ArrayList<Integer>(Arrays.asList(1,2,3)));
//	}
//	
//	@RequestMapping(value="/ProduccionList", method = RequestMethod.GET)
//	public String getList(ModelMap model) {
//
//		return "produccionList";
//	}
//
//	@RequestMapping(value = "/ProduccionList/filtrarProduccion", method = RequestMethod.POST)
//	public @ResponseBody DataSourceResult readProduccion(@RequestBody DataSourceRequest request) {
//		return produccionService.getListaProduccion(request);
//	}
//}
