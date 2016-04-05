package com.arpce.servicio.filtro;

import java.util.List;


public class FiltroMateriaPrima extends Filtro {
	
	private static FiltroMateriaPrima instance = null;
	
	public static final String ID_COLOR = "color";
	public static final String ID_KILOS = "kilos";
	public static final String ID_CODIGO_MATERIA_PRIMA = "codigoMateriaPrima";
	public static final String ID_TIPO = "tipo";
	public static final String ID_TAMANIO = "tamanio";
	public static final String ID_DESCRIPCION = "descripcion";
	public static final String ID_LISTROS = "litros";
	public static final String ID_ACTIVA = "activa";
	
	
	private FiltroMateriaPrima()
	{
		atributos.add(new AtributoFiltro("color","Color",TipoFiltroString.getInstance()));
		atributos.add(new AtributoFiltro("kilos","Kilos",TipoFiltroInteger.getInstance()));
	};
	
	public static FiltroMateriaPrima getInstance()
	{
		if(instance == null)
			instance = new FiltroMateriaPrima();
		
		return instance;
	}
}
