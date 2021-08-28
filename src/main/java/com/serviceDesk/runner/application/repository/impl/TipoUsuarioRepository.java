package com.serviceDesk.runner.application.repository.impl;

import java.util.Optional;

import com.serviceDesk.runner.application.dao.ITipoUsuarioDao;
import com.serviceDesk.runner.application.entities.TipoUsuario;
import com.serviceDesk.runner.application.repository.ITipoUsuarioRepository;

public class TipoUsuarioRepository implements ITipoUsuarioRepository{
	
	private final ITipoUsuarioDao iTipoUsuarioDao;
	
	public TipoUsuarioRepository(ITipoUsuarioDao iTipoUsuarioDao) {
		this.iTipoUsuarioDao = iTipoUsuarioDao;
	}

	@Override
	public boolean consultarExistenciaTipoUsuario(int idTipoUsuario) {
		Optional<TipoUsuario> tipoUsuarioData = iTipoUsuarioDao.findById(idTipoUsuario);
		if(!tipoUsuarioData.isPresent())
			return false;
		return true;
	}

	@Override
	public Optional<TipoUsuario> obtenerDatosTipoUsuario(int idTipoUsuario) {
		return iTipoUsuarioDao.findById(idTipoUsuario);
	}

}
