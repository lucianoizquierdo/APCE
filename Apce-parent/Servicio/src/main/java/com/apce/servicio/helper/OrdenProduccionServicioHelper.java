package com.apce.servicio.helper;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.apce.modelo.EstandarProduccion;
import com.apce.modelo.OrdenProduccion;
import com.apce.modelo.SolicitudProduccion;
import com.apce.servicio.servicoInterfaz.EstandarProduccionService;

@Service
public class OrdenProduccionServicioHelper {
	
	@Inject
	EstandarProduccionService estandarProduccionService;
	
	public OrdenProduccion generarOrdenProduccion(SolicitudProduccion sp,EstandarProduccion ep)
	{
		
		Double cantidadTinta		= calcularCantidadTinta(sp.getImpreso(),ep.getTintaLitros(),sp);
		Double cantidadAdhesivo 	= calcularCantidad(ep.getAdhesivoKilos(),sp);
		Double cantidadPigmeto 		= calcularCantidad(ep.getPigmentoKilos(),sp);
		Double cantidadDiluyente 	= calcularCantidad(ep.getDiluyenteLitros(),sp);
		Double cantidadAditivo 		= calcularCantidad(ep.getAditivoKilos(),sp);
		
		Integer cantidadCajasNecesarias = sp.getCantidadRollos() / sp.getCaja().getRollosPorCaja();
		cantidadCajasNecesarias = round(sp.getCantidadRollos(),sp.getCaja().getRollosPorCaja());
		Integer tiempoEstimado = calcularTiempo(ep.getTiempoEstimado(), sp.getCantidadRollos());
		
		OrdenProduccion op = new OrdenProduccion();
		
		if(sp.getImpreso() == 1)
		{
			op.setTinta1Litros(cantidadTinta);
		}
		else if (sp.getImpreso() == 2)
		{
			op.setTinta1Litros(cantidadTinta);
			op.setTinta2Litros(cantidadTinta);
		}
		else if (sp.getImpreso() == 3)
		{
			op.setTinta1Litros(cantidadTinta);
			op.setTinta2Litros(cantidadTinta);
			op.setTinta3Litros(cantidadTinta);
		}
		
		op.setAdhesivoKilos(cantidadAdhesivo);
		op.setPigmentoKilos(cantidadPigmeto);
		op.setDiluyenteLitros(cantidadDiluyente);
		op.setAditivoKilos(cantidadAditivo);
		op.setEmpaque(cantidadCajasNecesarias);
		
		op.setSolicitudProduccion(sp);
		op.setDescripcion(sp.getDescripcion());
		op.setNombre(sp.getNombre());
		op.setObservaciones(sp.getObservaciones());
		
		op.setFechaAlta(new Date());
		
		op.setTiempoEstimado(tiempoEstimado);
		
		return op;
	}

	private Integer calcularTiempo(Integer tiempoEstimado,
			Integer cantidadRollos) {

		return (cantidadRollos * tiempoEstimado) / 100; //100 corresponde a 100 rollos, siempre todo es calculado en base a 100 rollos
	}

	private Integer round(Integer cantidadRollos, Integer rollosPorCaja) {
		// TODO Auto-generated method stub
		
		Integer cajasNecesarias= null;
		if (cantidadRollos%rollosPorCaja != 0)
		{
			cajasNecesarias = cantidadRollos/rollosPorCaja;
			cajasNecesarias++;
		}
		else
			cajasNecesarias = cantidadRollos/rollosPorCaja;
		
		return cajasNecesarias;
	}

	//Depende de a cuantos colores se hizo, calculo cuanto tinta se va a usar
	private Double calcularCantidadTinta(Integer impreso, Double cantidadtintaLitrosNecesaria, SolicitudProduccion sp) {
		
		Integer cantidadRollos = sp.getCantidadRollos();
		
		return ((cantidadRollos * cantidadtintaLitrosNecesaria ) / 100) / impreso;
	}

	//La cantidad de materia necesaria siempre esta basada en el estandar de cuando se define el EstandarProduccion que son 100 rollos.
	private Double calcularCantidad(Double cantidadMateriaPrimaNecesaria, SolicitudProduccion sp) {
		// TODO Auto-generated method stub
		Integer cantidadRollos = sp.getCantidadRollos();
		
		return (cantidadRollos * cantidadMateriaPrimaNecesaria) / 100;
		
	}
}
