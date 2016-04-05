package com.apce.persistencia.interfaz;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.apce.modelo.MateriaPrima;
import com.apce.modelo.TipoMateriaPrima;
import com.apce.modelo.kendo.DataSourceRequest;
import com.apce.modelo.kendo.DataSourceResult;

public interface MateriaPrimaDAO extends BaseDAO {
	
	public void altaMateriaPrima(Long matPrima);
	
	
	public void modificarMateria(Long matPrima);
	
	public void getMateriaPrima(Long idMateriaPrima);
	
	public boolean existeMateriaPrima(String codigoMateriaPrima);

	public List<Long> getMateriasPrimas();
	
//	public List<MateriaPrima> filtrarBusquedaMateriaPrima(List<Object> parametrosBusqueda);
	
	public TipoMateriaPrima getTipoMateriaPrimaById(TipoMateriaPrima idTipoMateriaPrima);
	
	//Kendo
	public DataSourceResult getListaMateriaPrima(DataSourceRequest dsr);
	
	public void saveOrUpdate(MateriaPrima mp);
	
	public MateriaPrima getMateriasPrimasById(Long id);
	
	public Map<MateriaPrima,Integer> getMateriaPrimaUtilizada(String materiaPrima,Date fechaInicio, Date fechaFin);

}
