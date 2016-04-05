package com.apce.modelo;

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
@Table(name="material")
public class Material {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "material_seq") 
    @SequenceGenerator(name = "material_seq", sequenceName = "material_seq")
	private Long id;
	
	@Column
	private Long kilos;
	
	@Column
	private Long litros;
	
	@Column
	private Long cantidad;
	
	@OneToOne
	@JoinColumn(name="id_materia_prima", nullable=true)
	private MateriaPrima materiaPrima;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getKilos() {
		return kilos;
	}
	public void setKilos(Long kilos) {
		this.kilos = kilos;
	}
	public Long getLitros() {
		return litros;
	}
	public void setLitros(Long litros) {
		this.litros = litros;
	}
	public Long getCantidad() {
		return cantidad;
	}
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
	public MateriaPrima getMateriaPrima() {
		return materiaPrima;
	}
	public void setMateriaPrima(MateriaPrima materiaPrima) {
		this.materiaPrima = materiaPrima;
	}
}
