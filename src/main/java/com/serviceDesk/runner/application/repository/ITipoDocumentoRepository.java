package com.serviceDesk.runner.application.repository;

import java.util.Optional;
import com.serviceDesk.runner.application.entities.TipoDocumento;

public interface ITipoDocumentoRepository {

	public boolean consultarExistenciaTipoDocumento(int idTipoDocumento);
	
	public Optional<TipoDocumento> obtenerDatosTipoDocumento(int idTipoDocumento);
}
