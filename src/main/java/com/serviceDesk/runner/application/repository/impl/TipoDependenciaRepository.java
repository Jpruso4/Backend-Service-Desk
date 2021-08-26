package com.serviceDesk.runner.application.repository.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.serviceDesk.runner.application.dao.ITipoDependenciaDao;
import com.serviceDesk.runner.application.entities.TipoDependencia;
import com.serviceDesk.runner.application.repository.ITipoDependenciaRepository;

public class TipoDependenciaRepository implements ITipoDependenciaRepository {
	
	private final ITipoDependenciaDao iTipoDependenciaDao;
	
	@Autowired
	public TipoDependenciaRepository(ITipoDependenciaDao iTipoDependenciaDao) {
		this.iTipoDependenciaDao = iTipoDependenciaDao;
	}
	
	@Override
	public Optional<TipoDependencia> obtenerElTipoDeDependencia(int idTipoDependencia){
		Optional<TipoDependencia> tipoDependenciaEntity = iTipoDependenciaDao.findById(idTipoDependencia);
		return tipoDependenciaEntity;
	}

	@Override
	public boolean existeTipoDeDependencia(int idTipoDependencia) {
		Optional<TipoDependencia> tipoDependenciaEntity = iTipoDependenciaDao.findById(idTipoDependencia);
		if(!tipoDependenciaEntity.isPresent())
			return false;
		return true;
	}

}
