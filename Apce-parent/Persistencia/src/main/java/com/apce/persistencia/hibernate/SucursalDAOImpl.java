package com.apce.persistencia.hibernate;

import java.util.List;

import com.apce.modelo.Sucursal;
import com.apce.modelo.kendo.DataSourceRequest;
import com.apce.modelo.kendo.DataSourceResult;
import com.apce.persistencia.interfaz.SucursalDAO;

public class SucursalDAOImpl extends BaseDaoImpl implements SucursalDAO{

	
	public void altaSucursal(Sucursal suc) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(suc);
		
	}

	public void bajaSucursal(Sucursal suc) {
		// TODO Auto-generated method stub
		//La borro logicamente
		suc.setActiva(false);
		getHibernateTemplate().saveOrUpdate(suc);
		
	}


	public void modificarSurucsal(Sucursal sucursal) {
		getHibernateTemplate().saveOrUpdate(sucursal);
		
	}

	
	public List<Sucursal> getSucursales() {
		// TODO Auto-generated method stub
		List<Sucursal> sucursales = (List<Sucursal>)getHibernateTemplate().find("select s from Sucursal s");
		return sucursales;
	}

	public Sucursal getSucursalById(Integer idSucursal) {
		// TODO Auto-generated method stub
		List<Sucursal> sucursales = getHibernateTemplate().find("select s from Sucursal s where s.idSucursal = " + "'" + idSucursal + "'");
		if(sucursales.size() != 0)
			return sucursales.get(0);
		else
			return null;
	}

	public DataSourceResult getLista(DataSourceRequest request) {
		// TODO Auto-generated method stub
		return request.toDataSourceResult(getHibernateTemplate().getSessionFactory().getCurrentSession(), Sucursal.class);
	}
}
