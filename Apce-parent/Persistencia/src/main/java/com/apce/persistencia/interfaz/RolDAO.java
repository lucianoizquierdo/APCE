package com.apce.persistencia.interfaz;

import java.util.List;

import com.apce.modelo.Rol;


public interface RolDAO extends BaseDAO {
	
	
	public List<Rol> getRoles();

	public Rol getRol(Integer idRol);

}
