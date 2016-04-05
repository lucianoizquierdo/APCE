package com.apce.servicio.impl;

import com.apce.servicio.servicoInterfaz.MateriaPrimaService;
import com.apce.servicio.servicoInterfaz.SucursalService;
import com.apce.servicio.servicoInterfaz.UsuarioService;

public class FacadeService{

	private static UsuarioService usuarioService;
	private static MateriaPrimaService materiaPrimaService;
	private static SucursalService sucursalService;
	
	/*private static FacadeService instance = null;
	
	public static FacadeService getInstance()
	{
		if(instance == null)
			instance = new FacadeService(); 
		return instance;
	}
	*/
	
	public void setUsuarioService(UsuarioService u) 
	{
		this.usuarioService = u;
	}

	public static UsuarioService getUsuarioService() 
	{
		return usuarioService;
	}
	
	public static MateriaPrimaService getMateriaPrimaService() 
	{
		return materiaPrimaService;
	}

	public void setMateriaPrimaService(MateriaPrimaService materiaPrimaService) 
	{
		this.materiaPrimaService = materiaPrimaService;
	}
	
	public static SucursalService getSucursalService() 
	{
		return sucursalService;
	}

	public void setSucursalService(SucursalService sucursalService) 
	{
		this.sucursalService = sucursalService;
	}
	

}
