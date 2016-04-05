package com.apce.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.apce.servicio.servicoInterfaz.MateriaPrimaService;
import com.apce.web.dto.MateriaPrimaDTO;
import com.apce.web.form.MateriaPrimaForm;
import com.apce.web.helper.MateriaPrimaHelper;

@Controller
@RequestMapping("/EstadisticaMateriaPrima")
public class MateriaPrimaEstadisticaController {
	
	@Inject
	MateriaPrimaService materiaPrimaService;
	
	@Inject
	MateriaPrimaHelper materiaPrimaHelper;
	
	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

	@ModelAttribute("materiaPrimaForm")
	public MateriaPrimaForm createMateriaPrimaForm() {
		return new MateriaPrimaForm();
	}
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String getEstadisticaMateriaPrima(Model model) {
		
		Date fechaInicio,fechaFin;
        
        Date[] fechas = getFechas("null", "null");
		fechaInicio = fechas[0];
		fechaFin = fechas[1];
		
		List<MateriaPrimaDTO> adhesivoList = materiaPrimaHelper.getMateriaPrimaDTO("adhesivo", fechaInicio,fechaFin);
		List<MateriaPrimaDTO> aditivoList = materiaPrimaHelper.getMateriaPrimaDTO("aditivo", fechaInicio,fechaFin);
		List<MateriaPrimaDTO> pigmentoList = materiaPrimaHelper.getMateriaPrimaDTO("pigmento", fechaInicio,fechaFin);
		List<MateriaPrimaDTO> diluyenteList = materiaPrimaHelper.getMateriaPrimaDTO("diluyente", fechaInicio,fechaFin);
		
		Collections.sort(adhesivoList);
		Collections.sort(aditivoList);
		Collections.sort(pigmentoList);
		Collections.sort(diluyenteList);
		
		adhesivoList = getCincoMasUsados(adhesivoList);
		aditivoList = getCincoMasUsados(aditivoList);
		pigmentoList = getCincoMasUsados(pigmentoList);
		diluyenteList = getCincoMasUsados(diluyenteList);
		
		model.addAttribute("adhesivoList", adhesivoList);
		model.addAttribute("aditivoList", aditivoList);
		model.addAttribute("pigmentoList", pigmentoList);
		model.addAttribute("diluyenteList", diluyenteList);

		return "materiaPrimaEstadistica";
	}
	
	private List<MateriaPrimaDTO> getCincoMasUsados(List<MateriaPrimaDTO> mpdtoList) {

		List<MateriaPrimaDTO> lista = new ArrayList<MateriaPrimaDTO>();
		
		if(mpdtoList.size() >= 5)
		{
			for (int i = 0; i < 5; i++) 
			{
				MateriaPrimaDTO mpdto = mpdtoList.get(i);
				lista.add(mpdto);
			}
			
			return lista;
		}
		
		return mpdtoList;
	}

	@RequestMapping(value="/filtro", method = RequestMethod.GET)
	public String getEstadisticaMateriaPrimaFiltro(@RequestParam String fi, @RequestParam String ff, Model model) {
		
		Date fechaInicio,fechaFin;
        
        Date[] fechas = getFechas(fi, ff);
		fechaInicio = fechas[0];
		fechaFin = fechas[1];
			
		List<MateriaPrimaDTO> adhesivoList = materiaPrimaHelper.getMateriaPrimaDTO("adhesivo", fechaInicio,fechaFin);
		List<MateriaPrimaDTO> aditivoList = materiaPrimaHelper.getMateriaPrimaDTO("aditivo", fechaInicio,fechaFin);
		List<MateriaPrimaDTO> pigmentoList = materiaPrimaHelper.getMateriaPrimaDTO("pigmento", fechaInicio,fechaFin);
		List<MateriaPrimaDTO> diluyenteList = materiaPrimaHelper.getMateriaPrimaDTO("diluyente", fechaInicio,fechaFin);
		
		Collections.sort(adhesivoList);
		Collections.sort(aditivoList);
		Collections.sort(pigmentoList);
		Collections.sort(diluyenteList);
		
		adhesivoList = getCincoMasUsados(adhesivoList);
		aditivoList = getCincoMasUsados(aditivoList);
		pigmentoList = getCincoMasUsados(pigmentoList);
		diluyenteList = getCincoMasUsados(diluyenteList);
		
		model.addAttribute("adhesivoList", adhesivoList);
		model.addAttribute("aditivoList", aditivoList);
		model.addAttribute("pigmentoList", pigmentoList);
		model.addAttribute("diluyenteList", diluyenteList);
		
		model.addAttribute("start", fechas[0]);
		model.addAttribute("end", fechas[1]);

		return "materiaPrimaEstadistica";
	}
	
