package com.serviceDesk.runner.application.repository.impl;

import java.util.Optional;
import com.serviceDesk.runner.application.dao.ITipoDependenciaDao;
import com.serviceDesk.runner.application.entities.TipoDependencia;
import com.serviceDesk.runner.application.repository.ITipoDependenciaRepository;

public class TipoDependenciaRepository implements ITipoDependenciaRepository {

	@Override
	public Optional<TipoDependencia> obtenerElTipoDeDependencia(int idTipoDependencia, ITipoDependenciaDao iTipoDependenciaDao){
		Optional<TipoDependencia> tipoDependenciaEntity = iTipoDependenciaDao.findById(idTipoDependencia);
		return tipoDependenciaEntity;
	}

	@Override
	public boolean existeTipoDeDependencia(int idTipoDependencia, ITipoDependenciaDao iTipoDependenciaDao) {
		Optional<TipoDependencia> tipoDependenciaEntity = iTipoDependenciaDao.findById(idTipoDependencia);
		if(!tipoDependenciaEntity.isPresent())
			return false;
		return true;
	}

}
