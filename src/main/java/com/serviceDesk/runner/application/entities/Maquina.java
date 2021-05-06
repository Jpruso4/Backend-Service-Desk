package com.serviceDesk.runner.application.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the maquinas database table.
 * 
 */
@Entity
@Table(name="maquinas")
@NamedQuery(name="Maquina.findAll", query="SELECT m FROM Maquina m")
public class Maquina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_maquina")
	private int idMaquina;

	@Column(name="bloque_dependencia")
	private String bloqueDependencia;

	@Column(name="nombre_equipo")
	private String nombreEquipo;

	@Column(name="numero_computador")
	private int numeroComputador;

	@Column(name="numero_dependencia")
	private int numeroDependencia;

	private String procesador;

	private String ram;

	@Column(name="serial_cpu")
	private String serialCpu;

	@Column(name="serial_mouse")
	private String serialMouse;

	@Column(name="serial_pantalla")
	private String serialPantalla;

	@Column(name="serial_teclado")
	private String serialTeclado;

	@Column(name="sistema_operativo")
	private String sistemaOperativo;

	//bi-directional many-to-one association to Incidente
	@OneToMany(mappedBy="maquina")
	private List<Incidente> incidentes;

	//bi-directional many-to-one association to TipoDependencia
	@ManyToOne
	@JoinColumn(name="id_tipo_dependencia")
	private TipoDependencia tipoDependencia;

	public Maquina() {
	}

	public int getIdMaquina() {
		return this.idMaquina;
	}

	public void setIdMaquina(int idMaquina) {
		this.idMaquina = idMaquina;
	}

	public String getBloqueDependencia() {
		return this.bloqueDependencia;
	}

	public void setBloqueDependencia(String bloqueDependencia) {
		this.bloqueDependencia = bloqueDependencia;
	}

	public String getNombreEquipo() {
		return this.nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public int getNumeroComputador() {
		return this.numeroComputador;
	}

	public void setNumeroComputador(int numeroComputador) {
		this.numeroComputador = numeroComputador;
	}

	public int getNumeroDependencia() {
		return this.numeroDependencia;
	}

	public void setNumeroDependencia(int numeroDependencia) {
		this.numeroDependencia = numeroDependencia;
	}

	public String getProcesador() {
		return this.procesador;
	}

	public void setProcesador(String procesador) {
		this.procesador = procesador;
	}

	public String getRam() {
		return this.ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getSerialCpu() {
		return this.serialCpu;
	}

	public void setSerialCpu(String serialCpu) {
		this.serialCpu = serialCpu;
	}

	public String getSerialMouse() {
		return this.serialMouse;
	}

	public void setSerialMouse(String serialMouse) {
		this.serialMouse = serialMouse;
	}

	public String getSerialPantalla() {
		return this.serialPantalla;
	}

	public void setSerialPantalla(String serialPantalla) {
		this.serialPantalla = serialPantalla;
	}

	public String getSerialTeclado() {
		return this.serialTeclado;
	}

	public void setSerialTeclado(String serialTeclado) {
		this.serialTeclado = serialTeclado;
	}

	public String getSistemaOperativo() {
		return this.sistemaOperativo;
	}

	public void setSistemaOperativo(String sistemaOperativo) {
		this.sistemaOperativo = sistemaOperativo;
	}

	public List<Incidente> getIncidentes() {
		return this.incidentes;
	}

	public void setIncidentes(List<Incidente> incidentes) {
		this.incidentes = incidentes;
	}

	public Incidente addIncidente(Incidente incidente) {
		getIncidentes().add(incidente);
		incidente.setMaquina(this);

		return incidente;
	}

	public Incidente removeIncidente(Incidente incidente) {
		getIncidentes().remove(incidente);
		incidente.setMaquina(null);

		return incidente;
	}

	public TipoDependencia getTipoDependencia() {
		return this.tipoDependencia;
	}

	public void setTipoDependencia(TipoDependencia tipoDependencia) {
		this.tipoDependencia = tipoDependencia;
	}

}