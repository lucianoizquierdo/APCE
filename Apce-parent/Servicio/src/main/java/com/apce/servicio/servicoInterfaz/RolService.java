package com.apce.servicio.servicoInterfaz;

import java.util.List;

import com.apce.modelo.Rol;

/**
 * Clase que se encarga de los Roles de la aplicacion
 * @author lizquier
 *
 */
public interface RolService extends BaseService{
	
	public List<Rol> getRoles();

	public Rol getRol(Integer idRol);
	
	
}
