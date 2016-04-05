package com.apce.web.form;

import org.hibernate.validator.constraints.NotEmpty;

import com.apce.modelo.Color;
import com.apce.modelo.TipoMateriaPrima;


public class MateriaPrimaForm {
	
	private Long id;
	
	@NotEmpty(message="Debe especificar el codigo de materia prima")
	private String codigoMateriaPrima;
	
	private Color color;
	
	private String descripcion;
	
	private boolean activa;
	
	private TipoMateriaPrima tipoMateriaPrima;
	
	public String getCodigoMateriaPrima() {
		return codigoMateriaPrima;
	}
	public void setCodigoMateriaPrima(String codigoMateriaPrima) {
		this.codigoMateriaPrima = codigoMateriaPrima;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public boolean isActiva() {
		return activa;
	}
	public void setActiva(boolean activa) {
		this.activa = activa;
	}
	public TipoMateriaPrima getTipoMateriaPrima() {
		return tipoMateriaPrima;
	}
	public void setTipoMateriaPrima(TipoMateriaPrima tipoMateriaPrima) {
		this.tipoMateriaPrima = tipoMateriaPrima;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
