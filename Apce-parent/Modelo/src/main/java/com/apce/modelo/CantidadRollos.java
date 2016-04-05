package com.apce.modelo;

import java.util.ArrayList;
import java.util.List;

public enum CantidadRollos {

	r_100("100 rollos"	, 100),
	r_300("300 rollos"	, 300),
	r_500("500 rollos"	, 500),
	r_800("800 rollos"	, 800),
	r_1000("1000 rollos", 1000),
	r_1500("1500 rollos", 1500),
	r_2000("2000 rollos", 2000),
	r_3000("3000 rollos", 3000),
	r_4000("4000 rollos", 4000),
	r_5000("5000 rollos", 5000);
	
	private String label;
	private Integer numero;
	
	private static List<CantidadRollos> rollos;
	
	static
	{
		rollos = new ArrayList<CantidadRollos>();
		
		rollos.add(CantidadRollos.r_100);
		rollos.add(CantidadRollos.r_300);
		rollos.add(CantidadRollos.r_500);
		rollos.add(CantidadRollos.r_800);
		rollos.add(CantidadRollos.r_1000);
		rollos.add(CantidadRollos.r_1500);
		rollos.add(CantidadRollos.r_2000);
		rollos.add(CantidadRollos.r_3000);
		rollos.add(CantidadRollos.r_4000);
		rollos.add(CantidadRollos.r_5000);
	}

	private CantidadRollos(String label, int num) {
		
		this.label = label;
		this.numero = num;
	}
	
	public static List<CantidadRollos> getListCantidadRollos()
	{
		return rollos;
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public static CantidadRollos getRolloByLabel(String label)
	{
		for (CantidadRollos cr : rollos) 
		{
			if(label.equalsIgnoreCase(cr.getLabel()))
				return cr;
		}
		return null;
	}
	
	public static CantidadRollos getRolloByNumero(Integer num)
	{
		for (CantidadRollos cr : rollos) 
		{
			if(num.equals(cr.getNumero()))
				return cr;
		}
		return null;
	}

	public static CantidadRollos getRolloByName(String name) {
		
		for (CantidadRollos cr : rollos) 
		{
			if(name.equalsIgnoreCase(cr.name()))
				return cr;
		}
		return null;
	}
	
}
