package com.apce.servicio.impl;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apce.modelo.EstandarProduccion;
import com.apce.modelo.OrdenProduccion;
import com.apce.modelo.SolicitudProduccion;
import com.apce.modelo.kendo.DataSourceRequest;
import com.apce.modelo.kendo.DataSourceResult;
import com.apce.persistencia.hibernate.OrdenProduccionDAOImpl;
import com.apce.persistencia.interfaz.BaseDAO;
import com.apce.persistencia.interfaz.OrdenProduccionDAO;
import com.apce.servicio.helper.OrdenProduccionServicioHelper;
import com.apce.servicio.servicoInterfaz.OrdenProduccionService;


@Service
@Transactional
public class OrdenProduccionServiceImpl implements OrdenProduccionService {

	@Inject
	OrdenProduccionDAO ordenProduccionDAO;
	
	@Inject
	OrdenProduccionServicioHelper ordenProduccionHelper;
	
	@Override
	public void setDao(BaseDAO dao) {
		// TODO Auto-generated method stub
		this.ordenProduccionDAO = (OrdenProduccionDAOImpl)dao;
	}

	@Override
	public void saveOrUpdate(OrdenProduccion op) {
		// TODO Auto-generated method stub
		ordenProduccionDAO.saveOrUpdate(op);
	}


	@Override
	public DataSourceResult getListaOrdenProduccion(
			DataSourceRequest request) {
		return ordenProduccionDAO.getListaOrdenProduccion(request);
	}

	@Override
	public OrdenProduccion getOrdenProduccionById(Long id) {

		return ordenProduccionDAO.getOrdenProduccionById(id);
	}

	@Override
	public OrdenProduccion generarOrdenProduccion(SolicitudProduccion sp, EstandarProduccion ep) {
		// TODO Auto-generated method stub
		return ordenProduccionHelper.generarOrdenProduccion(sp, ep);
				
	}

	@Override
	public Map<Date, Integer> getGraficoBarrasOrdenesProduccionProcesadas() throws ParseException {
		// TODO Auto-generated method stub
		return ordenProduccionDAO.getGraficoBarrasOrdenesProduccionProcesadas(); 
	}

	@Override
	public Map<Date, Integer> getGraficoBarrasOrdenesProduccionProcesadas(
			Date fechaInicio, Date fechaFin) throws ParseException {
		return ordenProduccionDAO.getGraficoBarrasOrdenesProduccionProcesadas(fechaInicio, fechaFin); 
	}

	@Override
	public List<OrdenProduccion> getOrdenProduccionByProcesada(boolean b) {
		
		return ordenProduccionDAO.getOrdenProduccionByProcesada(b);

	}

	@Override
	public DataSourceResult getListaOrdenProduccionSinProcesar(
			DataSourceRequest request) {
		// TODO Auto-generated method stub
		return ordenProduccionDAO.getListaOrdenProduccionSinProcesar(request);
	}


}
