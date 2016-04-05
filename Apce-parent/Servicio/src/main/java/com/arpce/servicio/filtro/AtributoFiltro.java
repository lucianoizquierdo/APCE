package com.arpce.servicio.filtro;

public class AtributoFiltro {
	
	private String id;
	private String nombre;
	private String valor;
	private String operadorValue;
	private TipoFiltro tipoFiltro;
	
	public AtributoFiltro() {
		// TODO Auto-generated constructor stub
	}
	
	public AtributoFiltro(String i, String v, String ov) 
	{
		this.id = i;
		this.valor = v;
		this.operadorValue = ov; 
	}
	
	public AtributoFiltro(String i,String n, TipoFiltro t)
	{
		this.id = i;
		this.nombre = n;
		this.tipoFiltro = t;
	}
	
	
	public String getOperadorValue() {
		return operadorValue;
	}


	public void setOperadorValue(String operadorValue) {
		this.operadorValue = operadorValue;
	}


	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getValor() {
		return nombre;
	}
	public void setValor(String valor) {
		this.nombre = valor;
	}
	public TipoFiltro getTipoFiltro() {
		return tipoFiltro;
	}
	public void setTipoFiltro(TipoFiltro tipoFiltro) {
		this.tipoFiltro = tipoFiltro;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
