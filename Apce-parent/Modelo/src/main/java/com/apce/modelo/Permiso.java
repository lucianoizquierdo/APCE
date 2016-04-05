package com.apce.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="permisos")
public class Permiso {
	
	@Id
	@GeneratedValue
	private Long id_permiso;
	private String descripcion;
	
	public Long getIdPermiso() {
		return id_permiso;
	}
	public void setIdPermiso(Long id_permiso) {
		this.id_permiso = id_permiso;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
