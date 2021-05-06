package com.serviceDesk.runner.application.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TecnicoModel {
	private int idTecnico;
	private TipoDocumentoModel tipoDocumento;
	private TipoTecnicoModel tipoTecnico;
	private String numeroDocumento;
	private String nombres;
	private String apellidos;
	private String telefono;
	private String celular;
	private String correo;
	private String contrasena;
}
