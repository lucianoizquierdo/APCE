package com.apce.modelo;

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
@Table(name="materias_primas", uniqueConstraints = {
	    @UniqueConstraint(columnNames={"codigo_materia_prima"})})
public class MateriaPrima {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "materiasprimas_seq") 
    @SequenceGenerator(name = "materiasprimas_seq", sequenceName = "materiasprimas_seq")
	private Long id;
	
	@Column(name="codigo_materia_prima")
	private String codigoMateriaPrima;
	
	@Enumerated(EnumType.STRING)
	@Column(name="tipo_materia_prima")
	private TipoMateriaPrima tipoMateriaPrima;
	
	@Enumerated(EnumType.STRING)
	@Column(name="color")
	private Color color;
	
	@Column
	private String descripcion;
	
	@Column(name="activa")
	private boolean isActiva;
	
	
	public Long getId()
	{
		return id;
	}
	
	public void setId(Long i)
	{
		this.id = i;
	}
	
	public String getCodigoMateriaPrima() {
		return this.codigoMateriaPrima;
	}
	public void setCodigoMateriaPrima(String codigo_materia_prima) {
		this.codigoMateriaPrima = codigo_materia_prima;
	}
	public TipoMateriaPrima getTipoMateriaPrima() {
		return tipoMateriaPrima;
	}
	public void setTipoMateriaPrima(TipoMateriaPrima tmp) {
		this.tipoMateriaPrima = tmp;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public boolean isActiva() {
		return isActiva;
	}
	public void setActiva(boolean isActiva) {
		this.isActiva = isActiva;
	}
}
