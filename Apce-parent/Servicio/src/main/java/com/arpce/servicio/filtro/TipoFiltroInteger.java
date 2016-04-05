package com.arpce.servicio.filtro;

public class TipoFiltroInteger extends TipoFiltro {

	private static TipoFiltroInteger instance = null;

	private TipoFiltroInteger()
	{
		operadores.put("=", "=");
		operadores.put("<", "<");
		operadores.put(">", ">");
		operadores.put("<>","<>");
	}

	public static TipoFiltroInteger getInstance()
	{
		if(instance == null)
			instance = new TipoFiltroInteger();

		return instance;
	}

}
