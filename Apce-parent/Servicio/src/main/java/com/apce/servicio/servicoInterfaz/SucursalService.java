package com.apce.servicio.servicoInterfaz;

import java.util.List;

import com.apce.modelo.Sucursal;
import com.apce.modelo.kendo.DataSourceRequest;
import com.apce.modelo.kendo.DataSourceResult;

public interface SucursalService extends BaseService{
	
	public void altaSucursal(Sucursal suc);
	
	public void bajaSucursal(Sucursal suc);
	
	public void modificarSurucsal(Sucursal sucursal);
	
	public List<Sucursal> getSucursales();

	public Sucursal getSucursalById(Integer idSucursal);

	public DataSourceResult getLista(DataSourceRequest request);
	

}
