package com.serviceDesk.runner.application.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IncidenteModel {
	private int idIncidente;
	private Date fecha;
	private UsuarioModel usuario;
	private MaquinaModel maquina;
	private TecnicoModel tecnico;
	private TipoIncidenteModel tipoIncidente;
	private String declaracionCallcenter;
	private String problemaUsuario;
	private String estado;
	private String declaracionTecnico;
	private String declaracionEscalonamiento;
	private Date fechaSolucion;
	private Integer idTecnicoEscalono;
}
