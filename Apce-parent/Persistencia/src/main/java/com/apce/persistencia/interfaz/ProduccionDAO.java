package com.apce.persistencia.interfaz;

import com.apce.modelo.Produccion;
import com.apce.modelo.kendo.DataSourceRequest;
import com.apce.modelo.kendo.DataSourceResult;

public interface ProduccionDAO extends BaseDAO {
	
	
	public void saveOrUptade(Produccion p);
	
	//Kendo
	public DataSourceResult getListaProduccion(DataSourceRequest dsr);

}
