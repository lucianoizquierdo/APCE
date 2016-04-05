package com.apce.web.dto;


public class MateriaPrimaDTO implements Comparable<MateriaPrimaDTO> {
	
	private Long id;
	private String codigoMateriaPrima;
	private String descripcion;
	private Integer porcentaje;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodigoMateriaPrima() {
		return codigoMateriaPrima;
	}
	public void setCodigoMateriaPrima(String codigoMateriaPrima) {
		this.codigoMateriaPrima = codigoMateriaPrima;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(Integer porcentaje) {
		this.porcentaje = porcentaje;
	}
//	@Override
//	public int compare(MateriaPrimaDTO o1, MateriaPrimaDTO o2) {
//
//		int porcentaje1 = o1.getPorcentaje();
//		int porcentaje2 = o2.getPorcentaje();
//
//		if (porcentaje1 == porcentaje2)
//			return 0;
//		else if (porcentaje1 > porcentaje2)
//			return -1;
//		else
//			return 1;
//	}
	
	public int compareTo(MateriaPrimaDTO m) {
		 
		int porcentaje = m.getPorcentaje(); 
 
		//ascending order
		//return this.porcentaje - porcentaje;
 
		//descending order
		return porcentaje - this.porcentaje;
 
	}
}
