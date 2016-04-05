package com.apce.servicio.servicoInterfaz;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.apce.modelo.EstandarProduccion;
import com.apce.modelo.OrdenProduccion;
import com.apce.modelo.SolicitudProduccion;
import com.apce.modelo.kendo.DataSourceRequest;
import com.apce.modelo.kendo.DataSourceResult;

public interface OrdenProduccionService extends BaseService {
	
	
	public void saveOrUpdate(OrdenProduccion o);

	public OrdenProduccion getOrdenProduccionById(Long id);
	
	public DataSourceResult getListaOrdenProduccion(DataSourceRequest request);
	
	public OrdenProduccion generarOrdenProduccion(SolicitudProduccion sp, EstandarProduccion ep);

	public Map<Date, Integer> getGraficoBarrasOrdenesProduccionProcesadas() throws ParseException;

	public Map<Date, Integer> getGraficoBarrasOrdenesProduccionProcesadas(Date fechaInicio, Date fechaFin) throws ParseException;

	public List<OrdenProduccion> getOrdenProduccionByProcesada(boolean b);

	public DataSourceResult getListaOrdenProduccionSinProcesar(DataSourceRequest request);


}
