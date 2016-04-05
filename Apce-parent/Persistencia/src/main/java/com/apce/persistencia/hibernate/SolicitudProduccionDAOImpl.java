package com.apce.persistencia.hibernate;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.hibernate.Query;

import com.apce.modelo.SolicitudProduccion;
import com.apce.modelo.kendo.DataSourceRequest;
import com.apce.modelo.kendo.DataSourceResult;
import com.apce.persistencia.interfaz.SolicitudProduccionDAO;

public class SolicitudProduccionDAOImpl extends BaseDaoImpl implements SolicitudProduccionDAO{


	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	
	@Override
	public void saveOrUpdate(SolicitudProduccion sp) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(sp);

	}

	@Override
	public SolicitudProduccion getSolicitudProduccionById(Long id) {
		List<SolicitudProduccion> solicitudesProduccion= getHibernateTemplate().find("select sp from SolicitudProduccion sp where sp.id = " + id);
		if(solicitudesProduccion.size() != 0)
			return solicitudesProduccion.get(0);
		else
			return null; 
	}

	@Override
	public DataSourceResult getListaSolicitudProduccion(
			DataSourceRequest request) {
		return request.toDataSourceResult(getHibernateTemplate().getSessionFactory().getCurrentSession(), SolicitudProduccion.class);
	}

	@Override
	public  Map<Date,Integer> getGraficoBarrasSolicitudesProduccion() throws ParseException 
	{

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH,1);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.YEAR, 2013);

		Date fechaInicio = cal.getTime();

		cal.set(Calendar.YEAR, 2014);
		Date fechaFin = cal.getTime();
		
		//		select s2.fechaAlta as fecha,
		//		(select count(s1.fechaAlta) from SolicitudProduccion s1 where s1.fechaAlta = s2.fechaAlta and s1.fechaAlta between '2009-11-27T21:57:18.010+01:00'  and '2013-11-27T21:57:18.010+01:00') as count 
		//		from SolicitudProduccion s2 group by s2.fechaAlta
		
		
		String hql = "select s2.fechaAlta as fecha, (select count(s1.fechaAlta) from SolicitudProduccion s1 where s1.fechaAlta = s2.fechaAlta " +
				"and s1.fechaAlta between :fechaInicio and :fechaFin) as count from SolicitudProduccion s2 group by s2.fechaAlta order by s2.fechaAlta asc";
		
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
	public Map<Date, Integer> getGraficoBarrasSolicitudesProduccion(
			Date fechaInicio, Date fechaFin) throws ParseException {
		
		String hql = "select s2.fechaAlta as fecha, (select count(s1.fechaAlta) from SolicitudProduccion s1 where s1.fechaAlta = s2.fechaAlta " +
				"and s1.fechaAlta between :fechaInicio and :fechaFin) as count from SolicitudProduccion s2 where s2.fechaAlta between :fechaInicio and :fechaFin " +
				"group by s2.fechaAlta order by s2.fechaAlta asc";
		
		Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql);
		query.setParameter("fechaInicio"	, fechaInicio);
		query.setParameter("fechaFin"	, fechaFin);

		List<Object> objects = query.list();

		Map<Date,Integer> map = transformerToMap(objects);

		return map;
	}

	@Override
	public DataSourceResult getListaSolicitudProduccionSinOrdenProduccion(DataSourceRequest request) {
		
//		from SolicitudProduccion s where s not in (select op.solicitudProduccion from OrdenProduccion op) 
		
		DataSourceResult dsr = request.toDataSourceResult(getHibernateTemplate().getSessionFactory().getCurrentSession(), SolicitudProduccion.class);

		List<SolicitudProduccion> solicitudesProduccion = (List<SolicitudProduccion>) dsr.getData();
		
		String hql = "select s from SolicitudProduccion s where s IN (:solicitudesProduccion)  and s NOT IN (select op.solicitudProduccion from OrdenProduccion op)";
		Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql);
		query.setParameterList("solicitudesProduccion", solicitudesProduccion);
		solicitudesProduccion = query.list();
		
		dsr.setData(solicitudesProduccion);
		dsr.setTotal(getHibernateTemplate().find("from SolicitudProduccion s where s not in (select op.solicitudProduccion from OrdenProduccion op)").size());
		
		return dsr;
	}

	@Override
	public List<SolicitudProduccion> getSolicitudProduccionByProcesada(boolean b) {

		List<SolicitudProduccion> solicitudesProduccion = new ArrayList<SolicitudProduccion>();
		
		if(b == true)
		{
			solicitudesProduccion = getHibernateTemplate().find("select s from SolicitudProduccion s where s.ordenProduccion is NOT null");
		}
		else
		{
			solicitudesProduccion = getHibernateTemplate().find("select s from SolicitudProduccion s where s.ordenProduccion is NULL");
		}
		return solicitudesProduccion;
	}
}
