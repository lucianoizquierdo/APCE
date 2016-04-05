package com.apce.modelo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="roles")
public class Rol {
	
	@Id
	@GeneratedValue
	private Long id_rol;
	private String descripcion;
	
	@Transient
	@OneToMany
	@JoinTable(name = "rol_perfil",
	    		joinColumns = {@JoinColumn(name="id_rol", unique = true)},inverseJoinColumns = {@JoinColumn(name="id_perfil")}
			  )
	private Set<Perfil> perfiles;
	
	
	
	
	
	public Set<Perfil> getPerfiles() {
		return perfiles;
	}

	public void setPerfiles(Set<Perfil> perfiles) {
		this.perfiles = perfiles;
	}

	public Long getIdRol() {
		return id_rol;
	}
	
	public void setIdRol(Long idRol) {
		this.id_rol = idRol;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_rol == null) ? 0 : id_rol.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rol other = (Rol) obj;
		if (id_rol == null) {
			if (other.id_rol != null)
				return false;
		} else if (!id_rol.equals(other.id_rol))
			return false;
		return true;
	}
	

}
