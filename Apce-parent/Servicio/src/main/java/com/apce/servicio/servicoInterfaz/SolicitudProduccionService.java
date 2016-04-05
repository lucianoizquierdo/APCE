package com.apce.servicio.servicoInterfaz;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.apce.modelo.SolicitudProduccion;
import com.apce.modelo.kendo.DataSourceRequest;
import com.apce.modelo.kendo.DataSourceResult;

public interface SolicitudProduccionService extends BaseService {
	
	
	public void saveOrUpdate(SolicitudProduccion p);

	public SolicitudProduccion getSolicitudProduccionById(Long id);
	
	public DataSourceResult getListaSolicitudProduccion(DataSourceRequest request);
	
	public  Map<Date,Integer> getGraficoBarrasSolicitudesProduccion() throws ParseException;

	public Map<Date, Integer> getGraficoBarrasSolicitudesProduccion(Date fechaInicio, Date fechaFin) throws ParseException;

	public DataSourceResult getListaSolicitudProduccionSinOrdenProduccion(DataSourceRequest request);

	public List<SolicitudProduccion> getSolicitudProduccionByProcesada(boolean b); 


}
