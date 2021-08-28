package com.serviceDesk.runner.application.service;

import java.util.List;

import com.serviceDesk.runner.application.entities.Incidente;
import com.serviceDesk.runner.application.model.IncidenteModel;
import com.serviceDesk.runner.application.model.Response;

public interface IIncidenteService {
	
	public Response<IncidenteModel> mostrarIncidente(Integer idIncidente);

	Response<List<IncidenteModel>> mostrarListaIncidentes();
	
	public Response<Boolean> registrarIncidente(Incidente datosIncidenteNuevo);

	public Response<Boolean> actualizarIncidente(Incidente incidenteModificar);

	public Response<Boolean> eliminarIncidente(Integer idIncidente, boolean existeIncidente);
}
