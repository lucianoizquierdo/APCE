package com.apce.servicio.servicoInterfaz;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.apce.modelo.MateriaPrima;
import com.apce.modelo.TipoMateriaPrima;
import com.apce.modelo.kendo.DataSourceRequest;
import com.apce.modelo.kendo.DataSourceResult;

public interface MateriaPrimaService extends BaseService {
	
	public void altaMateriaPrima(Long matPrim);
	
	public void bajaMateriaPrima(Long matPrim);
	
	public void modificarMateriaPrima(Long matPrim);

	public boolean existeMateriaPrima(String codigoMateriaPrima);

	public List<Long> getMateriasPrimas();
	
	public DataSourceResult getListaMateriaPrima(DataSourceRequest request);

	public void altaTipoMateriaPrima(TipoMateriaPrima tmp);

	public DataSourceResult getListaTipoMateriaPrima(DataSourceRequest request);

	public List<TipoMateriaPrima> getTiposMateriaPrima();

	public List<MateriaPrima> getAllMateriasPrimasByTipo(String tipo);

	public TipoMateriaPrima getTipoMateriaPrimaById(TipoMateriaPrima tipoMateriaPrima);

	public List<Long> getMateriasPrimasByTipo(TipoMateriaPrima tipoMateriaPrima);

	public void saveOrUpdate(MateriaPrima mp);

	public MateriaPrima getMateriaPrimaById(Long id);
	
	public Map<MateriaPrima,Integer> getMateriaPrimaUtilizada(String materiaPrima,Date fechaInicio, Date fechaFin);

}
