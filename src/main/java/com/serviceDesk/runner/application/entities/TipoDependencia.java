package com.serviceDesk.runner.application.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_dependencia database table.
 * 
 */
@Entity
@Table(name="tipo_dependencia")
@NamedQuery(name="TipoDependencia.findAll", query="SELECT t FROM TipoDependencia t")
public class TipoDependencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipo_dependencia")
	private int idTipoDependencia;

	@Column(name="nombre_dependencia")
	private String nombreDependencia;

	//bi-directional many-to-one association to Maquina
	@OneToMany(mappedBy="tipoDependencia")
	private List<Maquina> maquinas;

	public TipoDependencia() {
	}

	public int getIdTipoDependencia() {
		return this.idTipoDependencia;
	}

	public void setIdTipoDependencia(int idTipoDependencia) {
		this.idTipoDependencia = idTipoDependencia;
	}

	public String getNombreDependencia() {
		return this.nombreDependencia;
	}

	public void setNombreDependencia(String nombreDependencia) {
		this.nombreDependencia = nombreDependencia;
	}

	public List<Maquina> getMaquinas() {
		return this.maquinas;
	}

	public void setMaquinas(List<Maquina> maquinas) {
		this.maquinas = maquinas;
	}

	public Maquina addMaquina(Maquina maquina) {
		getMaquinas().add(maquina);
		maquina.setTipoDependencia(this);

		return maquina;
	}

	public Maquina removeMaquina(Maquina maquina) {
		getMaquinas().remove(maquina);
		maquina.setTipoDependencia(null);

		return maquina;
	}

}