package com.serviceDesk.runner.application.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NumeroDependenciaModel {
	private int idNumeroDependencia;
	private String numeroDependencia;
}
