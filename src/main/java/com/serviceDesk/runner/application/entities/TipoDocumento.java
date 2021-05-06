package com.serviceDesk.runner.application.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_documentos database table.
 * 
 */
@Entity
@Table(name="tipo_documentos")
@NamedQuery(name="TipoDocumento.findAll", query="SELECT t FROM TipoDocumento t")
public class TipoDocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipo_documento")
	private int idTipoDocumento;

	@Column(name="nombre_documento")
	private String nombreDocumento;

	//bi-directional many-to-one association to Tecnico
	@OneToMany(mappedBy="tipoDocumento")
	private List<Tecnico> tecnicos;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="tipoDocumento")
	private List<Usuario> usuarios;

	public TipoDocumento() {
	}

	public int getIdTipoDocumento() {
		return this.idTipoDocumento;
	}

	public void setIdTipoDocumento(int idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public String getNombreDocumento() {
		return this.nombreDocumento;
	}

	public void setNombreDocumento(String nombreDocumento) {
		this.nombreDocumento = nombreDocumento;
	}

	public List<Tecnico> getTecnicos() {
		return this.tecnicos;
	}

	public void setTecnicos(List<Tecnico> tecnicos) {
		this.tecnicos = tecnicos;
	}

	public Tecnico addTecnico(Tecnico tecnico) {
		getTecnicos().add(tecnico);
		tecnico.setTipoDocumento(this);

		return tecnico;
	}

	public Tecnico removeTecnico(Tecnico tecnico) {
		getTecnicos().remove(tecnico);
		tecnico.setTipoDocumento(null);

		return tecnico;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setTipoDocumento(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setTipoDocumento(null);

		return usuario;
	}

}