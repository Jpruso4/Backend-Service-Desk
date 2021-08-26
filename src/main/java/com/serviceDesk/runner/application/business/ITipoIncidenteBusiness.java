package com.serviceDesk.runner.application.business;

import java.util.List;

import com.serviceDesk.runner.application.model.Response;
import com.serviceDesk.runner.application.model.TipoIncidenteModel;

public interface ITipoIncidenteBusiness {

	Response<List<TipoIncidenteModel>> mostrarListaIncidentes();

}
