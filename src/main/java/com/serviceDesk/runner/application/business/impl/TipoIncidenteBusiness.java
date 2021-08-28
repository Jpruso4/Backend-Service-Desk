package com.serviceDesk.runner.application.business.impl;

import java.util.List;

import com.serviceDesk.runner.application.business.ITipoIncidenteBusiness;
import com.serviceDesk.runner.application.model.Response;
import com.serviceDesk.runner.application.model.TipoIncidenteModel;
import com.serviceDesk.runner.application.service.ITipoIncidenteService;

public class TipoIncidenteBusiness implements ITipoIncidenteBusiness{

	private final ITipoIncidenteService iTipoIncidenteService;
	
	public TipoIncidenteBusiness(ITipoIncidenteService iTipoIncidenteService) {
		this.iTipoIncidenteService = iTipoIncidenteService;
	}
	
	@Override
	public Response<List<TipoIncidenteModel>> mostrarListaTiposIncidentes() {
		return iTipoIncidenteService.mostrarListaTiposIncidentes();
	}

}
