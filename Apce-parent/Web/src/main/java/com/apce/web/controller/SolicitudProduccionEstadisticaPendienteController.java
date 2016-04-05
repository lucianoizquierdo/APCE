package com.apce.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
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

import com.apce.modelo.Caja;
import com.apce.modelo.CantidadRollos;
import com.apce.modelo.Color;
import com.apce.modelo.Film;
import com.apce.modelo.Formato;
import com.apce.modelo.SolicitudProduccion;
import com.apce.modelo.TipoMateriaPrima;
import com.apce.modelo.kendo.DataSourceRequest;
import com.apce.modelo.kendo.DataSourceResult;
import com.apce.servicio.servicoInterfaz.MateriaPrimaService;
import com.apce.servicio.servicoInterfaz.SolicitudProduccionService;
import com.apce.web.dto.SolicitudProduccionDTO;
import com.apce.web.form.SolicitudProduccionEstadisticaForm;
import com.apce.web.form.SolicitudProduccionForm;
import com.apce.web.helper.SolicitudProduccionHelper;

@Controller
@RequestMapping("/EstadisticaSolicitudProduccionPendiente")
@SessionAttributes({"solicitudProduccionEstadisticaForm"} ) 
public class SolicitudProduccionEstadisticaPendienteController {

	@Inject
	SolicitudProduccionService solicitudProduccionService;

	@Inject
	SolicitudProduccionHelper solicitudProduccionHelper;

	@Inject
	MateriaPrimaService materiaPrimaService;

	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

	@ModelAttribute("solicitudProduccionEstadisticaForm")
	public SolicitudProduccionEstadisticaForm createSolicitudProduccionEstadisticaForm() {
		return new SolicitudProduccionEstadisticaForm();
	}


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getGraficoBarrasFiltrado(Model model, SolicitudProduccionEstadisticaForm spef) throws ParseException {

		List<SolicitudProduccionDTO> solicitudProduccionDTOList = solicitudProduccionHelper.getSoclicitudProduccionDTO();

		//Collections.sort(adhesivoList);

		model.addAttribute("solicitudProduccionList", solicitudProduccionDTOList);

		return "solicitudProduccionEstadisticaPendiente";
	}

	@RequestMapping(value = "/SolicitudProduccionList/filtrarSolicitudProduccion", method = RequestMethod.POST)
	public @ResponseBody DataSourceResult readProduccion(@RequestBody DataSourceRequest request) {
		return solicitudProduccionService.getListaSolicitudProduccionSinOrdenProduccion(request);
	}

	@RequestMapping(value="/edit", method = RequestMethod.GET)
	public String edit(@RequestParam Long id, ModelMap model) {

		SolicitudProduccion sp = solicitudProduccionService.getSolicitudProduccionById(id);
		SolicitudProduccionForm solicitudProduccionForm = new SolicitudProduccionForm();

		bindEntityToForm(solicitudProduccionForm, sp);
		model.put("solicitudProduccionForm", solicitudProduccionForm);
		getModelAtributtes(model);
		
		return "solicitudProduccionAlta";
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

}
