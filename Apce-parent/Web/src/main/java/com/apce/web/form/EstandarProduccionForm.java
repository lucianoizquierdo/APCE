package com.apce.web.form;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import com.apce.modelo.Color;
import com.apce.modelo.Film;
import com.apce.modelo.Formato;

public class EstandarProduccionForm {
	
	private Long id;
	@NotNull
	private Formato formato1;
	@NotNull
	private Formato formato2;
	@NotNull
	private Color fondo;
	@NotNull
	private Integer impreso;//a cuantos colores EJ: 2 colores
	@NotNull
	private Film Film;
	
	
	@NotNull
	@DecimalMin("0.00")
	private Double tintaLitros;
	@NotNull
	@DecimalMin("0.00")
	private Double adhesivoKilos;
	@NotNull
	@DecimalMin("0.00")
	private Double pigmentoKilos;
	@NotNull
	@DecimalMin("0.00")
	private Double diluyenteLitros;
	@NotNull
	@DecimalMin("0.00")
	private Double aditivoKilos;
	
	@NotNull
	private Integer tiempoEstimado; //expresado en minutos 
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Formato getFormato1() {
		return formato1;
	}
	public void setFormato1(Formato formato1) {
		this.formato1 = formato1;
	}
	public Formato getFormato2() {
		return formato2;
	}
	public void setFormato2(Formato formato2) {
		this.formato2 = formato2;
	}
	public Color getFondo() {
		return fondo;
	}
	public void setFondo(Color fondo) {
		this.fondo = fondo;
	}
	public Integer getImpreso() {
		return impreso;
	}
	public void setImpreso(Integer impreso) {
		this.impreso = impreso;
	}
	public Double getTintaLitros() {
		return tintaLitros;
	}
	public void setTintaLitros(Double tintaLitros) {
		this.tintaLitros = tintaLitros;
	}
	public Double getAdhesivoKilos() {
		return adhesivoKilos;
	}
	public void setAdhesivoKilos(Double adhesivoKilos) {
		this.adhesivoKilos = adhesivoKilos;
	}
	public Double getPigmentoKilos() {
		return pigmentoKilos;
	}
	public void setPigmentoKilos(Double pigmentoKilos) {
		this.pigmentoKilos = pigmentoKilos;
	}
	public Double getDiluyenteLitros() {
		return diluyenteLitros;
	}
	public void setDiluyenteLitros(Double diluyenteLitros) {
		this.diluyenteLitros = diluyenteLitros;
	}
	public Double getAditivoKilos() {
		return aditivoKilos;
	}
	public void setAditivoKilos(Double aditivoKilos) {
		this.aditivoKilos = aditivoKilos;
	}
	public Film getFilm() {
		return Film;
	}
	public void setFilm(Film film) {
		Film = film;
	}
	public Integer getTiempoEstimado() {
		return tiempoEstimado;
	}
	public void setTiempoEstimado(Integer tiempoEstimado) {
		this.tiempoEstimado = tiempoEstimado;
	}
}
