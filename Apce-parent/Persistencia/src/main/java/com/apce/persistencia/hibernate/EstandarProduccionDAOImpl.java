package com.apce.persistencia.hibernate;

import java.util.List;

import org.aspectj.apache.bcel.generic.Type;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.type.EnumType;

import com.apce.modelo.Color;
import com.apce.modelo.EstandarProduccion;
import com.apce.modelo.Film;
import com.apce.modelo.Formato;
import com.apce.modelo.kendo.DataSourceRequest;
import com.apce.modelo.kendo.DataSourceResult;
import com.apce.persistencia.interfaz.EstandarProduccionDAO;

public class EstandarProduccionDAOImpl extends BaseDaoImpl implements EstandarProduccionDAO{ 


	@Override
	public void saveOrUpdate(EstandarProduccion ep) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(ep);
	}

	public DataSourceResult getListaEstandarProduccion(DataSourceRequest request) {
		// TODO Auto-generated method stub
		return request.toDataSourceResult(getHibernateTemplate().getSessionFactory().getCurrentSession(), EstandarProduccion.class);
	}

	@Override
	public EstandarProduccion getEstandarProduccionById(Long id) {
		// TODO Auto-generated method stub
		return (EstandarProduccion)getHibernateTemplate().find("Select e From EstandarProduccion e where e.id = " + id).get(0);
	}

	public EstandarProduccion findEstandarProduccionByIdfindEstandarProduccionByUnique(
			Formato formato1, Formato formato2, Color fondo, Film film,
			Integer impreso) {
		
		String hql = "select e from EstandarProduccion e where e.formato1 = :formato1 and " +
				"e.formato2 = :formato2 and " +
				"e.fondo = :fondo and " +
				"e.film = :film and " +
				"e.impreso = :impreso";
		Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql);
		
		query.setParameter("formato1", formato1.name(),Hibernate.STRING);  
		query.setParameter("formato2", formato2.name(),Hibernate.STRING);
		query.setParameter("fondo", fondo.name(),Hibernate.STRING);
		query.setParameter("film", film.name(),Hibernate.STRING);
		query.setParameter("impreso", impreso);
		
		List<EstandarProduccion> estandarsProduccion = query.list();
		if(estandarsProduccion.size() != 0)
			return estandarsProduccion.get(0);
		else
			return null;
	}

}
