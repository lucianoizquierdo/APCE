package com.apce.web.form;

import org.hibernate.validator.constraints.NotEmpty;



public class TipoMateriaPrimaForm {
	
	@NotEmpty(message="Debe especificar el nombre del tipo de Materia Prima")
	private String nombre;
	
	private String descripcion;
	
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
}
