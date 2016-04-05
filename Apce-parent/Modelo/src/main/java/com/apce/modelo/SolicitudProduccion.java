package com.apce.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="solicitud_produccion")
public class SolicitudProduccion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "solicitud_produccion_seq") 
    @SequenceGenerator(name = "solicitud_produccion_seq", sequenceName = "solicitud_produccion_seq")
	private Long id;
	
	@Column(name="fecha_alta")
	private Date fechaAlta;
	
	@OneToOne
	@JoinColumn(name="id_usuario", nullable=true)
	private Usuario usuarioAlta;
	
	@Column
	private String nombre;
	
	@Column
	private String descripcion;
	
	@Column
	private String observaciones;
	
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
	private Integer impreso;// numero de colores
	
	@Enumerated(EnumType.STRING)
	@Column(name="caja")
	private Caja caja; 
	
	@Enumerated(EnumType.STRING)
	@Column(name="color1")
	private Color color1;
	
	@Enumerated(EnumType.STRING)
	@Column(name="color2")
	private Color color2;
	
	@Enumerated(EnumType.STRING)
	@Column(name="color3")
	private Color color3;
	
	@ManyToOne
	@JoinColumn(name = "id_tinta1")
	private MateriaPrima tinta1;
	
	@ManyToOne
	@JoinColumn(name = "id_tinta2")
	private MateriaPrima tinta2;
	
	@ManyToOne
	@JoinColumn(name = "id_tinta3")
	private MateriaPrima tinta3;
	
	@ManyToOne
	@JoinColumn(name = "id_adhesivo")
	private MateriaPrima adhesivo;
	
	@ManyToOne
	@JoinColumn(name = "id_pigmento")
	private MateriaPrima pigmento;
	
	@ManyToOne
	@JoinColumn(name = "id_diluyente")
	private MateriaPrima diluyente;
	
	@ManyToOne
	@JoinColumn(name = "id_aditivo")
	private MateriaPrima aditivo;
	
	@Column(name="cantidad_rollos")
	private Integer cantidadRollos; 
	
	@OneToOne
	@JoinColumn(name="id_orden_produccion", nullable=true)
	private OrdenProduccion ordenProduccion;
	
	
	
//	@CollectionOfElements(targetElement = Color.class)
//	@JoinTable(name = "colorxsolicitud_produccion", joinColumns = @JoinColumn(name = "id_solicitud_produccion", columnDefinition = "bigint default 0"))
//	@Column(name = "color", nullable = false, columnDefinition = "bigint default 0")
//	@Enumerated(EnumType.STRING)
//	private List<Color> colores;
	
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
	public Integer getImpreso() {
		return impreso;
	}
	public void setImpreso(Integer impreso) {
		this.impreso = impreso;
	}
//	public List<Color> getColores() {
//		return colores;
//	}
//	public void setColores(List<Color> colores) {
//		this.colores = colores;
//	}
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
	public MateriaPrima getTinta1() {
		return tinta1;
	}
	public void setTinta1(MateriaPrima tinta1) {
		this.tinta1 = tinta1;
	}
	public MateriaPrima getTinta2() {
		return tinta2;
	}
	public void setTinta2(MateriaPrima tinta2) {
		this.tinta2 = tinta2;
	}
	public MateriaPrima getTinta3() {
		return tinta3;
	}
	public void setTinta3(MateriaPrima tinta3) {
		this.tinta3 = tinta3;
	}
	public MateriaPrima getAdhesivo() {
		return adhesivo;
	}
	public void setAdhesivo(MateriaPrima adhesivo) {
		this.adhesivo = adhesivo;
	}
	public MateriaPrima getPigmento() {
		return pigmento;
	}
	public void setPigmento(MateriaPrima pigmento) {
		this.pigmento = pigmento;
	}
	public MateriaPrima getDiluyente() {
		return diluyente;
	}
	public void setDiluyente(MateriaPrima diluyente) {
		this.diluyente = diluyente;
	}
	public MateriaPrima getAditivo() {
		return aditivo;
	}
	public void setAditivo(MateriaPrima aditivo) {
		this.aditivo = aditivo;
	}
	public Integer getCantidadRollos() {
		return cantidadRollos;
	}
	public void setCantidadRollos(Integer cantidadRollos) {
		this.cantidadRollos = cantidadRollos;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

}
