package com.apce.web.form;

import javax.validation.constraints.NotNull;

import com.apce.modelo.Caja;
import com.apce.modelo.Color;
import com.apce.modelo.Film;
import com.apce.modelo.Formato;

public class SolicitudProduccionForm {
	
	private Long id;
	
	private String nombre;
	
	private String descripcion;
	
	private String observaciones;
	
	@NotNull
	private Formato formato1;
	@NotNull
	private Formato formato2;
	@NotNull
	private Color fondo;
	@NotNull
	private Film Film;
	@NotNull
	private Integer impreso;//a cuantos colores EJ: 2 colores
	
	private Caja caja;
	
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
	private String cantidadRollosName;
	
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
	
	public Film getFilm() {
		return Film;
	}
	public void setFilm(Film film) {
		Film = film;
	}
	public Caja getCaja() {
		return caja;
	}
	public void setCaja(Caja caja) {
		this.caja = caja;
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
	public String getCantidadRollosName() {
		return cantidadRollosName;
	}
	public void setCantidadRollosName(String rolloName) {
		this.cantidadRollosName = rolloName;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
}
