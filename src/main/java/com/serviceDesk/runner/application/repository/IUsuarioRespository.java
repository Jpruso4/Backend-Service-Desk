package com.serviceDesk.runner.application.repository;

import java.util.Optional;

import com.serviceDesk.runner.application.entities.Usuario;

public interface IUsuarioRespository {

	public boolean consultarExistenciaUsuario(String numeroDocumento);

	public Optional<Usuario> obtenerDatosUsuario(String numeroDocumento);
}
