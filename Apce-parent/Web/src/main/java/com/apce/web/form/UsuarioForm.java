package com.apce.web.form;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class UsuarioForm {
	
	private Integer 	idUsuario;
	
	@NotEmpty(message="Debe especificar un Nombre")
	private String 		nombre;
	
	@NotEmpty(message="Debe especificar un Apellido")
	private String 		apellido;
	
	@NotEmpty(message="Debe especificar un Alias de usuario")
	private String 		aliasUsuario; 
	
	@NotEmpty(message="Debe indicar su numero de documento")
	private Integer 	dni;
	
	@NotEmpty(message="Debe seleccionar una Sucursal")
	private Integer 	idSucursal;
	
	@NotEmpty(message="Debe indicar su fecha de nacimiento")
	private Date 		fecha_nacimiento;
	private Integer 	telefono;
	private String 		direccion;
	
	@NotEmpty(message="Indique un password porfavor")
	private String 		pass;
	
	@NotEmpty(message="Especificar si el usuario esta ACTIVO")
	private Boolean     activo;
	private List<Integer>   roles;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getAliasUsuario() {
		return aliasUsuario;
	}
	public void setAliasUsuario(String aliasUsuario) {
		this.aliasUsuario = aliasUsuario;
	}
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Integer getIdSucursal() {
		return idSucursal;
	}
	public void setIdSucursal(Integer idSucursal) {
		this.idSucursal = idSucursal;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	public List<Integer> getRoles() { 
		return roles;
	}
	public void setRoles(List<Integer> roles) {
		this.roles = roles;
	}
}
