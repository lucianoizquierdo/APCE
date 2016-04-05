package com.apce.modelo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="perfiles")
public class Perfil {
	
	@Id
	@GeneratedValue
	private Long id_perfil;
	private String descripcion;
	@OneToMany
	@JoinTable(name = "perfil_permiso",
	    		joinColumns = {@JoinColumn(name="id_perfil", unique = true)},inverseJoinColumns = {@JoinColumn(name="id_permiso")}
			  )
    private Set<Permiso> permisos;
	
	public Set<Permiso> getPermisos() {
		return permisos;
	}
	public void setPermisos(Set<Permiso> permisos) {
		this.permisos = permisos;
	}
	public Long getIdPerfil() {
		return id_perfil;
	}
	public void setIdPerfil(Long idPerfil) {
		this.id_perfil = idPerfil;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	

}
