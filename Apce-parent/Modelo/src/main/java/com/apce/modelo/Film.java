package com.apce.modelo;

import java.util.ArrayList;
import java.util.List;

public enum Film {

	_02MM("0,2mm", 0.2, 0.2,"MM"),
	_04MM("0,4mm", 0.4, 0.4, "MM"),
	_09MM("0,9mm", 0.9, 0.9, "MM");

	private String label;
	private Double numero;
	private Double milimetros;
	private String unidadMedida;
	
	private static List<Film> films;
	
	
	
	static
	{
		films = new ArrayList<Film>();
		
		films.add(Film._02MM);
		films.add(Film._04MM);
		films.add(Film._09MM);
	}

	private Film(String label, Double num, Double mm, String uni) {
		
		this.label = label;
		this.numero = num;
		this.milimetros = mm;
		this.unidadMedida = uni;
	}
	
	public static List<Film> getListFilms()
	{
		return films;
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Double getNumero() {
		return numero;
	}

	public void setNumero(Double numero) {
		this.numero = numero;
	}

	public Double getMilimetros() {
		return milimetros;
	}

	public void setMilimetros(Double milimetros) {
		this.milimetros = milimetros;
	}

	public String getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

}
