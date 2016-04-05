package com.apce.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "estandar_produccion", uniqueConstraints = {
		@UniqueConstraint(columnNames = "formato1"),
		@UniqueConstraint(columnNames = "formato2"),
		@UniqueConstraint(columnNames = "fondo"),
		@UniqueConstraint(columnNames = "film"),
		@UniqueConstraint(columnNames = "impreso")})
public class EstandarProduccion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "estandar_produccion_seq") 
    @SequenceGenerator(name = "estandar_produccion_seq", sequenceName = "estandar_produccion_seq")
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(name="formato1")
	private Formato formato1;
	
	@Enumerated(EnumType.STRING)
	@Column(name="formato2")
	private Formato formato2;
	
	@Enumerated(EnumType.STRING)
	@Column(name="fondo")
	private Color fondo;
	
	@Enumerated(EnumType.STRING)
	@Column(name="film")
	private Film film;
	
	@Column
	private Integer impreso;
	
	@Column
	private Double tintaLitros;
	
	@Column
	private Double adhesivoKilos;
	
	@Column
	private Double pigmentoKilos;
	
	@Column
	private Double diluyenteLitros;
	
	@Column
	private Double aditivoKilos;
	
	@Column(name="fecha_alta")
	private Date fechaAlta;
	
	@Column(name="tiempo_estimado")
	private Integer tiempoEstimado;

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

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
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

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
	public Integer getTiempoEstimado() {
		return tiempoEstimado;
	}

	public void setTiempoEstimado(Integer tiempoEstimado) {
		this.tiempoEstimado = tiempoEstimado;
	}
}
