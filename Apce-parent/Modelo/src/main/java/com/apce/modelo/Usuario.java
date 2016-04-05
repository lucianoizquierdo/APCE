package com.apce.modelo;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonBackReference;

@Entity
@Table(name="usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "usuarios_seq") 
    @SequenceGenerator(name = "usuarios_seq", sequenceName = "usuarios_seq")
	private Long 	idUsuario;
	private String 		nombre;
	private String 		apellido;
	private String 		aliasUsuario; 
	private Long 	dni;
	@ManyToOne
	@JoinColumn(name = "idSucursal")
	@JsonBackReference
	private Sucursal 	sucursal;
	@Transient
	private Date 		fecha_nacimiento;
	private Long 	telefono;
	private String 		direccion;
	private String 		pass;
	@Column(name="activo")
	private Boolean 	activo; 
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "usuario_rol",
	    		joinColumns = {@JoinColumn(name="id_usuario", unique = true)},inverseJoinColumns = {@JoinColumn(name="id_rol")}
			  )
	  private Set<Rol> roles;
	/*
	@OneToOne
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name="idUsuario")
	private Permiso permiso;
	*/

	
	/*
	public Permiso getPermiso() {
		return permiso;
	}
	public void setPermiso(Permiso permiso) {
		this.permiso = permiso;
	}
	*/
	
	
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public Boolean isActivo() {
		return activo;
	}

	public void setActivo(Boolean isActivo) {
		this.activo = isActivo;
	}

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
	public Long getDni() {
		return dni;
	}
	public void setDni(Long dni) {
		this.dni = dni;
	}
	public Date getFecha_nacimiento() {
		return this.fecha_nacimiento;
	}
	public void setFecha_nacimiento(Date f) {
		this.fecha_nacimiento = f;
	}
	public Long getTelefono() {
		return telefono;
	}
	public void setTelefono(Long telefono) {
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
	
	public String getNombreApellido()
	{
		return this.nombre + " " + this.apellido;
	}
	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}
	public Sucursal getSucursal() {
		return this.sucursal;
	}
	public Set<Rol> getRoles() {
		return roles;
	}
	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}
	
}
