package com.serviceDesk.runner.application.repository;

import java.util.Optional;

import com.serviceDesk.runner.application.entities.TipoDependencia;

public interface ITipoDependenciaRepository {
	public boolean existeTipoDeDependencia(int idTipoDependencia);
	
	public Optional<TipoDependencia> obtenerElTipoDeDependencia(int idTipoDependencia);
}
