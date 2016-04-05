package com.apce.servicio.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apce.modelo.Produccion;
import com.apce.modelo.kendo.DataSourceRequest;
import com.apce.modelo.kendo.DataSourceResult;
import com.apce.persistencia.hibernate.ProduccionDAOImpl;
import com.apce.persistencia.interfaz.BaseDAO;
import com.apce.servicio.servicoInterfaz.ProduccionService;


@Service
@Transactional
public class ProduccionServiceImpl implements ProduccionService {

	@Inject
	ProduccionDAOImpl produccionDAO;
	
	@Override
	public void setDao(BaseDAO dao) {
		// TODO Auto-generated method stub
		this.produccionDAO = (ProduccionDAOImpl)dao;
	}

	@Override
	public DataSourceResult getListaProduccion(DataSourceRequest request) {
		// TODO Auto-generated method stub
		return produccionDAO.getListaProduccion(request);
	}

	@Override
	public void saveOrUpdate(Produccion p) {
		// TODO Auto-generated method stub
		produccionDAO.saveOrUptade(p);
	}
}
