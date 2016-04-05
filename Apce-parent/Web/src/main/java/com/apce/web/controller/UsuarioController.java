package com.apce.web.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

import com.apce.modelo.Rol;
import com.apce.modelo.Usuario;
import com.apce.modelo.kendo.DataSourceRequest;
import com.apce.modelo.kendo.DataSourceResult;
import com.apce.servicio.helper.RolHelper;
import com.apce.servicio.servicoInterfaz.RolService;
import com.apce.servicio.servicoInterfaz.SucursalService;
import com.apce.servicio.servicoInterfaz.UsuarioService;
import com.apce.web.form.UsuarioForm;

@Controller
@RequestMapping("/Usuario")
@SessionAttributes("usuarioForm")
public class UsuarioController {

	@Inject
	UsuarioService usuarioService;

	@Inject
	SucursalService sucursalService;
	
	@Inject
	RolService rolService;
	
	@Inject
	RolHelper rolHelper;
	
	Boolean[] comboActivo = {true,false};
	
	private String mensaje ="mensaje";
	
	private String[] ignoreProperties = {"roles"};    

	@ModelAttribute("usuarioForm")
	public UsuarioForm createUsuarioForm() {
		
		UsuarioForm usuarioForm = new UsuarioForm();
		
		return usuarioForm;
	}
	
	@RequestMapping(value="/UsuarioAlta", method = RequestMethod.GET)
	public String showUsuarioAlta(ModelMap model) {
		
		model.put("usuarioForm", new UsuarioForm());
		getModel(model);

		return "usuarioAlta";
	}

	
	
	@RequestMapping(value="/edit", method = RequestMethod.GET)
	public String edit(@RequestParam Integer idUsuario, ModelMap model) {

		Usuario user = usuarioService.getUsuario(idUsuario);
		UsuarioForm usuarioForm = new UsuarioForm();
		
		BeanUtils.copyProperties(user, usuarioForm, ignoreProperties);
		usuarioForm.setIdSucursal(user.getSucursal().getIdSucursal());
		usuarioForm.setActivo(user.isActivo());
		List<Rol> rolesNoAsignados = rolService.getRoles(); 
		rolesNoAsignados.removeAll(user.getRoles());
		
		model.put("usuarioForm", usuarioForm);
		model.put("sucursales", sucursalService.getSucursales());
		model.put("comboActivo", comboActivo );
		model.put("rolesNoAsignados", rolesNoAsignados);
		model.put("rolesAsignados", user.getRoles());

		return "usuarioAlta";
	}
	
	@RequestMapping(value = "/destroy", method = RequestMethod.POST)
	public @ResponseBody Usuario destroy(@RequestBody Map<String, Object> model) {

		Usuario user = usuarioService.getUsuario((Integer)model.get("idUsuario"));
		usuarioService.bajaUsuario(user);

		return user;
	}    
	
	@RequestMapping(value="/UsuarioList", method = RequestMethod.GET)
	public String list(ModelMap model) {

		return "usuarioList";
	}
	
	@RequestMapping(value = "/UsuarioList/filtrar", method = RequestMethod.POST)
	public @ResponseBody DataSourceResult read(@RequestBody DataSourceRequest request) {
		return usuarioService.getLista(request);
	}

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
//			// Success response handling6
//			// store a success message for rendering on the next request after redirect
//			// redirect back to the form to render the success message along with newly bound values
//			//redirectAttrs.addFlashAttribute("message", message);
//		}
//		//return "sucursalAlta";
//		return "redirect:/Usuario/UsuarioAlta";
//	}
	
	@RequestMapping(value="/UsuarioAlta/saveOrupdate",method=RequestMethod.POST)
	public String saveOrUpdate(@Valid UsuarioForm usuarioForm, BindingResult result, 
			Model model, RedirectAttributes redirectAttrs, SessionStatus sessionStatus) {

		if (!result.hasErrors()) 
		{
			mensaje = "Usuario guardado EXITOSAMENTE.";
			// Typically you would save to a db and clear the "form" attribute from the session 
			// via essionStatus.setCompleted(). For the demo we leave it in the session.
			Usuario usu = new Usuario();
			BeanUtils.copyProperties(usuarioForm, usu, ignoreProperties);
			usu.setSucursal(sucursalService.getSucursalById(usuarioForm.getIdSucursal()));
			usu.setRoles(rolHelper.getRoles(usuarioForm.getRoles()));
			
			usuarioService.saveOrUpdate(usu);
			sessionStatus.setComplete();
			

			// Success response handling
			// store a success message for rendering on the next request after redirect
			// redirect back to the form to render the success message along with newly bound values
			redirectAttrs.addFlashAttribute("message", mensaje);
			return "redirect:/Usuario/edit?idUsuario=" + usu.getIdUsuario();
		}
		return "usuarioAlta";
		//return "redirect:/Usuario/UsuarioAlta";
	}
	
	private void getModel(ModelMap model) {
		model.put("sucursales", sucursalService.getSucursales());
		model.put("comboActivo", comboActivo );
		model.put("rolesNoAsignados", rolService.getRoles());
	}
}
