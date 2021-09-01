package com.serviceDesk.runner.application.repository.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.serviceDesk.runner.application.dao.IBloqueDependenciaDao;
import com.serviceDesk.runner.application.entities.BloqueDependencia;
import com.serviceDesk.runner.application.repository.IBloqueDependenciaRepository;

public class BloqueDependenciaRepository implements IBloqueDependenciaRepository{

	private final IBloqueDependenciaDao iBloqueDependenciaDao;
	
	@Autowired
	public BloqueDependenciaRepository(IBloqueDependenciaDao iBloqueDependenciaDao) {
		this.iBloqueDependenciaDao = iBloqueDependenciaDao;
	}
	
	@Override
	public boolean existeBloqueDeDependencia(int idBloqueDependencia) {
		Optional<BloqueDependencia> bloqueDependenciaData = iBloqueDependenciaDao.findById(idBloqueDependencia);
		if(!bloqueDependenciaData.isPresent())
			return false;
		return true;
	}

	@Override
	public Optional<BloqueDependencia> obtenerElBloqueDeDependencia(int idBloqueDependencia) {
		return iBloqueDependenciaDao.findById(idBloqueDependencia);
	}
	
	@Override
	public boolean existeBloqueDeDependenciaPorNombre(String bloqueDependencia) {
		Optional<BloqueDependencia> bloqueDependenciaData = iBloqueDependenciaDao.buscarPorNombre(bloqueDependencia);
		if(!bloqueDependenciaData.isPresent())
			return false;
		return true;
	}

	@Override
	public Optional<BloqueDependencia> obtenerElBloqueDeDependenciaPorNombre(String bloqueDependencia) {
		return iBloqueDependenciaDao.buscarPorNombre(bloqueDependencia);
	}

}
