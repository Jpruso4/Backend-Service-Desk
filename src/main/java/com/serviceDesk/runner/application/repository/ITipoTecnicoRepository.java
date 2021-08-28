package com.serviceDesk.runner.application.repository;

import java.util.Optional;

import com.serviceDesk.runner.application.entities.TipoTecnico;

public interface ITipoTecnicoRepository {

	public boolean consultarExistenciaTipoTecnico(int idTipoTecnico);
	
	public Optional<TipoTecnico> obtenerDatosTipoTecnico (int idTipoTecnico);
	
}
