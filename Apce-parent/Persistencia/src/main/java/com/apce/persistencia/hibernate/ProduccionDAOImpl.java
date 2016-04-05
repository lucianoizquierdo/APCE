package com.apce.persistencia.hibernate;

import com.apce.modelo.Produccion;
import com.apce.modelo.kendo.DataSourceRequest;
import com.apce.modelo.kendo.DataSourceResult;
import com.apce.persistencia.interfaz.ProduccionDAO;

public class ProduccionDAOImpl extends BaseDaoImpl implements ProduccionDAO {
	

	@Override
	public void saveOrUptade(Produccion p) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(p);
	}
	
	@Override
	public DataSourceResult getListaProduccion(DataSourceRequest request) {
		return request.toDataSourceResult(getHibernateTemplate().getSessionFactory().getCurrentSession(), Produccion.class);
	}

}
