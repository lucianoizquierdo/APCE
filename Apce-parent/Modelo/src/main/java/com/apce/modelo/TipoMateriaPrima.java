package com.apce.modelo;

import java.util.ArrayList;
import java.util.List;

public enum TipoMateriaPrima {

	TINTA,
	ADHESIVO,
	PIGMENTO,		
	DILUYENTE,
	ADITIVO,
	FILM;

	private static List<TipoMateriaPrima> tiposMateriaPrima;

	static
	{
		tiposMateriaPrima = new ArrayList<TipoMateriaPrima>();
		
		tiposMateriaPrima.add(TipoMateriaPrima.TINTA);
		tiposMateriaPrima.add(TipoMateriaPrima.ADHESIVO);
		tiposMateriaPrima.add(TipoMateriaPrima.PIGMENTO);
		tiposMateriaPrima.add(TipoMateriaPrima.DILUYENTE);
		tiposMateriaPrima.add(TipoMateriaPrima.ADITIVO);
		tiposMateriaPrima.add(TipoMateriaPrima.FILM);
	}

	
	public static List<TipoMateriaPrima> getListTiposMateriaPrima()
	{
		return tiposMateriaPrima;
	}
}
