package com.apce.persistencia.hibernate;

import com.apce.modelo.Material;
import com.apce.persistencia.interfaz.MaterialDAO;

public class MaterialDAOImpl extends BaseDaoImpl implements MaterialDAO{


	@Override
	public void saveOrUptade(Material m) {
		getHibernateTemplate().saveOrUpdate(m);
		
	}
}
