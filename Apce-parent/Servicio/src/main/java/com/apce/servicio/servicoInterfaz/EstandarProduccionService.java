package com.apce.servicio.servicoInterfaz;

import com.apce.modelo.Color;
import com.apce.modelo.EstandarProduccion;
import com.apce.modelo.Film;
import com.apce.modelo.Formato;
import com.apce.modelo.kendo.DataSourceRequest;
import com.apce.modelo.kendo.DataSourceResult;

public interface EstandarProduccionService extends BaseService {
	
	
	public DataSourceResult getListaEstandarProduccion(DataSourceRequest request);
	
	public void saveOrUpdate(EstandarProduccion p);

	public EstandarProduccion getEstandarProduccionById(Long id);

	public EstandarProduccion findEstandarProduccionByUnique(Formato formato1, Formato formato2,Color fondo, Film film, Integer impreso);


}
