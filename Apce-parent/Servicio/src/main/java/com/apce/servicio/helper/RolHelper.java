package com.apce.servicio.helper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.apce.modelo.Rol;
import com.apce.servicio.servicoInterfaz.RolService;


@Service
public class RolHelper {

	@Inject
	RolService rolService;
	
	
	public Set<Rol> getRoles(List<Integer> r)
	{
		Set<Rol> roles = new HashSet<Rol>();
		
		if(r != null)
		{
			for (Integer idRol : r) 
			{
				roles.add(rolService.getRol(idRol));
			}
		}
		return roles;
	}

}
