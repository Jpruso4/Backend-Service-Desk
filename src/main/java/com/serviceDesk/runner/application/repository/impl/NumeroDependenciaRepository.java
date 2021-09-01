package com.serviceDesk.runner.application.repository.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.serviceDesk.runner.application.dao.INumeroDependenciaDao;
import com.serviceDesk.runner.application.entities.NumeroDependencia;
import com.serviceDesk.runner.application.repository.INumeroDependenciaRepository;

public class NumeroDependenciaRepository implements INumeroDependenciaRepository{
	
	private final INumeroDependenciaDao iNumeroDependenciaDao;
	
	@Autowired
	public NumeroDependenciaRepository(INumeroDependenciaDao iNumeroDependenciaDao) {
		this.iNumeroDependenciaDao = iNumeroDependenciaDao;
	}

	@Override
	public boolean existeNumeroDeDependencia(int idNumeroDependencia) {
		Optional<NumeroDependencia> numeroDependenciaData = iNumeroDependenciaDao.findById(idNumeroDependencia);
		if(!numeroDependenciaData.isPresent())
			return false;
		return true;
	}

	@Override
	public Optional<NumeroDependencia> obtenerElNumeroDeDependencia(int idNumeroDependencia) {
		return iNumeroDependenciaDao.findById(idNumeroDependencia);
	}
	
	@Override
	public boolean existeNumeroDeDependenciaPorNombre(String numeroDependencia) {
		Optional<NumeroDependencia> numeroDependenciaData = iNumeroDependenciaDao.buscarPorNombre(numeroDependencia);
		if(!numeroDependenciaData.isPresent())
			return false;
		return true;
	}

	@Override
	public Optional<NumeroDependencia> obtenerElNumeroDeDependenciaPorNombre(String numeroDependencia) {
		return iNumeroDependenciaDao.buscarPorNombre(numeroDependencia);
	}

}
