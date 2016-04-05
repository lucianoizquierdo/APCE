package com.apce.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;

@Entity
@Table(name="sucursales")
public class Sucursal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "sucursales_seq") 
    @SequenceGenerator(name = "sucursales_seq", sequenceName = "sucursales_seq")
	private Integer idSucursal;
	private String 	ciudad;
	private String 	provincia;
	private String 	direccion;
	
	@ManyToOne
	@JoinColumn(name="gerente_general")
	private Usuario gerenteGeneral;
	private Long telefono;
	@Column(name="activa")
	private boolean isActiva;
	
	
	
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
	
	
	public boolean isActiva() {
		return isActiva;
	}
	public void setActiva(boolean isActiva) {
		this.isActiva = isActiva;
	}
	public Long getTelefono() {
		return telefono;
	}
	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}
	
	public Usuario getGerenteGeneral() {
		return gerenteGeneral;
	}
	public void setGerenteGeneral(Usuario gerenteGeneral) {
		this.gerenteGeneral = gerenteGeneral;
	}
	
	
	
	
}
