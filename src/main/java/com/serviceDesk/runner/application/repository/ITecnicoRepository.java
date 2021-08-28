package com.serviceDesk.runner.application.repository;

import java.util.Optional;

import com.serviceDesk.runner.application.entities.Tecnico;

public interface ITecnicoRepository {
	
	public boolean consultarExistenciaTecnico(Integer idTecnico);

	public Optional<Tecnico> obtenerDatosTecnico(Integer idTecnico);
	
	public boolean consultarExistenciaTecnicoPorNombres(String nombreTecnico);

	public Optional<Tecnico> obtenerDatosTecnicoPorNombres(String nombreTecnico);
}
