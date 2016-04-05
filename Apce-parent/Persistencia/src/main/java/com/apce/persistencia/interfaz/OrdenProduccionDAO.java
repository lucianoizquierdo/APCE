package com.apce.persistencia.interfaz;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.apce.modelo.OrdenProduccion;
import com.apce.modelo.kendo.DataSourceRequest;
import com.apce.modelo.kendo.DataSourceResult;

public interface OrdenProduccionDAO  extends BaseDAO {
	
	
	public void saveOrUpdate(OrdenProduccion op);

	public OrdenProduccion getOrdenProduccionById(Long id);
	
	public DataSourceResult getListaOrdenProduccion(DataSourceRequest request);

	public Map<Date, Integer> getGraficoBarrasOrdenesProduccionProcesadas(Date fechaInicio, Date fechaFin)  throws ParseException;

	public Map<Date, Integer> getGraficoBarrasOrdenesProduccionProcesadas()  throws ParseException;

	public List<OrdenProduccion> getOrdenProduccionByProcesada(boolean b);

	public DataSourceResult getListaOrdenProduccionSinProcesar(DataSourceRequest request);

}