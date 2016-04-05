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

import com.apce.modelo.Sucursal;
import com.apce.modelo.kendo.DataSourceRequest;
import com.apce.modelo.kendo.DataSourceResult;
import com.apce.servicio.servicoInterfaz.SucursalService;
import com.apce.servicio.servicoInterfaz.UsuarioService;
import com.apce.web.form.SucursalForm;
import com.apce.web.form.UsuarioForm;

@Controller
@RequestMapping("/Sucursal")
@SessionAttributes("sucursalForm")
public class SucursalController {

	@Inject
	SucursalService sucursalService;
	
	@Inject
	UsuarioService usuarioService;

	@ModelAttribute("sucursalForm")
	public SucursalForm createSucursalForm() {
		return new SucursalForm();
	}
	
	@RequestMapping(value="/SucursalAlta", method = RequestMethod.GET)
	public String showAlta(ModelMap model) {

		model.put("sucursalForm", new SucursalForm());
		getModel(model);
		return "sucursalAlta";
	}
	
	private String mensaje ="mensaje";
	
	@RequestMapping(value="/SucursalAlta/saveOrupdate",method=RequestMethod.POST)
	public String saveOrUpdate(@Valid SucursalForm sucursalForm, BindingResult result, 
			ModelMap model, RedirectAttributes redirectAttrs, SessionStatus sessionStatus) {
		
		getModel(model);
		
		if (!result.hasErrors()) 
		{
			mensaje = "Sucursal: " + sucursalForm.getCiudad() + " guardada EXITOSAMENTE.";
			// Typically you would save to a db and clear the "form" attribute from the session 
						// via essionStatus.setCompleted(). For the demo we leave it in the session.
						Sucursal suc = new Sucursal();
						BeanUtils.copyProperties(sucursalForm, suc);
						suc.setGerenteGeneral(usuarioService.getUsuario(sucursalForm.getIdUsuario()));
						sucursalService.altaSucursal(suc);
			
			// Success response handling
			// store a success message for rendering on the next request after redirect
			// redirect back to the form to render the success message along with newly bound values
			redirectAttrs.addFlashAttribute("message", mensaje);
			
			return "redirect:/Sucursal/SucursalAlta";
			//return "redirect:/MateriaPrima/MateriaPrimaAlta";
		}
		
		return "sucursalAlta";
	}

	
	@RequestMapping(value="/edit", method = RequestMethod.GET)
	public String edit(@RequestParam Integer idSucursal, ModelMap model) {

		Sucursal sucursal = sucursalService.getSucursalById(idSucursal);
		SucursalForm sucursalForm = new SucursalForm();
		
		///BeanUtils.copyProperties(user, usuarioForm, ignoreProperties);
		BeanUtils.copyProperties(sucursal, sucursalForm);
		model.put("sucursalForm", sucursalForm);
		
		getModel(model);

		return "sucursalAlta";
	}

	private void getModel(ModelMap model) {
		model.put("gerentes", usuarioService.getUsuariosGerentes());
	}

	
	

	@RequestMapping(value="/SucursalList", method = RequestMethod.GET)
	public String showList(ModelMap model) {

		return "sucursalList";
	}

	@RequestMapping(value = "/SucursalList/filtrar", method = RequestMethod.POST)
	public @ResponseBody DataSourceResult read(@RequestBody DataSourceRequest request) {
		DataSourceResult d = sucursalService.getLista(request);
		return d;
	}





}
