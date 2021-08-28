package com.serviceDesk.runner.application.repository;

import java.util.Optional;
import com.serviceDesk.runner.application.entities.TipoUsuario;

public interface ITipoUsuarioRepository {

	public boolean consultarExistenciaTipoUsuario(int idTipoUsuario);
	
	public Optional<TipoUsuario> obtenerDatosTipoUsuario(int idTipoUsuario);
}
