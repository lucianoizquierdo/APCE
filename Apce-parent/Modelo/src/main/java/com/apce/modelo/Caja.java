package com.apce.modelo;

import java.util.ArrayList;
import java.util.List;

public enum Caja {
	
	C_18("C_18","18 rollos por caja",18),
	C_36("C_36","36 rollos por caja",36),
	C_78("C_78","78 rollos por caja",78);
	
	private String nombre;
	private String descripcion;
	private Integer rollosPorCaja;
	
	private static List<Caja> cajas;

	private Caja(String n, String d, Integer r) 
	{
		this.nombre = n;
		this.descripcion = d;
		this.setRollosPorCaja(r);
	}
	
	
	static
	{
		cajas = new ArrayList<Caja>();
		cajas.add(C_18);
		cajas.add(C_36);
		cajas.add(C_78);
	}

	public static List<Caja> getTipoCajas()
	{
		return cajas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getRollosPorCaja() {
		return rollosPorCaja;
	}

	public void setRollosPorCaja(Integer rollosPorCaja) {
		this.rollosPorCaja = rollosPorCaja;
	}
	
}
