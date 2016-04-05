package com.apce.web.form;

import java.util.Date;

import com.apce.modelo.Color;
import com.apce.modelo.SolicitudProduccion;

public class OrdenProduccionForm {
	
	private Long id;
	
	private String tiempoEstimado; //estimado en minutos
	
	private Date fechaProcesada;
	
	private Boolean procesada;
	
	private String nombre;
	
	private String descripcion;
	
	private String observaciones;
	
	private Integer cajas;
	
	private Double adhesivoKilos;
	
	private Double pigmentoKilos;
	
	private Double diluyenteLitros;
	
	private Double aditivoKilos;
	
	private Double Tinta1Litros;
	private Double Tinta2Litros;
	private Double Tinta3Litros;
	
	private Long idTinta1;
	private Long idTinta2;
	private Long idTinta3;
	private Color color1;
	private Color color2;
	private Color color3;
	private Long idAdhesivo;
	private Long idPigmento;
	private Long idDiluyente;
	private Long idAditivo;
	private String cantidadRollosLabel;
	
	private SolicitudProduccion solicitudProduccion;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Color getColor1() {
		return color1;
	}
	public void setColor1(Color color1) {
		this.color1 = color1;
	}
	public Color getColor2() {
		return color2;
	}
	public void setColor2(Color color2) {
		this.color2 = color2;
	}
	public Color getColor3() {
		return color3;
	}
	public void setColor3(Color color3) {
		this.color3 = color3;
	}
	public Long getIdTinta1() {
		return idTinta1;
	}
	public void setIdTinta1(Long idTinta1) {
		this.idTinta1 = idTinta1;
	}
	public Long getIdTinta2() {
		return idTinta2;
	}
	public void setIdTinta2(Long idTinta2) {
		this.idTinta2 = idTinta2;
	}
	public Long getIdTinta3() {
		return idTinta3;
	}
	public void setIdTinta3(Long idTinta3) {
		this.idTinta3 = idTinta3;
	}
	public Long getIdAdhesivo() {
		return idAdhesivo;
	}
	public void setIdAdhesivo(Long idAdhesivo) {
		this.idAdhesivo = idAdhesivo;
	}
	public Long getIdPigmento() {
		return idPigmento;
	}
	public void setIdPigmento(Long idPigmento) {
		this.idPigmento = idPigmento;
	}
	public Long getIdDiluyente() {
		return idDiluyente;
	}
	public void setIdDiluyente(Long idDiluyente) {
		this.idDiluyente = idDiluyente;
	}
	public Long getIdAditivo() {
		return idAditivo;
	}
	public void setIdAditivo(Long idAditivo) {
		this.idAditivo = idAditivo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCantidadRollosLabel() {
		return cantidadRollosLabel;
	}
	public void setCantidadRollosLabel(String rolloLabel) {
		this.cantidadRollosLabel = rolloLabel;
	}
	public Integer getCajas() {
		return cajas;
	}
	public void setCajas(Integer cajas) {
		this.cajas = cajas;
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
	public SolicitudProduccion getSolicitudProduccion() {
		return solicitudProduccion;
	}
	public void setSolicitudProduccion(SolicitudProduccion solicitudProduccion) {
		this.solicitudProduccion = solicitudProduccion;
	}
	public Double getTinta3Litros() {
		return Tinta3Litros;
	}
	public void setTinta3Litros(Double tinta3Litros) {
		Tinta3Litros = tinta3Litros;
	}
	public Double getTinta2Litros() {
		return Tinta2Litros;
	}
	public void setTinta2Litros(Double tinta2Litros) {
		Tinta2Litros = tinta2Litros;
	}
	public Double getTinta1Litros() {
		return Tinta1Litros;
	}
	public void setTinta1Litros(Double tinta1Litros) {
		Tinta1Litros = tinta1Litros;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public Boolean getProcesada() {
		return procesada;
	}
	public void setProcesada(Boolean ejecucion) {
		this.procesada = ejecucion;
	}
	public Date getFechaProcesada() {
		return fechaProcesada;
	}
	public void setFechaProcesada(Date fechaEjecucion) {
		this.fechaProcesada = fechaEjecucion;
	}
	public String getTiempoEstimado() {
		return tiempoEstimado;
	}
	public void setTiempoEstimado(String tiempoEstimado) {
		this.tiempoEstimado = tiempoEstimado;
	}
}
