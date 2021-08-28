package com.serviceDesk.runner.application.repository.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.serviceDesk.runner.application.dao.ITecnicoDao;
import com.serviceDesk.runner.application.entities.Tecnico;
import com.serviceDesk.runner.application.repository.ITecnicoRepository;

public class TecnicoRepository implements ITecnicoRepository{
	
	private final ITecnicoDao iTecnicoDao;
	
	@Autowired
	public TecnicoRepository(ITecnicoDao iTecnicoDao) {
		this.iTecnicoDao = iTecnicoDao;
	}
	
	@Override
	public boolean consultarExistenciaTecnico(Integer idTecnico) {
		Optional<Tecnico> tecnicoData = iTecnicoDao.findById(idTecnico);
		if (!tecnicoData.isPresent())
			return false;
		return true;
	}

	@Override
	public Optional<Tecnico> obtenerDatosTecnico(Integer idTecnico) {
		return iTecnicoDao.findById(idTecnico);
	}

	@Override
	public boolean consultarExistenciaTecnicoPorNombres(String nombreTecnico) {
		Optional<Tecnico> tecnicoData = iTecnicoDao.obtenerTecnicoPorNombre(nombreTecnico);
		if (!tecnicoData.isPresent())
			return false;
		return true;
	}

	@Override
	public Optional<Tecnico> obtenerDatosTecnicoPorNombres(String nombreTecnico) {
		return iTecnicoDao.obtenerTecnicoPorNombre(nombreTecnico);
	}

}
