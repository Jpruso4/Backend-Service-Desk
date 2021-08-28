package com.serviceDesk.runner.application.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the incidentes database table.
 * 
 */
@Entity
@Table(name="incidentes")
@NamedQuery(name="Incidente.findAll", query="SELECT i FROM Incidente i")
public class Incidente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_incidente")
	private int idIncidente;

	@Lob
	@Column(name="declaracion_callcenter")
	private String declaracionCallcenter;

	@Column(name="declaracion_escalonamiento")
	private String declaracionEscalonamiento;

	@Lob
	@Column(name="declaracion_tecnico")
	private String declaracionTecnico;
	
	private int estado;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_solucion")
	private Date fechaSolucion;

	@Column(name="id_tecnico_escalono")
	private Integer idTecnicoEscalono;

	@Lob
	@Column(name="problema_usuario")
	private String problemaUsuario;

	//bi-directional many-to-one association to Maquina
	@ManyToOne
	@JoinColumn(name="id_maquina")
	private Maquina maquina;

	//bi-directional many-to-one association to Tecnico
	@ManyToOne
	@JoinColumn(name="id_tecnico")
	private Tecnico tecnico;

	//bi-directional many-to-one association to TipoIncidente
	@ManyToOne
	@JoinColumn(name="id_tipo_incidente")
	private TipoIncidente tipoIncidente;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	public Incidente() {
	}

	public int getIdIncidente() {
		return this.idIncidente;
	}

	public void setIdIncidente(int idIncidente) {
		this.idIncidente = idIncidente;
	}

	public String getDeclaracionCallcenter() {
		return this.declaracionCallcenter;
	}

	public void setDeclaracionCallcenter(String declaracionCallcenter) {
		this.declaracionCallcenter = declaracionCallcenter;
	}

	public String getDeclaracionEscalonamiento() {
		return this.declaracionEscalonamiento;
	}

	public void setDeclaracionEscalonamiento(String declaracionEscalonamiento) {
		this.declaracionEscalonamiento = declaracionEscalonamiento;
	}

	public String getDeclaracionTecnico() {
		return this.declaracionTecnico;
	}

	public void setDeclaracionTecnico(String declaracionTecnico) {
		this.declaracionTecnico = declaracionTecnico;
	}

	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFechaSolucion() {
		return this.fechaSolucion;
	}

	public void setFechaSolucion(Date fechaSolucion) {
		this.fechaSolucion = fechaSolucion;
	}


	public Integer getIdTecnicoEscalono() {
		return this.idTecnicoEscalono;
	}

	public void setIdTecnicoEscalono(Integer idTecnicoEscalono) {
		this.idTecnicoEscalono = idTecnicoEscalono;
	}

	public String getProblemaUsuario() {
		return this.problemaUsuario;
	}

	public void setProblemaUsuario(String problemaUsuario) {
		this.problemaUsuario = problemaUsuario;
	}

	public Maquina getMaquina() {
		return this.maquina;
	}

	public void setMaquina(Maquina maquina) {
		this.maquina = maquina;
	}

	public Tecnico getTecnico() {
		return this.tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public TipoIncidente getTipoIncidente() {
		return this.tipoIncidente;
	}

	public void setTipoIncidente(TipoIncidente tipoIncidente) {
		this.tipoIncidente = tipoIncidente;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}