package com.serviceDesk.runner.application.repository.impl;

import java.util.Optional;

import com.serviceDesk.runner.application.dao.ITipoTecnicoDao;
import com.serviceDesk.runner.application.entities.TipoTecnico;
import com.serviceDesk.runner.application.repository.ITipoTecnicoRepository;

public class TipoTecnicoRepository implements ITipoTecnicoRepository{
	
	private final ITipoTecnicoDao iTipoTecnicoDao;
	
	public TipoTecnicoRepository(ITipoTecnicoDao iTipoTecnicoDao) {
		this.iTipoTecnicoDao = iTipoTecnicoDao;
	}
	@Override
	public boolean consultarExistenciaTipoTecnico(int idTipoTecnico) {
		Optional<TipoTecnico> tipoTecnicoData = iTipoTecnicoDao.findById(idTipoTecnico);
		if(!tipoTecnicoData.isPresent())
			return false;
		return true;
	}

	@Override
	public Optional<TipoTecnico> obtenerDatosTipoTecnico(int idTipoTecnico) {
		return iTipoTecnicoDao.findById(idTipoTecnico);
	}

}
