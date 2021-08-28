package com.serviceDesk.runner.application.repository.impl;

import java.util.Optional;

import com.serviceDesk.runner.application.dao.ITipoDocumentoDao;
import com.serviceDesk.runner.application.entities.TipoDocumento;
import com.serviceDesk.runner.application.repository.ITipoDocumentoRepository;

public class TipoDocumentoRepository implements ITipoDocumentoRepository{
	
	private final ITipoDocumentoDao iTipoDocumentoDao;
	
	public TipoDocumentoRepository(ITipoDocumentoDao iTipoDocumentoDao) {
		this.iTipoDocumentoDao = iTipoDocumentoDao;
	}

	@Override
	public boolean consultarExistenciaTipoDocumento(int idTipoDocumento) {
		Optional<TipoDocumento> tipoDocumentoData = iTipoDocumentoDao.findById(idTipoDocumento);
		if(!tipoDocumentoData.isPresent())
			return false;
		return true;
	}

	@Override
	public Optional<TipoDocumento> obtenerDatosTipoDocumento(int idTipoDocumento) {
		return iTipoDocumentoDao.findById(idTipoDocumento);
	}


}
