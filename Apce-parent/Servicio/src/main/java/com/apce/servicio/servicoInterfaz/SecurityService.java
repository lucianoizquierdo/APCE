package com.apce.servicio.servicoInterfaz;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.apce.modelo.Sucursal;
import com.apce.modelo.Usuario;

public interface SecurityService extends BaseService, UserDetailsService   {
	
	List getListControllersAccesibles(Usuario us, Sucursal suc);
	

}
