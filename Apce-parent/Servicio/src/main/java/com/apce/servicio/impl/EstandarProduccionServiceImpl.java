package com.apce.servicio.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apce.modelo.Color;
import com.apce.modelo.EstandarProduccion;
import com.apce.modelo.Film;
import com.apce.modelo.Formato;
import com.apce.modelo.kendo.DataSourceRequest;
import com.apce.modelo.kendo.DataSourceResult;
import com.apce.persistencia.hibernate.EstandarProduccionDAOImpl;
import com.apce.persistencia.interfaz.BaseDAO;
import com.apce.servicio.servicoInterfaz.EstandarProduccionService;


@Service
@Transactional
public class EstandarProduccionServiceImpl implements EstandarProduccionService {

	@Inject
	EstandarProduccionDAOImpl estandarProduccionDAO;
	
	@Override
	public void setDao(BaseDAO dao) {
		// TODO Auto-generated method stub
		this.estandarProduccionDAO = (EstandarProduccionDAOImpl)dao;
	}

	@Override
	public DataSourceResult getListaEstandarProduccion(DataSourceRequest request) {
		// TODO Auto-generated method stub
		return estandarProduccionDAO.getListaEstandarProduccion(request);
	}

	@Override
	public void saveOrUpdate(EstandarProduccion ep) {
		// TODO Auto-generated method stub
		estandarProduccionDAO.saveOrUpdate(ep);
	}

	@Override
	public EstandarProduccion getEstandarProduccionById(Long id) {
		// TODO Auto-generated method stub
		return estandarProduccionDAO.getEstandarProduccionById(id);
	}

	@Override
	public EstandarProduccion findEstandarProduccionByUnique(Formato formato1, Formato formato2, Color fondo, Film film, Integer impreso) {
		
		return estandarProduccionDAO.findEstandarProduccionByIdfindEstandarProduccionByUnique(formato1, formato2 ,fondo, film, impreso);
	}
}
