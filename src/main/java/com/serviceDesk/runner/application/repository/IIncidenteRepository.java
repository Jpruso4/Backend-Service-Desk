package com.serviceDesk.runner.application.repository;

import java.util.Optional;

import com.serviceDesk.runner.application.entities.Incidente;

public interface IIncidenteRepository {

	public boolean consultarExistenciaIncidente (int idIncidente);
	
	public Optional<Incidente> obtenerDatosIncidente(int idIncidente);
}
