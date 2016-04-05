package com.apce.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/Prueba")
public class PruebaController {


	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String probando(ModelMap model) {


		return "prueba";
	}
//	
//	@RequestMapping(value="/edit", method = RequestMethod.GET)
//	public String edit(@RequestParam Integer idUsuario, ModelMap model) {
//
//
//		return "usuarioAlta";
//	}
//	
//	@RequestMapping(value = "/destroy", method = RequestMethod.POST)
//	public @ResponseBody Usuario destroy(@RequestBody Map<String, Object> model) {
//
//
//		return user;
//	}    
//	
//	@RequestMapping(value="/UsuarioList", method = RequestMethod.GET)
//	public String list(ModelMap model) {
//
//		return "usuarioList";
//	}
//	
//	@RequestMapping(value = "/UsuarioList/filtrar", method = RequestMethod.POST)
//	public @ResponseBody DataSourceResult read(@RequestBody DataSourceRequest request) {
//		return usuarioService.getLista(request);
//	}

//	@RequestMapping(value="/UsuarioAlta/add",method=RequestMethod.POST)
//	public String add(@Valid UsuarioForm usuarioForm, BindingResult result, 
//			Model model, RedirectAttributes redirectAttrs) {
//
//		if (!result.hasErrors()) 
//		{
//			mensaje = "Usuario guardado EXITOSAMENTE.";
//
//			// Typically you would save to a db and clear the "form" attribute from the session 
//			// via essionStatus.setCompleted(). For the demo we leave it in the session.
//			Usuario usu = new Usuario();
//			BeanUtils.copyProperties(usuarioForm, usu);
//			usu.setSucursal(sucursalService.getSucursal(usuarioForm.getIdSucursal()));
//			usuarioService.altaUsuario(usu);
//
//			// Success response handling
//			// store a success message for rendering on the next request after redirect
//			// redirect back to the form to render the success message along with newly bound values
//			//redirectAttrs.addFlashAttribute("message", message);
//		}
//		//return "sucursalAlta";
//		return "redirect:/Usuario/UsuarioAlta";
//	}
	
//	@RequestMapping(value="/UsuarioAlta/saveOrupdate",method=RequestMethod.POST)
//	public String saveOrUpdate(@Valid UsuarioForm usuarioForm, BindingResult result, 
//			Model model, RedirectAttributes redirectAttrs) {
//
//		if (!result.hasErrors()) 
//		{
//			mensaje = "Usuario guardado EXITOSAMENTE.";
//
//			// Typically you would save to a db and clear the "form" attribute from the session 
//			// via essionStatus.setCompleted(). For the demo we leave it in the session.
//			Usuario usu = new Usuario();
//			BeanUtils.copyProperties(usuarioForm, usu);
//			usu.setSucursal(sucursalService.getSucursal(usuarioForm.getIdSucursal()));
//			usuarioService.altaOrModificacion(usu);
//
//			// Success response handling
//			// store a success message for rendering on the next request after redirect
//			// redirect back to the form to render the success message along with newly bound values
//			redirectAttrs.addFlashAttribute("message", mensaje);
//		}
//		//return "sucursalAlta";
//		return "redirect:/Usuario/UsuarioAlta";
//	}
}
