package com.serviceDesk.runner.application.repository;

import java.util.Optional;

import com.serviceDesk.runner.application.entities.NumeroDependencia;

public interface INumeroDependenciaRepository {
	public boolean existeNumeroDeDependencia(int idNumeroDependencia);
	
	public Optional<NumeroDependencia> obtenerElNumeroDeDependencia(int idNumeroDependencia);
	
	boolean existeNumeroDeDependenciaPorNombre(String numeroDependencia);
	
	Optional<NumeroDependencia> obtenerElNumeroDeDependenciaPorNombre(String numeroDependencia);
}
