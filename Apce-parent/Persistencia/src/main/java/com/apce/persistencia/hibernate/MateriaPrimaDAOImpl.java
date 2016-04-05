package com.apce.persistencia.hibernate;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;

import com.apce.modelo.MateriaPrima;
import com.apce.modelo.TipoMateriaPrima;
import com.apce.modelo.kendo.DataSourceRequest;
import com.apce.modelo.kendo.DataSourceResult;
import com.apce.persistencia.interfaz.MateriaPrimaDAO;

@Resource
public class MateriaPrimaDAOImpl extends BaseDaoImpl implements MateriaPrimaDAO {

	public void altaMateriaPrima(Long matPrima) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(matPrima);

	}

	public void modificarMateria(Long matPrima) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(matPrima);
	}

	public void getMateriaPrima(Long idMateriaPrima) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean existeMateriaPrima(String codigoMateriaPrima) {
		List<Long> materiasPrimas = getHibernateTemplate().find("select m from MateriaPrima m where m.codigoMateriaPrima = " +  "'" + codigoMateriaPrima + "'");

		if(materiasPrimas.size() != 0)
			return true;
		else
			return false;
	}

	@Override
	public List<Long> getMateriasPrimas() {
		// TODO Auto-generated method stub
		List<Long> materiasPrimas= getHibernateTemplate().find("select m from MateriaPrima m");
		if(materiasPrimas.size() != 0)
			return materiasPrimas;
		else
			return null;

	}

//	@Override
//	public List<MateriaPrima> filtrarBusquedaMateriaPrima(List<Object> parametrosBusqueda) {
//		// TODO Auto-generated method stub
//		List<MateriaPrima> materiasPrimas= getHibernateTemplate().find("select m from MateriaPrima m where m.color = " + "'" + parametrosBusqueda.get(0) + "'" + " and m.kilos = " + "'" + parametrosBusqueda.get(1) + "'");
//		if(materiasPrimas.size() != 0)
//			return materiasPrimas;
//		else
//			return null;
//	}

	@Override
	public DataSourceResult getListaMateriaPrima(DataSourceRequest request) {
		return request.toDataSourceResult(getHibernateTemplate().getSessionFactory().getCurrentSession(), MateriaPrima.class);
	}

	public void altaMateriaPrima(TipoMateriaPrima tmp) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(tmp);
	}

	public DataSourceResult getListaTipoMateriaPrima(DataSourceRequest request) {
		// TODO Auto-generated method stub
		return request.toDataSourceResult(getHibernateTemplate().getSessionFactory().getCurrentSession(), TipoMateriaPrima.class);
	}

	public List<TipoMateriaPrima> getTiposMateriaPrima() {
		// TODO Auto-generated method stub
		List<TipoMateriaPrima> tiposMateriaPrima= getHibernateTemplate().find("select t from TipoMateriaPrima t");
		if(tiposMateriaPrima.size() != 0)
			return tiposMateriaPrima;
		else
			return null;
	}

	public List<MateriaPrima> getAllMateriasPrimasByTipo(String tipo) {
		// TODO Auto-generated method stub
		String hql = "select m from MateriaPrima m where m.tipoMateriaPrima.nombre = :tipo";
		Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql);
		query.setParameter("tipo", tipo);
		List<MateriaPrima> materiasPrimas = query.list();
		if(materiasPrimas.size() != 0)
			return materiasPrimas;
		else
			return materiasPrimas;
	}

	public TipoMateriaPrima getTipoMateriaPrimaById(TipoMateriaPrima tipoMateriaPrima) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		String tm = tipoMateriaPrima.name();
		@SuppressWarnings("unchecked")
		List<TipoMateriaPrima> tipoMateriasPrimas = getHibernateTemplate().find("select t from TipoMateriaPrima t where t.id = " + "'" + tm + "'");
		if(tipoMateriasPrimas.size() != 0)
			return tipoMateriasPrimas.get(0);
		else
			return null; 
	}

	public List<Long> getMateriasPrimasByTipo(TipoMateriaPrima tipoMateriaPrima) {

		String tm = tipoMateriaPrima.name();
		List<Long> materiasPrimas = getHibernateTemplate().find("select m from MateriaPrima m where m.tipoMateriaPrima = " + "'" + tm + "'");
			return materiasPrimas;
	}

	public void saveOrUpdate(MateriaPrima mp) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(mp);
	}

	public MateriaPrima getMateriasPrimasById(Long id) {
		// TODO Auto-generated method stub
				List<MateriaPrima> materiasPrimas = getHibernateTemplate().find("select m from MateriaPrima m where m.id = " + id);
				if(materiasPrimas.size() != 0)
					return materiasPrimas.get(0);
				else
					return null; 
	}

	@Override
	public Map<MateriaPrima, Integer> getMateriaPrimaUtilizada(
			String materiaPrima, Date fechaInicio, Date fechaFin) {

		//TODO: cambiar SolicitudProduccion por OrdenProduccion
		
//		select m,
//	       (select count(s.adhesivo.id) from SolicitudProduccion s where s.adhesivo.id = m.id and  s.fechaAlta <= current_timestamp()) 
//	       from MateriaPrima m
		
//			String hql = "select m," + 
//	       " (select count(s.adhesivo.id) from SolicitudProduccion s where s.adhesivo.id = m.id) " +  
//	       " from MateriaPrima m ";
		
	       
	       String hql = "select m,(select count(s."+materiaPrima+".id) from SolicitudProduccion s where s."+materiaPrima+".id = m.id and s.fechaAlta between :fechaInicio and :fechaFin ) as coun from MateriaPrima m, SolicitudProduccion ss  where ss."+materiaPrima+".id = m.id group by m";
	       //and s.fechaAlta between :fechaInicio and :fechaFin
	       Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql);
	       query.setParameter("fechaInicio"	, fechaInicio);
	       query.setParameter("fechaFin"	, fechaFin);
	       
	       List<Object> objects = query.list();
	       
	       Map<MateriaPrima,Integer> map = transformerToMap(objects);
	       
	       return map;
	}


	private Map<MateriaPrima, Integer> transformerToMap(List<Object> objects) {
		
		Map<MateriaPrima,Integer> map = new HashMap<MateriaPrima,Integer>();
		Integer cantidad = 0;
		
		for (Object object : objects) 
		{
			Object[] o = (Object[])object;
			MateriaPrima m = (MateriaPrima)o[0];
			
			cantidad = new Integer( ((Long)o[1]).intValue());
			map.put(m, cantidad);
		}
		
		return map;	
		
	}

	
}
