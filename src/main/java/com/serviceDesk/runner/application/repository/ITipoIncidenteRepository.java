package com.serviceDesk.runner.application.repository;

import java.util.Optional;

import com.serviceDesk.runner.application.entities.TipoIncidente;

public interface ITipoIncidenteRepository {
	
	public boolean consultarExistenciaTipoIncidente(int idTipoIncidente);

	public Optional<TipoIncidente> obtenerDatosTipoIncidente(int idTipoIncidente);

	public boolean consultarExistenciaTipoIncidentePorNombre(String nombreTipoIncidente);

	public Optional<TipoIncidente> obtenerDatosTipoIncidentePorNombre(String nombreTipoIncidente);
}
