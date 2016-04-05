package com.apce.web.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.apce.servicio.servicoInterfaz.OrdenProduccionService;
import com.apce.web.dto.MateriaPrimaDTO;
import com.apce.web.form.OrdenProduccionEstadisticaForm;

@Controller
@RequestMapping("/EstadisticaOrdenProduccion")
@SessionAttributes({"ordenProduccionEstadisticaForm"} ) 
public class OrdenProduccionEstadisticaController {
	
	@Inject
	OrdenProduccionService OrdenProduccionService;
	
	@Inject
	OrdenProduccionService ordenProduccionService;
	
	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

	@ModelAttribute("ordenProduccionEstadisticaForm")
	public OrdenProduccionEstadisticaForm createOrdenProduccionEstadisticaForm() {
		return new OrdenProduccionEstadisticaForm();
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	    public String getGraficoBarras(Model model) throws ParseException {
		
			
		 	//DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		 	DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		 
			List<String> resultFecha = new ArrayList<String>();
			List<Integer> resultCantidad = new ArrayList<Integer>();
			
	        Map<Date,Integer> fechas_count = OrdenProduccionService.getGraficoBarrasOrdenesProduccionProcesadas();
	        
	        Iterator it = fechas_count.entrySet().iterator();
			while (it.hasNext()) 
			{
				Map.Entry e = (Map.Entry)it.next();
				
				Date d = (Date)e.getKey();
				Integer cantidad = ((Integer)e.getValue());
				
				resultFecha.add(formatter.format(d));
				resultCantidad.add(cantidad);
			}
	       
			
			
			String[] fechas 		= resultFecha.toArray(new String[resultFecha.size()]);
			Integer[] cantidades 	= resultCantidad.toArray(new Integer[resultCantidad.size()]);
	        		
	        model.addAttribute("fechas", fechas);
	        model.addAttribute("cantidades", cantidades);
	        
	        
	        String[] anios = {"2009","2010","2011","2012","2013"};
	        model.addAttribute("anios", anios);
	        
	        String[] meses = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
	        model.addAttribute("meses", meses);
	        
	        return "OrdenProduccionEstadistica";
	    }
	
	@RequestMapping(value = "/filtro", method = RequestMethod.GET)
    public String getGraficoBarrasFiltrado(Model model, OrdenProduccionEstadisticaForm spef) throws ParseException {
		
	 	Integer anio 	= spef.getAnio();
	 	String mes 		= spef.getMes();
	 	
	 	if(anio == null)
	 	{
	 		anio = 2013;
	 		mes = "Enero";
	 	}
	 	
//		List<String> resultFecha = new ArrayList<String>();
//		List<Integer> resultCantidad = new ArrayList<Integer>();
		
	 	Object[] graficoAnio = getGraficoBarrasAnio(anio);
	 	Object[] graficoMes = getGraficoBarrasMes(mes,anio);
	 	
		
	 	String[] fechasAnio 		= (String[])graficoAnio[0];
		Integer[] cantidadesAnio	= (Integer[])graficoAnio[1];
		
		String[] fechasMes 			= (String[])graficoMes[0];
		Integer[] cantidadesMes		= (Integer[])graficoMes[1];
        		
        model.addAttribute("fechasAnio", fechasAnio);
        model.addAttribute("cantidadesAnio", cantidadesAnio);
        
        model.addAttribute("fechasMes", fechasMes);
        model.addAttribute("cantidadesMes", cantidadesMes);
        
        
        String[] anios = {"2009","2010","2011","2012","2013"};
        model.addAttribute("anios", anios);
        
        String[] meses = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        model.addAttribute("meses", meses);
        
        return "ordenProduccionEstadistica";
    }
	
	private Object[] getGraficoBarrasMes(String mes,Integer anio) throws ParseException {
		
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		
		Calendar c = Calendar.getInstance();
		
	 	c.set(Calendar.YEAR, anio);
	 	c.set(Calendar.MONTH,getMes(mes));
	 	c.set(Calendar.DAY_OF_MONTH, 1);
	 	Date fechaInicio = c.getTime();
	 	
	 	c.set(Calendar.DATE, c.getActualMaximum(Calendar.DAY_OF_MONTH));
	 	Date fechaFin = c.getTime();
	 	
	 	List<String> resultFecha = new ArrayList<String>();
		List<Integer> resultCantidad = new ArrayList<Integer>();
		
	 	Map<Date,Integer> fechas_count = OrdenProduccionService.getGraficoBarrasOrdenesProduccionProcesadas(fechaInicio, fechaFin);
		
	 	Iterator it = fechas_count.entrySet().iterator();
		while (it.hasNext()) 
		{
			Map.Entry e = (Map.Entry)it.next();
			
			Date d = (Date)e.getKey();
			Integer cantidad = ((Integer)e.getValue());
			
			resultFecha.add(formatter.format(d));
			resultCantidad.add(cantidad);
		}

		String[] fechas 	= resultFecha.toArray(new String[resultFecha.size()]);
		Integer[] cantidades	= resultCantidad.toArray(new Integer[resultCantidad.size()]);
		
		Object[] graficoAnio = new Object[]{fechas,cantidades};
		
		return graficoAnio;
	}

	private int getMes(String mes) {

		int result = 0;

		switch(mes){
		case "Enero":
		{
			result=0;
			break;
		}
		case "Febrero":
		{
			result=1;
			break;
		}
		case "Marzo":
		{
			result=2;
			break;
		}
		case "Abril":
		{
			result=3;
			break;
		}
		case "Mayo":
		{
			result=4;
			break;
		}
		case "Junio":
		{
			result=5;
			break;
		}
		case "Julio":
		{
			result=6;
			break;
		}
		case "Agosto":
		{
			result=7;
			break;
		}
		case "Septiembre":
		{
			result=8;
			break;
		}
		case "Octubre":
		{
			result=9;
			break;
		}
		case "Noviembre":
		{
			result=10;
			break;
		}
		case "Diciembre":
		{
			result=11;
			break;
		}
		default:
		{
			result=0;
			break;
		}
		}

		return result;
	}

	private Object[]  getGraficoBarrasAnio(Integer anio) throws ParseException {

		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		
		Calendar c = Calendar.getInstance();
	 	c.set(Calendar.YEAR, anio);
	 	c.set(Calendar.DAY_OF_YEAR,1);
	 	Date fechaInicio = c.getTime();
	 	
	 	c.set(Calendar.DAY_OF_YEAR,365);
	 	Date fechaFin = c.getTime();
	 	
	 	List<String> resultFecha = new ArrayList<String>();
		List<Integer> resultCantidad = new ArrayList<Integer>();
		
	 	Map<Date,Integer> fechas_count = OrdenProduccionService.getGraficoBarrasOrdenesProduccionProcesadas(fechaInicio, fechaFin);
		
	 	Iterator it = fechas_count.entrySet().iterator();
		while (it.hasNext()) 
		{
			Map.Entry e = (Map.Entry)it.next();
			
			Date d = (Date)e.getKey();
			Integer cantidad = ((Integer)e.getValue());
			
			resultFecha.add(formatter.format(d));
			resultCantidad.add(cantidad);
		}

		String[] fechas 	= resultFecha.toArray(new String[resultFecha.size()]);
		Integer[] cantidades	= resultCantidad.toArray(new Integer[resultCantidad.size()]);
		
		Object[] graficoAnio = new Object[]{fechas,cantidades};
		
		return graficoAnio;
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
	

//	@RequestMapping(value="/filtro", method = RequestMethod.GET)
//	public String getEstadisticaMateriaPrimaFiltro(@RequestParam String fi, @RequestParam String ff, Model model) {
//		
//		Date fechaInicio,fechaFin;
//        
//        Date[] fechas = getFechas(fi, ff);
//		fechaInicio = fechas[0];
//		fechaFin = fechas[1];
//			
//		List<MateriaPrimaDTO> adhesivoList = materiaPrimaHelper.getMateriaPrimaDTO("adhesivo", fechaInicio,fechaFin);
//		List<MateriaPrimaDTO> aditivoList = materiaPrimaHelper.getMateriaPrimaDTO("aditivo", fechaInicio,fechaFin);
//		List<MateriaPrimaDTO> pigmentoList = materiaPrimaHelper.getMateriaPrimaDTO("pigmento", fechaInicio,fechaFin);
//		List<MateriaPrimaDTO> diluyenteList = materiaPrimaHelper.getMateriaPrimaDTO("diluyente", fechaInicio,fechaFin);
//		
//		Collections.sort(adhesivoList);
//		Collections.sort(aditivoList);
//		Collections.sort(pigmentoList);
//		Collections.sort(diluyenteList);
//		
//		adhesivoList = getCincoMasUsados(adhesivoList);
//		aditivoList = getCincoMasUsados(aditivoList);
//		pigmentoList = getCincoMasUsados(pigmentoList);
//		diluyenteList = getCincoMasUsados(diluyenteList);
//		
//		model.addAttribute("adhesivoList", adhesivoList);
//		model.addAttribute("aditivoList", aditivoList);
//		model.addAttribute("pigmentoList", pigmentoList);
//		model.addAttribute("diluyenteList", diluyenteList);
//		
//		model.addAttribute("start", fechas[0]);
//		model.addAttribute("end", fechas[1]);
//
//		return "materiaPrimaEstadistica";
//	}
//	
//	@RequestMapping(value = "/tinta", method = RequestMethod.GET)
//    public @ResponseBody List<MateriaPrimaDTO> getEstadisticaTinta() {
//
//		List<MateriaPrimaDTO> tintas = materiaPrimaHelper.getMateriaPrimaDTO("tinta", new Date("15/07/2013"),new Date("18/07/2013")); 
//        
//		return tintas;
//    }
//	
//	@RequestMapping(value = "/adhesivo", method = RequestMethod.GET)
//    public @ResponseBody List<MateriaPrimaDTO> getEstadisticaAdhesivo(@RequestParam String fi, @RequestParam String ff, Model model) throws ParseException {
//
//		Date fechaInicio,fechaFin;
//	        
//        Date[] fechas = getFechas(fi, ff);
//		fechaInicio = fechas[0];
//		fechaFin = fechas[1];
//			
//		List<MateriaPrimaDTO> adhesivos = materiaPrimaHelper.getMateriaPrimaDTO("adhesivo", fechaInicio,fechaFin); 
//		Collections.sort(adhesivos);
//		
//		return adhesivos;
//    }
//	
//	@RequestMapping(value = "/pigmento", method = RequestMethod.GET)
//    public @ResponseBody List<MateriaPrimaDTO> getEstadisticaPigmento(@RequestParam String fi, @RequestParam String ff) throws ParseException {
//
//		Date fechaInicio,fechaFin;
//        
//        Date[] fechas = getFechas(fi, ff);
//		fechaInicio = fechas[0];
//		fechaFin = fechas[1];
//			
//		List<MateriaPrimaDTO> pigmentos = materiaPrimaHelper.getMateriaPrimaDTO("pigmento",  fechaInicio,fechaFin); 
//		Collections.sort(pigmentos);
//        
//		return pigmentos;
//    }
//	
//	@RequestMapping(value = "/aditivo", method = RequestMethod.GET)
//    public @ResponseBody List<MateriaPrimaDTO> getEstadisticaAditivo(@RequestParam String fi, @RequestParam String ff) throws ParseException {
//
//		Date fechaInicio,fechaFin;
//        
//        Date[] fechas = getFechas(fi, ff);
//		fechaInicio = fechas[0];
//		fechaFin = fechas[1];
//			
//		List<MateriaPrimaDTO> aditivos = materiaPrimaHelper.getMateriaPrimaDTO("aditivo", fechaInicio,fechaFin);
//		Collections.sort(aditivos);
//        
//		return aditivos;
//    }
//	
//	@RequestMapping(value = "/diluyente", method = RequestMethod.GET)
//    public @ResponseBody List<MateriaPrimaDTO> getEstadisticaDiluyente(@RequestParam String fi, @RequestParam String ff) throws ParseException {
//
//		Date fechaInicio,fechaFin;
//        
//        Date[] fechas = getFechas(fi, ff);
//		fechaInicio = fechas[0];
//		fechaFin = fechas[1];
//			
//		List<MateriaPrimaDTO> diluyentes = materiaPrimaHelper.getMateriaPrimaDTO("diluyente", fechaInicio,fechaFin); 
//		Collections.sort(diluyentes);
//        
//		return diluyentes;
//    }
//	
//	private Date[] getFechas(String fi, String ff)
//	{
//		Date fechaInicio = null,fechaFin = null;
//		
//		Date[] fechas = new Date[]{fechaInicio,fechaFin};
//
//		if(!fi.equalsIgnoreCase("null") && !ff.equalsIgnoreCase("null"))
//		{
//			fechaInicio= new Date(fi);
//			fechaFin= new Date(ff);
//		}
//		else
//		{
//			Calendar cal = new GregorianCalendar();
//	        cal.setTimeInMillis(new Date().getTime());
//	        cal.add(Calendar.YEAR, -1);
//	        
//			fechaInicio = new Date(cal.getTimeInMillis());
//			fechaFin = new Date();
//		}
//		
//		fechas[0] = fechaInicio;
//		fechas[1] = fechaFin;
//		
//		return fechas;
//		
//	}
}
