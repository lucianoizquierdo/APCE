package com.apce.servicio.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apce.modelo.Sucursal;
import com.apce.modelo.kendo.DataSourceRequest;
import com.apce.modelo.kendo.DataSourceResult;
import com.apce.persistencia.hibernate.MateriaPrimaDAOImpl;
import com.apce.persistencia.hibernate.SucursalDAOImpl;
import com.apce.persistencia.interfaz.BaseDAO;
import com.apce.persistencia.interfaz.SucursalDAO;
import com.apce.servicio.servicoInterfaz.SucursalService;

@Service
@Transactional
public class SucursalServiceImpl extends BaseServiceImpl implements SucursalService{

	@Inject
	private SucursalDAOImpl dao;
	
	@Override
	public void setDao(BaseDAO dao) {
		// TODO Auto-generated method stub
		this.dao = (SucursalDAOImpl)dao;
	}


	@Override
	public void altaSucursal(Sucursal suc) {
		// TODO Auto-generated method stub
		dao.altaSucursal(suc);
	}

	@Override
	public void bajaSucursal(Sucursal suc) {
		// TODO Auto-generated method stub
		dao.bajaSucursal(suc);
	}

	@Override
	public void modificarSurucsal(Sucursal sucursal) {
		// TODO Auto-generated method stub
		dao.modificarSurucsal(sucursal);
	}


	@Override
	public List<Sucursal> getSucursales() {
		// TODO Auto-generated method stub
		return dao.getSucursales();
	}


	@Override
	public Sucursal getSucursalById(Integer idSucursal) {
		// TODO Auto-generated method stub
		return dao.getSucursalById(idSucursal);
	}


	@Override
	public DataSourceResult getLista(DataSourceRequest request) {
		// TODO Auto-generated method stub
		return dao.getLista(request);
	}

}
