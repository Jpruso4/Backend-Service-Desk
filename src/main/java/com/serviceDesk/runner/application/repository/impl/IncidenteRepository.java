package com.serviceDesk.runner.application.repository.impl;

import java.util.Optional;

import com.serviceDesk.runner.application.dao.IIncidenteDao;
import com.serviceDesk.runner.application.entities.Incidente;
import com.serviceDesk.runner.application.repository.IIncidenteRepository;

public class IncidenteRepository implements IIncidenteRepository{
	
	private final IIncidenteDao iIncidenteDao;

	public IncidenteRepository(IIncidenteDao iIncidenteDao) {
		this.iIncidenteDao = iIncidenteDao;
	}

	@Override
	public boolean consultarExistenciaIncidente(int idIncidente) {
		Optional<Incidente> incidenteData = iIncidenteDao.findById(idIncidente);
		if(!incidenteData.isPresent())
			return false;
		return true;
	}

	@Override
	public Optional<Incidente> obtenerDatosIncidente(int idIncidente) {
		return iIncidenteDao.findById(idIncidente);
	}

}
