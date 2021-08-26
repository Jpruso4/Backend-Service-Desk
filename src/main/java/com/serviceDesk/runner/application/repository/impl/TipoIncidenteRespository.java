package com.serviceDesk.runner.application.repository.impl;

import java.util.Optional;

import com.serviceDesk.runner.application.dao.ITipoIncidenteDao;
import com.serviceDesk.runner.application.entities.TipoIncidente;
import com.serviceDesk.runner.application.repository.ITipoIncidenteRepository;

public class TipoIncidenteRespository implements ITipoIncidenteRepository{
	
	private final ITipoIncidenteDao iTipoIncidenteDao;

	public TipoIncidenteRespository(ITipoIncidenteDao iTipoIncidenteDao) {
		this.iTipoIncidenteDao = iTipoIncidenteDao;
	}

	@Override
	public boolean consultarExistenciaTipoIncidente(String nombreTipoIncidente) {
		Optional<TipoIncidente> tipoIncidenteData = iTipoIncidenteDao.obtenerTipoIncidente(nombreTipoIncidente);
		if(!tipoIncidenteData.isPresent())
			return false;
		return true;
	}

	@Override
	public Optional<TipoIncidente> obtenerDatosTipoIncidente(String nombreTipoIncidente) {
		return iTipoIncidenteDao.obtenerTipoIncidente(nombreTipoIncidente);
	}

}
