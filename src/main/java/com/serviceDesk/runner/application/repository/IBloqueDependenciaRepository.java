package com.serviceDesk.runner.application.repository;

import java.util.Optional;

import com.serviceDesk.runner.application.entities.BloqueDependencia;

public interface IBloqueDependenciaRepository {
	public boolean existeBloqueDeDependencia(int idBloqueDependencia);
	
	public Optional<BloqueDependencia> obtenerElBloqueDeDependencia(int idBloqueDependencia);
	
	public boolean existeBloqueDeDependenciaPorNombre(String bloqueDependencia);
	
	public Optional<BloqueDependencia> obtenerElBloqueDeDependenciaPorNombre(String bloqueDependencia);
}
