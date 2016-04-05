package com.apce.servicio.servicoInterfaz;

import com.apce.modelo.Cinta;

public interface CintaService extends BaseService{
	
//	public void altaSucursal(Sucursal suc);
//	
//	public void bajaSucursal(Sucursal suc);
//	
//	public void modificarSurucsal(Sucursal sucursal);
//	
//	public List<Sucursal> getSucursales();
//
//	public Sucursal getSucursal(Integer idSucursal);
//
//	public DataSourceResult getLista(DataSourceRequest request);
	
	public void saveOrUpdate(Cinta cin);

}
