package com.serviceDesk.runner.application.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_incidentes database table.
 * 
 */
@Entity
@Table(name="tipo_incidentes")
@NamedQuery(name="TipoIncidente.findAll", query="SELECT t FROM TipoIncidente t")
public class TipoIncidente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipo_incidente")
	private int idTipoIncidente;

	@Column(name="nombre_tipo_incidente")
	private String nombreTipoIncidente;

	//bi-directional many-to-one association to Incidente
	@OneToMany(mappedBy="tipoIncidente")
	private List<Incidente> incidentes;

	public TipoIncidente() {
	}

	public int getIdTipoIncidente() {
		return this.idTipoIncidente;
	}

	public void setIdTipoIncidente(int idTipoIncidente) {
		this.idTipoIncidente = idTipoIncidente;
	}

	public String getNombreTipoIncidente() {
		return this.nombreTipoIncidente;
	}

	public void setNombreTipoIncidente(String nombreTipoIncidente) {
		this.nombreTipoIncidente = nombreTipoIncidente;
	}

	public List<Incidente> getIncidentes() {
		return this.incidentes;
	}

	public void setIncidentes(List<Incidente> incidentes) {
		this.incidentes = incidentes;
	}

	public Incidente addIncidente(Incidente incidente) {
		getIncidentes().add(incidente);
		incidente.setTipoIncidente(this);

		return incidente;
	}

	public Incidente removeIncidente(Incidente incidente) {
		getIncidentes().remove(incidente);
		incidente.setTipoIncidente(null);

		return incidente;
	}

}