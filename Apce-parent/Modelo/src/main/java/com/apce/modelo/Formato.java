package com.apce.modelo;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public enum Formato {

	F12MM("12mm", 12, 12L,"MM"),
	F24MM("24mm", 24, 12L, "MM"),
	F48MM("48mm", 48, 12L, "MM"),
	F100MTS("100mts", 100, 100000L, "MTS"),
	F500MTS("500mts", 500, 500000L, "MTS"),
	F1000MTS("1000mts", 1000, 1000000L, "MTS");
	
	private String label;
	private int numero;
	private long milimetros;
	private String unidadMedida;
	
	private static List<Formato> formatos1;
	private static List<Formato> formatos2;
	
	
	
	static
	{
		formatos1 = new ArrayList<Formato>();
		formatos2 = new ArrayList<Formato>();
		
		formatos1.add(Formato.F12MM);
		formatos1.add(Formato.F24MM);
		formatos1.add(Formato.F48MM);
		
		formatos2.add(Formato.F100MTS);
		formatos2.add(Formato.F500MTS);
		formatos2.add(Formato.F1000MTS);
	}

	private Formato(String label, int num, long mm, String uni) {
		
		this.label = label;
		this.numero = num;
		this.milimetros = mm;
		this.unidadMedida = uni;
	}
	
	public static List<Formato> getListFormatos1()
	{
		return formatos1;
	}
	
	public static List<Formato> getListFormatos2()
	{
		return formatos2;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public long getMilimetros() {
		return milimetros;
	}

	public void setMilimetros(long milimetros) {
		this.milimetros = milimetros;
	}

	public String getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

}
