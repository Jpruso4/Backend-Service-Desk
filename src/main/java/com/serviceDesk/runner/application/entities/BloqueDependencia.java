package com.serviceDesk.runner.application.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the bloque_dependencia database table.
 * 
 */
@Entity
@Table(name="bloque_dependencia")
@NamedQuery(name="BloqueDependencia.findAll", query="SELECT b FROM BloqueDependencia b")
public class BloqueDependencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_bloque_dependencia")
	private int idBloqueDependencia;

	@Column(name="bloque_dependencia")
	private String nombreBloqueDependencia;

	//bi-directional many-to-one association to Maquina
	@OneToMany(mappedBy="bloqueDependencia")
	private List<Maquina> maquinas;

	public BloqueDependencia() {
	}

	public int getIdBloqueDependencia() {
		return this.idBloqueDependencia;
	}

	public void setIdBloqueDependencia(int idBloqueDependencia) {
		this.idBloqueDependencia = idBloqueDependencia;
	}

	public String getNombreBloqueDependenciaa() {
		return this.nombreBloqueDependencia;
	}

	public void setNombreBloqueDependencia(String nombreBloqueDependencia) {
		this.nombreBloqueDependencia = nombreBloqueDependencia;
	}

	public List<Maquina> getMaquinas() {
		return this.maquinas;
	}

	public void setMaquinas(List<Maquina> maquinas) {
		this.maquinas = maquinas;
	}

	public Maquina addMaquina(Maquina maquina) {
		getMaquinas().add(maquina);
		maquina.setBloqueDependencia(this);

		return maquina;
	}

	public Maquina removeMaquina(Maquina maquina) {
		getMaquinas().remove(maquina);
		maquina.setBloqueDependencia(null);

		return maquina;
	}

}