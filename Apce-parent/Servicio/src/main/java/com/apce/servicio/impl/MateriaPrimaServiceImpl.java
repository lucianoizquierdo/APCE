package com.apce.servicio.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apce.modelo.MateriaPrima;
import com.apce.modelo.TipoMateriaPrima;
import com.apce.modelo.kendo.DataSourceRequest;
import com.apce.modelo.kendo.DataSourceResult;
import com.apce.persistencia.hibernate.MateriaPrimaDAOImpl;
import com.apce.persistencia.interfaz.BaseDAO;
import com.apce.servicio.servicoInterfaz.MateriaPrimaService;


@Service
@Transactional
public class MateriaPrimaServiceImpl implements MateriaPrimaService {

	@Inject
	MateriaPrimaDAOImpl materiaPrimaDAO;
	
	@Override
	public void setDao(BaseDAO dao) {
		// TODO Auto-generated method stub
		this.materiaPrimaDAO = (MateriaPrimaDAOImpl)dao;
	}


	@Override
	public void altaMateriaPrima(Long matPrima) {
		// TODO Auto-generated method stub
		materiaPrimaDAO.altaMateriaPrima(matPrima);
	}


	@Override
	public void modificarMateriaPrima(Long matPrima) {
		// TODO Auto-generated method stub
		materiaPrimaDAO.modificarMateria(matPrima);
		
	}

	@Override
	public boolean existeMateriaPrima(String codigoMateriaPrima) {
		// TODO Auto-generated method stub
		return materiaPrimaDAO.existeMateriaPrima(codigoMateriaPrima);
	}


	@Override
	public List<Long> getMateriasPrimas() {
		// TODO Auto-generated method stub
		return materiaPrimaDAO.getMateriasPrimas();
	}

	@Override
	public DataSourceResult getListaMateriaPrima(DataSourceRequest request) {
		// TODO Auto-generated method stub
		return materiaPrimaDAO.getListaMateriaPrima(request);
	}


	@Override
	public void altaTipoMateriaPrima(TipoMateriaPrima tmp) {
		// TODO Auto-generated method stub
		materiaPrimaDAO.altaMateriaPrima(tmp);
	}


	@Override
	public DataSourceResult getListaTipoMateriaPrima(DataSourceRequest request) {
		// TODO Auto-generated method stub
		return materiaPrimaDAO.getListaTipoMateriaPrima(request);
	}


	@Override
	public List<TipoMateriaPrima> getTiposMateriaPrima() {
		// TODO Auto-generated method stub
		return materiaPrimaDAO.getTiposMateriaPrima();
	}


	@Override
	public List<MateriaPrima> getAllMateriasPrimasByTipo(String tipo) {
		// TODO Auto-generated method stub
		return materiaPrimaDAO.getAllMateriasPrimasByTipo(tipo);
	}


	@Override
	public TipoMateriaPrima getTipoMateriaPrimaById(TipoMateriaPrima tipoMateriaPrima) {
		// TODO Auto-generated method stub
		return materiaPrimaDAO.getTipoMateriaPrimaById(tipoMateriaPrima);
	}


	@Override
	public List<Long> getMateriasPrimasByTipo(TipoMateriaPrima tipoMateriaPrima) {
		return materiaPrimaDAO.getMateriasPrimasByTipo(tipoMateriaPrima);
	}


	@Override
	public void saveOrUpdate(MateriaPrima mp) {
		// TODO Auto-generated method stub
		materiaPrimaDAO.saveOrUpdate(mp);
	}


	@Override
	public MateriaPrima getMateriaPrimaById(Long id) {
		// TODO Auto-generated method stub
		return materiaPrimaDAO.getMateriasPrimasById(id);
	}


	@Override
	public void bajaMateriaPrima(Long matPrim) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Map<MateriaPrima, Integer> getMateriaPrimaUtilizada(
			String materiaPrima, Date fechaInicio, Date fechaFin) {

		return materiaPrimaDAO.getMateriaPrimaUtilizada(materiaPrima,fechaInicio,fechaFin);
	}


	

	

}
