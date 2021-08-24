package com.serviceDesk.runner.application.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MaquinaModel {
	private int idMaquina;
	private TipoDependenciaModel tipoDependencia;
	private String nombreEquipo;
	private int numeroComputador;
	private int numeroDependencia;
	private String bloqueDependencia;
	private String procesador;
	private String ram;
	private String serialCpu;
	private String serialMouse;
	private String serialPantalla;
	private String serialTeclado;
	private String sistemaOperativo;
}
