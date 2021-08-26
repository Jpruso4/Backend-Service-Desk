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
	public boolean consultarExistenciaTecnico(String nombreTecnico) {
		Optional<Tecnico> tecnicoData = iTecnicoDao.obtenerTecnicoPorNombre(nombreTecnico);
		if (!tecnicoData.isPresent())
			return false;
		return true;
	}

	@Override
	public Optional<Tecnico> obtenerDatosTecnico(String nombreTecnico) {
		return iTecnicoDao.obtenerTecnicoPorNombre(nombreTecnico);
	}

}
