package com.apce.modelo;

import java.util.ArrayList;
import java.util.List;

public enum Color {

	BLANCO("Blanco"),
	TRANSPARENTE("Transparente"),
	NEGRO("Negro"),
	ROJO("Rojo"),
	VERDE("Verde"),
	AZUL("Azul"),
	AMARILLO("Amarillo");

	private String label;
	private static List<Color> colores;
	
	static
	{
		colores = new ArrayList<Color>();
		colores.add(BLANCO);
		colores.add(TRANSPARENTE);
		colores.add(NEGRO);
		colores.add(ROJO);
		colores.add(VERDE);
		colores.add(AZUL);
		colores.add(AMARILLO);
	}
	

	private Color(String label) {
		this.label = label;
	}

	public static List<Color> getListColores() {
		return colores;
	}

}
