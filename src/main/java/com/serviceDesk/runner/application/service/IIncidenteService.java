package com.serviceDesk.runner.application.service;

import java.util.List;

import com.serviceDesk.runner.application.models.IncidenteModel;
import com.serviceDesk.runner.application.models.ResponseMensajeDto;

public interface IIncidenteService {

	List<IncidenteModel> mostrarListaIncidentes();
	
	public ResponseMensajeDto registrarIncidente(IncidenteModel datosIncidenteNuevo);
}
