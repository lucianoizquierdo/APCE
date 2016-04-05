package com.apce.persistencia.hibernate;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.hibernate.Query;

import com.apce.modelo.OrdenProduccion;
import com.apce.modelo.SolicitudProduccion;
import com.apce.modelo.kendo.DataSourceRequest;
import com.apce.modelo.kendo.DataSourceResult;
import com.apce.persistencia.interfaz.OrdenProduccionDAO;

public class OrdenProduccionDAOImpl extends BaseDaoImpl implements OrdenProduccionDAO{


	@Override
	public void saveOrUpdate(OrdenProduccion op) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(op);

	}

	@Override
	public OrdenProduccion getOrdenProduccionById(Long id) {
		List<OrdenProduccion> OrdenesProduccion = getHibernateTemplate().find("select op from OrdenProduccion op where op.id = " + id);
		if(OrdenesProduccion.size() != 0)
			return OrdenesProduccion.get(0);
		else
			return null; 
	}

	@Override
	public DataSourceResult getListaOrdenProduccion(DataSourceRequest request) {
		return request.toDataSourceResult(getHibernateTemplate().getSessionFactory().getCurrentSession(), OrdenProduccion.class);
	}



	@Override
	public Map<Date, Integer> getGraficoBarrasOrdenesProduccionProcesadas(
			Date fechaInicio, Date fechaFin) throws ParseException {


		String hql = "select o2.fechaAlta as fecha, (select count(o1.fechaAlta) from OrdenProduccion o1 where o1.fechaAlta = o2.fechaAlta " +
				"and o1.fechaAlta between :fechaInicio and :fechaFin) as count from OrdenProduccion o2 where o2.fechaAlta between :fechaInicio and :fechaFin " +
				"group by o2.fechaAlta order by o2.fechaAlta asc";

		Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql);
		query.setParameter("fechaInicio"	, fechaInicio);
		query.setParameter("fechaFin"	, fechaFin);

		List<Object> objects = query.list();

		Map<Date,Integer> map = transformerToMap(objects);

		return map;
	}

	@Override
	public Map<Date, Integer> getGraficoBarrasOrdenesProduccionProcesadas()
			throws ParseException {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH,1);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.YEAR, 2013);

		Date fechaInicio = cal.getTime();

		cal.set(Calendar.YEAR, 2014);
		Date fechaFin = cal.getTime();

		String hql = "select o2.fechaAlta as fecha, (select count(o1.fechaAlta) from OrdenProduccion o1 where o1.fechaAlta = o2.fechaAlta " +
				"and o1.fechaAlta between :fechaInicio and :fechaFin) as count from OrdenProduccion o2 group by o2.fechaAlta order by o2.fechaAlta asc";

		Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql);
		query.setParameter("fechaInicio"	, fechaInicio);
		query.setParameter("fechaFin"	, fechaFin);

		List<Object> objects = query.list();

		Map<Date,Integer> map = transformerToMap(objects);

		return map;
	}

	private Map<Date, Integer> transformerToMap(List<Object> objects) throws ParseException {

		Map<Date,Integer> map = new TreeMap<Date,Integer>();
		Integer cantidad = 0;

		for (Object object : objects) 
		{
			Object[] o = (Object[])object;
			Date fecha = new Date( ((Timestamp)o[0]).getTime() )  ;

			cantidad = new Integer( ((Long)o[1]).intValue());
			map.put(fecha, cantidad);
		}

		return map;	

	}

	@Override
	public List<OrdenProduccion> getOrdenProduccionByProcesada(boolean b) {

		List<OrdenProduccion> ordenesProduccion = new ArrayList<OrdenProduccion>();

		if(b == true)
		{
			ordenesProduccion = getHibernateTemplate().find("select o from OrdenProduccion o where o.procesada = true");
		}
		else
		{
			ordenesProduccion = getHibernateTemplate().find("select o from OrdenProduccion o where o.procesada = false");
		}

		return ordenesProduccion;
	}

	@Override
	public DataSourceResult getListaOrdenProduccionSinProcesar(
			DataSourceRequest request) {

		DataSourceResult dsr = request.toDataSourceResult(getHibernateTemplate().getSessionFactory().getCurrentSession(), OrdenProduccion.class);

		List<OrdenProduccion> ordenesProduccion = (List<OrdenProduccion>) dsr.getData();

		String hql = "select o from OrdenProduccion o where o IN (:ordenesProduccion)  and o IN (select op from OrdenProduccion op where op.procesada = false)";
		
		Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql);
		query.setParameterList("ordenesProduccion", ordenesProduccion);
		ordenesProduccion = query.list();

		dsr.setData(ordenesProduccion);
		dsr.setTotal(getHibernateTemplate().find("from OrdenProduccion o where o IN (select op from OrdenProduccion op where op.procesada = false)").size());

		return dsr;
	}
}
