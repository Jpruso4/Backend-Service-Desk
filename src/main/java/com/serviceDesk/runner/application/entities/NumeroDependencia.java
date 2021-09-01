package com.serviceDesk.runner.application.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the numero_dependencia database table.
 * 
 */
@Entity
@Table(name="numero_dependencia")
@NamedQuery(name="NumeroDependencia.findAll", query="SELECT n FROM NumeroDependencia n")
public class NumeroDependencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_numero_dependencia")
	private int idNumeroDependencia;

	@Column(name="numero_dependencia")
	private String numeroDependencia;

	//bi-directional many-to-one association to Maquina
	@OneToMany(mappedBy="numeroDependencia")
	private List<Maquina> maquinas;

	public NumeroDependencia() {
	}

	public int getIdNumeroDependencia() {
		return this.idNumeroDependencia;
	}

	public void setIdNumeroDependencia(int idNumeroDependencia) {
		this.idNumeroDependencia = idNumeroDependencia;
	}

	public String getNumeroDependencia() {
		return this.numeroDependencia;
	}

	public void setNumeroDependencia(String numeroDependencia) {
		this.numeroDependencia = numeroDependencia;
	}

	public List<Maquina> getMaquinas() {
		return this.maquinas;
	}

	public void setMaquinas(List<Maquina> maquinas) {
		this.maquinas = maquinas;
	}

	public Maquina addMaquina(Maquina maquina) {
		getMaquinas().add(maquina);
		maquina.setNumeroDependencia(this);

		return maquina;
	}

	public Maquina removeMaquina(Maquina maquina) {
		getMaquinas().remove(maquina);
		maquina.setNumeroDependencia(null);

		return maquina;
	}

}