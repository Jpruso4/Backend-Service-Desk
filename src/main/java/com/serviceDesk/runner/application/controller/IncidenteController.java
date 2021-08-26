package com.serviceDesk.runner.application.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.serviceDesk.runner.application.business.IIncidenteBusiness;
import com.serviceDesk.runner.application.model.IncidenteModel;
import com.serviceDesk.runner.application.model.Response;
import com.serviceDesk.runner.application.util.UrlsControladores;

@RestController
@RequestMapping(UrlsControladores.INCIDENTE_CONTROLLER)
public class IncidenteController {

	private final IIncidenteBusiness iIncidenteBusiness;

	@Autowired
	public IncidenteController(IIncidenteBusiness iIncidenteBusiness) {
		this.iIncidenteBusiness = iIncidenteBusiness;
	}
	
	@GetMapping(value = "/{idIncidente}")
	@CrossOrigin
	@ResponseStatus(code = HttpStatus.OK)
	public Response<IncidenteModel> mostrarIncidente(
			@Valid @NotNull(message = "The value is required") @PathVariable("idIncidente") Integer idIncidente) {
		return iIncidenteBusiness.mostrarIncidente(idIncidente);
	}
	
	@GetMapping(value = "")
	@CrossOrigin
	@ResponseStatus(code = HttpStatus.OK)
	public Response<List<IncidenteModel>> mostrarIncidentes(){
		return iIncidenteBusiness.mostrarListaIncidentes();
	}
	
	//TODO:Falta metodo de modificar incidente
	
	//TODO:Falta metodo de eliminar un incidente cambiar estado Solucionado / pendiente
	
	@PostMapping(value = "", produces = "application/json", consumes = "application/json")
	@CrossOrigin
	@ResponseStatus(code = HttpStatus.CREATED)
	public Response<Boolean> registrarIncidente(@RequestBody IncidenteModel datosIncidenteNuevo) {
		return iIncidenteBusiness.registrarIncidente(datosIncidenteNuevo);
	}
	
}
