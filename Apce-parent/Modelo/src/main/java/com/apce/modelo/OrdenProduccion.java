package com.apce.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="orden_produccion")
public class OrdenProduccion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "orden_produccion_seq") 
    @SequenceGenerator(name = "orden_produccion_seq", sequenceName = "orden_produccion_seq")
	private Long id;
	
	@Column(name="fecha_alta")
	private Date fechaAlta;
	
	@Column(name="fecha_procesada")
	private Date fechaProcesada;
	
	@Column(name="procesada")
	private Boolean procesada;
	
	@OneToOne
	@JoinColumn(name="id_usuario", nullable=true)
	private Usuario usuarioAlta;
	
	@Column
	private String nombre;
	
	@Column
	private String descripcion;
	
	@Column
	private String observaciones;
	
	@OneToOne
	@JoinColumn(name="id_solicitud_produccion", nullable=true)
	private SolicitudProduccion solicitudProduccion;
	
	@Column
	private Integer empaque; // Cantidad de cajas utilizadas para esta produccion
	
	@Column(name="tinta1_litros")
	private Double tinta1Litros;
	
	@Column(name="tinta2_litros")
	private Double tinta2Litros;
	
	@Column(name="tinta3_litros")
	private Double tinta3Litros;
	
	@Column(name="adhesivo_kilos")
	private Double adhesivoKilos;
	
	@Column(name="pigmento_kilos")
	private Double pigmentoKilos;
	
	@Column(name="diluyente_litros")
	private Double diluyenteLitros;
	
	@Column(name="aditivo_kilos")
	private Double aditivoKilos;
	
	@Column(name="tiempo_estimado")
	private Integer tiempoEstimado; //estimado en minutos
	
	public SolicitudProduccion getSolicitudProduccion() {
		return solicitudProduccion;
	}
	public void setSolicitudProduccion(SolicitudProduccion solicitudProduccion) {
		this.solicitudProduccion = solicitudProduccion;
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
	public Integer getEmpaque() {
		return empaque;
	}
	public void setEmpaque(Integer empaque) {
		this.empaque = empaque;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		descripcion = descripcion;
	}
	public Usuario getUsuarioAlta() {
		return usuarioAlta;
	}
	public void setUsuarioAlta(Usuario usuarioAlta) {
		this.usuarioAlta = usuarioAlta;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public Double getTinta2Litros() {
		return tinta2Litros;
	}
	public void setTinta2Litros(Double tinta2Litros) {
		this.tinta2Litros = tinta2Litros;
	}
	public Double getTinta3Litros() {
		return tinta3Litros;
	}
	public void setTinta3Litros(Double tinta3Litros) {
		this.tinta3Litros = tinta3Litros;
	}
	public void setTinta1Litros(Double tinta1Litros) {
		this.tinta1Litros = tinta1Litros;
	}
	public Double getTinta1Litros() {
		return this.tinta1Litros = tinta1Litros;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public Date getFechaProcesada() {
		return fechaProcesada;
	}
	public void setFechaProcesada(Date fechaEjecucion) {
		this.fechaProcesada = fechaEjecucion;
	}
	public Boolean getProcesada() {
		return procesada;
	}
	public void setProcesada(Boolean ejecucion) {
		this.procesada = ejecucion;
	}
	public Integer getTiempoEstimado() {
		return tiempoEstimado;
	}
	public void setTiempoEstimado(Integer tiempoEstimado) {
		this.tiempoEstimado = tiempoEstimado;
	}
}
