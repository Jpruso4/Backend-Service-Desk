package com.serviceDesk.runner.application.repository.impl;

import java.util.Optional;

import com.serviceDesk.runner.application.dao.IUsuarioDao;
import com.serviceDesk.runner.application.entities.Usuario;
import com.serviceDesk.runner.application.repository.IUsuarioRespository;

public class UsuarioRepository implements IUsuarioRespository {

	private final IUsuarioDao iUsuarioDao;

	public UsuarioRepository(IUsuarioDao iUsuarioDao) {
		this.iUsuarioDao = iUsuarioDao;
	}

	@Override
	public boolean consultarExistenciaUsuario(String numeroDocumento) {
		Optional<Usuario> usuarioData = iUsuarioDao.obtenerUsuarioDocumento(numeroDocumento);
		if (!usuarioData.isPresent())
			return false;
		return true;
	}

	@Override
	public Optional<Usuario> obtenerDatosUsuario(String numeroDocumento) {
		return iUsuarioDao.obtenerUsuarioDocumento(numeroDocumento);
	}

}
