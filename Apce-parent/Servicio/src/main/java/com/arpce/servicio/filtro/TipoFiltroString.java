package com.arpce.servicio.filtro;

public class TipoFiltroString extends TipoFiltro {
	
	static 
	{
		
	}

	private static TipoFiltroString instance = null;
	
	private TipoFiltroString()
	{
		operadores.put("igual a", "=");
		operadores.put("contiene", "like");
	}
	
	public static TipoFiltroString getInstance()
	{
		if(instance == null)
			instance = new TipoFiltroString();
		
		return instance;
	}
	
}
