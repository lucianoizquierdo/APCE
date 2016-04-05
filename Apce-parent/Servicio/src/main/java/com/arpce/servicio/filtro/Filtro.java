package com.arpce.servicio.filtro;

import java.util.HashSet;
import java.util.Set;

public class Filtro {
	
	public Set<AtributoFiltro> atributos = new HashSet<AtributoFiltro>();

	public Set<AtributoFiltro> getAtributos() {
		return atributos;
	}

	public void setAtributos(Set<AtributoFiltro> atributos) {
		this.atributos = atributos;
	}
	
	

}
