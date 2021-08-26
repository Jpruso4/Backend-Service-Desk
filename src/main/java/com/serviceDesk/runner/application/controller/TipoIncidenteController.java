package com.serviceDesk.runner.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.serviceDesk.runner.application.business.ITipoIncidenteBusiness;
import com.serviceDesk.runner.application.model.Response;
import com.serviceDesk.runner.application.model.TipoIncidenteModel;

public class TipoIncidenteController {
	
	private final ITipoIncidenteBusiness iTipoIncidenteBusiness;
	
	@Autowired
	public TipoIncidenteController(ITipoIncidenteBusiness iTipoIncidenteBusiness) {
		this.iTipoIncidenteBusiness = iTipoIncidenteBusiness;
	}
	
	@GetMapping(value = "")
	@CrossOrigin
	@ResponseStatus(code = HttpStatus.OK)
	public Response<List<TipoIncidenteModel>> mostrarTiposDeIncidentes(){
		return iTipoIncidenteBusiness.mostrarListaIncidentes(); 
	}
}
