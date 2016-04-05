package com.apce.web.form;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


public class SucursalForm {
	
	private Integer idSucursal;
	
	private String ciudad;
	
	@NotEmpty(message="Indique la provincia")
	private String provincia;
	private String direccion;
	
	@NotEmpty(message="Indique el usuario Gerente")
	private Integer idUsuario;
	
	private Integer telefono;
	
	public Integer getIdSucursal() {
		return idSucursal;
	}
	public void setIdSucursal(Integer idSucursal) {
		this.idSucursal = idSucursal;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idGerenteGeneral) {
		this.idUsuario = idGerenteGeneral;
	}
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
}