	@RequestMapping(value = "/tinta", method = RequestMethod.GET)
    public @ResponseBody List<MateriaPrimaDTO> getEstadisticaTinta() {

		List<MateriaPrimaDTO> tintas = materiaPrimaHelper.getMateriaPrimaDTO("tinta", new Date("15/07/2013"),new Date("18/07/2013")); 
        
		return tintas;
    }
	
	@RequestMapping(value = "/adhesivo", method = RequestMethod.GET)
    public @ResponseBody List<MateriaPrimaDTO> getEstadisticaAdhesivo(@RequestParam String fi, @RequestParam String ff, Model model) throws ParseException {

		Date fechaInicio,fechaFin;
	        
        Date[] fechas = getFechas(fi, ff);
		fechaInicio = fechas[0];
		fechaFin = fechas[1];
			
		List<MateriaPrimaDTO> adhesivos = materiaPrimaHelper.getMateriaPrimaDTO("adhesivo", fechaInicio,fechaFin); 
		Collections.sort(adhesivos);
		
		return adhesivos;
    }
	
	@RequestMapping(value = "/pigmento", method = RequestMethod.GET)
    public @ResponseBody List<MateriaPrimaDTO> getEstadisticaPigmento(@RequestParam String fi, @RequestParam String ff) throws ParseException {

		Date fechaInicio,fechaFin;
        
        Date[] fechas = getFechas(fi, ff);
		fechaInicio = fechas[0];
		fechaFin = fechas[1];
			
		List<MateriaPrimaDTO> pigmentos = materiaPrimaHelper.getMateriaPrimaDTO("pigmento",  fechaInicio,fechaFin); 
		Collections.sort(pigmentos);
        
		return pigmentos;
    }
	
	@RequestMapping(value = "/aditivo", method = RequestMethod.GET)
    public @ResponseBody List<MateriaPrimaDTO> getEstadisticaAditivo(@RequestParam String fi, @RequestParam String ff) throws ParseException {

		Date fechaInicio,fechaFin;
        
        Date[] fechas = getFechas(fi, ff);
		fechaInicio = fechas[0];
		fechaFin = fechas[1];
			
		List<MateriaPrimaDTO> aditivos = materiaPrimaHelper.getMateriaPrimaDTO("aditivo", fechaInicio,fechaFin);
		Collections.sort(aditivos);
        
		return aditivos;
    }
	
	@RequestMapping(value = "/diluyente", method = RequestMethod.GET)
    public @ResponseBody List<MateriaPrimaDTO> getEstadisticaDiluyente(@RequestParam String fi, @RequestParam String ff) throws ParseException {

		Date fechaInicio,fechaFin;
        
        Date[] fechas = getFechas(fi, ff);
		fechaInicio = fechas[0];
		fechaFin = fechas[1];
			
		List<MateriaPrimaDTO> diluyentes = materiaPrimaHelper.getMateriaPrimaDTO("diluyente", fechaInicio,fechaFin); 
		Collections.sort(diluyentes);
        
		return diluyentes;
    }
	
	private Date[] getFechas(String fi, String ff)
	{
		Date fechaInicio = null,fechaFin = null;
		
		Date[] fechas = new Date[]{fechaInicio,fechaFin};

		if(!fi.equalsIgnoreCase("null") && !ff.equalsIgnoreCase("null"))
		{
			fechaInicio= new Date(fi);
			fechaFin= new Date(ff);
		}
		else
		{
			Calendar cal = new GregorianCalendar();
	        cal.setTimeInMillis(new Date().getTime());
	        cal.add(Calendar.YEAR, -1);
	        
			fechaInicio = new Date(cal.getTimeInMillis());
			fechaFin = new Date();
		}
		
		fechas[0] = fechaInicio;
		fechas[1] = fechaFin;
		
		return fechas;
		
	}
}
