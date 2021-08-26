package com.serviceDesk.runner.application.repository;

import java.util.Optional;

import com.serviceDesk.runner.application.entities.Tecnico;

public interface ITecnicoRepository {
	
	public boolean consultarExistenciaTecnico(String nombreTecnico);

	public Optional<Tecnico> obtenerDatosTecnico(String nombreTecnico);
}
