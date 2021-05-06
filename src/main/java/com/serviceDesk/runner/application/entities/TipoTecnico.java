package com.serviceDesk.runner.application.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_tecnicos database table.
 * 
 */
@Entity
@Table(name="tipo_tecnicos")
@NamedQuery(name="TipoTecnico.findAll", query="SELECT t FROM TipoTecnico t")
public class TipoTecnico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipo_tecnico")
	private int idTipoTecnico;

	private String especialidad;

	//bi-directional many-to-one association to Tecnico
	@OneToMany(mappedBy="tipoTecnico")
	private List<Tecnico> tecnicos;

	public TipoTecnico() {
	}

	public int getIdTipoTecnico() {
		return this.idTipoTecnico;
	}

	public void setIdTipoTecnico(int idTipoTecnico) {
		this.idTipoTecnico = idTipoTecnico;
	}

	public String getEspecialidad() {
		return this.especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public List<Tecnico> getTecnicos() {
		return this.tecnicos;
	}

	public void setTecnicos(List<Tecnico> tecnicos) {
		this.tecnicos = tecnicos;
	}

	public Tecnico addTecnico(Tecnico tecnico) {
		getTecnicos().add(tecnico);
		tecnico.setTipoTecnico(this);

		return tecnico;
	}

	public Tecnico removeTecnico(Tecnico tecnico) {
		getTecnicos().remove(tecnico);
		tecnico.setTipoTecnico(null);

		return tecnico;
	}

}