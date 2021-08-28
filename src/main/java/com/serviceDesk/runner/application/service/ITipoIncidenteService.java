package com.serviceDesk.runner.application.service;

import java.util.List;

import com.serviceDesk.runner.application.model.Response;
import com.serviceDesk.runner.application.model.TipoIncidenteModel;

public interface ITipoIncidenteService {

	Response<List<TipoIncidenteModel>> mostrarListaTiposIncidentes();

}
