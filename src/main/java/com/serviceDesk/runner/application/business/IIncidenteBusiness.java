package com.serviceDesk.runner.application.business;

import java.util.List;

import com.serviceDesk.runner.application.model.IncidenteModel;
import com.serviceDesk.runner.application.model.Response;

public interface IIncidenteBusiness {
	
	Response<IncidenteModel> mostrarIncidente(Integer idIncidente);
	
	Response<List<IncidenteModel>> mostrarListaIncidentes();

	Response<Boolean> registrarIncidente(IncidenteModel datosIncidenteNuevo);

	Response<Boolean> actualizarIncidente(IncidenteModel datosIncidenteModificar);

	Response<Boolean> eliminarIncidente(Integer idIncidente);

}
