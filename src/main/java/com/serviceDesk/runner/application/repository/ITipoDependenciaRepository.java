package com.serviceDesk.runner.application.repository;

import java.util.Optional;

import com.serviceDesk.runner.application.dao.ITipoDependenciaDao;
import com.serviceDesk.runner.application.entities.TipoDependencia;

public interface ITipoDependenciaRepository {
	public boolean existeTipoDeDependencia(int idTipoDependencia, ITipoDependenciaDao iTipoDependenciaDao);
	public Optional<TipoDependencia> obtenerElTipoDeDependencia(int idTipoDependencia, ITipoDependenciaDao iTipoDependenciaDao);
}