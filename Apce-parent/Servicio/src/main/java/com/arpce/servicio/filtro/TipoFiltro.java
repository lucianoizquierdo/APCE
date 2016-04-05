package com.arpce.servicio.filtro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TipoFiltro {
	
	protected Map<String,String> operadores = new HashMap<String, String>();
	
	public List<String> getOperadores() 
	{
		return new ArrayList<String>(operadores.keySet());
	}

}
