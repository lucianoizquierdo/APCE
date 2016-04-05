package com.apce.servicio.impl;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apce.modelo.SolicitudProduccion;
import com.apce.modelo.kendo.DataSourceRequest;
import com.apce.modelo.kendo.DataSourceResult;
import com.apce.persistencia.hibernate.SolicitudProduccionDAOImpl;
import com.apce.persistencia.interfaz.BaseDAO;
import com.apce.persistencia.interfaz.SolicitudProduccionDAO;
import com.apce.servicio.servicoInterfaz.SolicitudProduccionService;


@Service
@Transactional
public class SolicitudProduccionServiceImpl implements SolicitudProduccionService {

	@Inject
	SolicitudProduccionDAO solicitudProduccionDAO;
	
	@Override
	public void setDao(BaseDAO dao) {
		// TODO Auto-generated method stub
		this.solicitudProduccionDAO = (SolicitudProduccionDAOImpl)dao;
	}

	@Override
	public void saveOrUpdate(SolicitudProduccion sp) {
		// TODO Auto-generated method stub
		solicitudProduccionDAO.saveOrUpdate(sp);
	}

	@Override
	public SolicitudProduccion getSolicitudProduccionById(Long id) {
		// TODO Auto-generated method stub
		return solicitudProduccionDAO.getSolicitudProduccionById(id);
	}

	@Override
	public DataSourceResult getListaSolicitudProduccion(
			DataSourceRequest request) {
		return solicitudProduccionDAO.getListaSolicitudProduccion(request);
	}

	@Override
	public Map<Date, Integer> getGraficoBarrasSolicitudesProduccion()
			throws ParseException {
		return solicitudProduccionDAO.getGraficoBarrasSolicitudesProduccion(); 
	}

	@Override
	public Map<Date, Integer> getGraficoBarrasSolicitudesProduccion(Date fechaInicio, Date fechaFin)
			throws ParseException {
		return solicitudProduccionDAO.getGraficoBarrasSolicitudesProduccion(fechaInicio, fechaFin); 
	}

	@Override
	public DataSourceResult getListaSolicitudProduccionSinOrdenProduccion(
			DataSourceRequest request) {
		return solicitudProduccionDAO.getListaSolicitudProduccionSinOrdenProduccion(request);
	}

	@Override
	public List<SolicitudProduccion> getSolicitudProduccionByProcesada(boolean b) {
		// TODO Auto-generated method stub
		return solicitudProduccionDAO.getSolicitudProduccionByProcesada(b);
	}

}
