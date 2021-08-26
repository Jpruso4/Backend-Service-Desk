package com.serviceDesk.runner.application.repository;

import java.util.Optional;

import com.serviceDesk.runner.application.entities.TipoIncidente;

public interface ITipoIncidenteRepository {

	public boolean consultarExistenciaTipoIncidente(String nombreTipoIncidente);

	public Optional<TipoIncidente> obtenerDatosTipoIncidente(String nombreTipoIncidente);
}
