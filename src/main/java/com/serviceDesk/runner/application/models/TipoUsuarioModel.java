package com.serviceDesk.runner.application.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TipoUsuarioModel {
	private int idTipoUsuario;
	private String nombreTipoUsuario;
}
