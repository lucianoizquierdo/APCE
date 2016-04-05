package com.apce.modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionOfElements;

@Entity
@Table(name="cinta")
public class Cinta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "cinta_seq") 
    @SequenceGenerator(name = "cinta_seq", sequenceName = "cinta_seq")
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name="formato1")
	private Formato formato1;

	@Enumerated(EnumType.STRING)
	@Column(name="formato2")
	private Formato formato2;

	@Column
	private String nombre;
	
	@Column
	private String Descripcion;
	
	@Column
	private Long empaque; //numero de rollos por caja
	
	@Column
	private Long impreso;// numero de colores
	
	@CollectionOfElements(targetElement = Color.class)
	@JoinTable(name = "colorxcinta", joinColumns = @JoinColumn(name = "id_cinta", columnDefinition = "bigint default 0"))
	@Column(name = "color", nullable = false, columnDefinition = "bigint default 0")
	@Enumerated(EnumType.STRING)
	private List<Color> colores;
	
	@Column(name="fecha_alta")
	private Date fechaAlta;
	
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
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
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
	public Long getEmpaque() {
		return empaque;
	}
	public void setEmpaque(Long empaque) {
		this.empaque = empaque;
	}
	public Long getImpreso() {
		return impreso;
	}
	public void setImpreso(Long impreso) {
		this.impreso = impreso;
	}
	public List<Color> getColores() {
		return colores;
	}
	public void setColores(List<Color> colores) {
		this.colores = colores;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
}
