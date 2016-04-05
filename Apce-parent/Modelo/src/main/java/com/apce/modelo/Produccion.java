package com.apce.modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Esta clase va a tener todas las producciones que se hicieron, que vendria a hacer una Orden de procuccion
 * donde se indica que es lo que se va a producir y cuales son las cantidades para la produccion
 * de dicho producto, despues de esta clase voy a dar la opcion de imprimir el "informe o la orden
 * de produccion" y eso saldria impreso y seria llamado ORDEN DE PRODUCCION pero la ORDEN DE PRODUCCION
 * no la voy a manejar como una entidad en la aplicacion.
 * @author lucky
 *
 */

@Entity
@Table(name="produccion")
public class Produccion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "produccion_seq") 
    @SequenceGenerator(name = "produccion_seq", sequenceName = "produccion_seq")
	private Long id;
	
	@Column(name="fecha_alta")
	private Date fechaAlta;
	
	@OneToOne
	@JoinColumn(name="id_cinta", nullable=true)
	private Cinta cinta;
	
	@Transient
	@OneToMany(mappedBy="produccion")
	private List<Material> materiales;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public Cinta getCinta() {
		return cinta;
	}
	public void setCinta(Cinta c) {
		this.cinta = c;
	}
	public List<Material> getMateriales() {
		return materiales;
	}
	public void setMateriales(List<Material> materiales) {
		this.materiales = materiales;
	}

}
