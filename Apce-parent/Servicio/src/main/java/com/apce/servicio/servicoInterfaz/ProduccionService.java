package com.apce.servicio.servicoInterfaz;

import com.apce.modelo.Produccion;
import com.apce.modelo.kendo.DataSourceRequest;
import com.apce.modelo.kendo.DataSourceResult;

public interface ProduccionService extends BaseService {
	
	
	public DataSourceResult getListaProduccion(DataSourceRequest request);
	
	public void saveOrUpdate(Produccion p);


}
