package com.serviceDesk.runner.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.serviceDesk.runner.application.model.TipoIncidenteModel;
import com.serviceDesk.runner.application.service.ITipoIncidenteService;

public class TipoIncidenteController {

private final ITipoIncidenteService iTipoIncidenteService;
	
	@Autowired
	public TipoIncidenteController(ITipoIncidenteService iTipoIncidenteService) {
		this.iTipoIncidenteService = iTipoIncidenteService;
	}
	
	@GetMapping(value = "")
	@CrossOrigin
	@ResponseStatus(code = HttpStatus.OK)
	public List<TipoIncidenteModel> mostrarTiposDeIncidentes(){
		return iTipoIncidenteService.mostrarListaIncidentes(); 
	}
}
