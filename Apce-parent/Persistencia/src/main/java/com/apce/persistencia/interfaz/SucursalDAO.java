package com.apce.persistencia.interfaz;

import java.util.List;

import com.apce.modelo.Sucursal;

public interface SucursalDAO {

	public void altaSucursal(Sucursal suc);

	public void bajaSucursal(Sucursal suc);

	public void modificarSurucsal(Sucursal sucursal);

	public List<Sucursal> getSucursales();
	
	public Sucursal getSucursalById(Integer id);


}
