package com.serviceDesk.runner.application.service;

import java.util.List;

import com.serviceDesk.runner.application.model.IncidenteModel;
import com.serviceDesk.runner.application.model.Response;

public interface IIncidenteService {

	List<IncidenteModel> mostrarListaIncidentes();
	
	public Response<IncidenteModel> registrarIncidente(IncidenteModel datosIncidenteNuevo);
}
