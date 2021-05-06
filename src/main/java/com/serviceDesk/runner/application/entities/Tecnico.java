package com.serviceDesk.runner.application.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tecnicos database table.
 * 
 */
@Entity
@Table(name="tecnicos")
@NamedQuery(name="Tecnico.findAll", query="SELECT t FROM Tecnico t")
public class Tecnico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tecnico")
	private int idTecnico;

	private String apellidos;

	private String celular;

	private String contrasena;

	private String correo;

	private String nombres;

	@Column(name="numero_documento")
	private String numeroDocumento;

	private String telefono;

	//bi-directional many-to-one association to Incidente
	@OneToMany(mappedBy="tecnico")
	private List<Incidente> incidentes;

	//bi-directional many-to-one association to TipoDocumento
	@ManyToOne
	@JoinColumn(name="id_tipo_documento")
	private TipoDocumento tipoDocumento;

	//bi-directional many-to-one association to TipoTecnico
	@ManyToOne
	@JoinColumn(name="id_tipo_tecnico")
	private TipoTecnico tipoTecnico;

	public Tecnico() {
	}

	public int getIdTecnico() {
		return this.idTecnico;
	}

	public void setIdTecnico(int idTecnico) {
		this.idTecnico = idTecnico;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getNumeroDocumento() {
		return this.numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Incidente> getIncidentes() {
		return this.incidentes;
	}

	public void setIncidentes(List<Incidente> incidentes) {
		this.incidentes = incidentes;
	}

	public Incidente addIncidente(Incidente incidente) {
		getIncidentes().add(incidente);
		incidente.setTecnico(this);

		return incidente;
	}

	public Incidente removeIncidente(Incidente incidente) {
		getIncidentes().remove(incidente);
		incidente.setTecnico(null);

		return incidente;
	}

	public TipoDocumento getTipoDocumento() {
		return this.tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public TipoTecnico getTipoTecnico() {
		return this.tipoTecnico;
	}

	public void setTipoTecnico(TipoTecnico tipoTecnico) {
		this.tipoTecnico = tipoTecnico;
	}

}