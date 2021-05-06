 	package com.serviceDesk.runner.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.serviceDesk.runner.application.models.IncidenteModel;
import com.serviceDesk.runner.application.models.MaquinaModel;
import com.serviceDesk.runner.application.models.ResponseMensajeDto;
import com.serviceDesk.runner.application.models.UsuarioModel;
import com.serviceDesk.runner.application.service.impl.IncidenteService;
import com.serviceDesk.runner.application.util.Constantes;

@RestController
@RequestMapping(Constantes.INCIDENTE_CONTROLLER)
public class IncidenteController {

	private final IncidenteService incidenteService;

	@Autowired
	public IncidenteController(IncidenteService incidenteService) {
		this.incidenteService = incidenteService;
	}
	
	@GetMapping(value = "")
	@CrossOrigin
	@ResponseStatus(code = HttpStatus.OK)
	public List<IncidenteModel> mostrarIncidentes(){
		return incidenteService.mostrarListaIncidentes();
	}
	
	@PostMapping(value = "", produces = "application/json", consumes = "application/json")
	@CrossOrigin
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseMensajeDto registrarIncidente(@RequestBody IncidenteModel datosIncidenteNuevo) {
		return incidenteService.registrarIncidente(datosIncidenteNuevo);
	}
	
	@PostMapping(value = "/validarEquipo", produces = "application/json", consumes = "application/json")
	@CrossOrigin
	@ResponseStatus(code = HttpStatus.OK)
	public MaquinaModel validarMaquina(@RequestBody IncidenteModel datosIncidenteNuevo) {
		return incidenteService.validarMaquina(datosIncidenteNuevo);
	}
	
	@PostMapping(value = "/validarUsuario", produces = "application/json", consumes = "application/json")
	@CrossOrigin
	@ResponseStatus(code = HttpStatus.OK)
	public UsuarioModel validarUsuario(@RequestBody IncidenteModel datosIncidenteNuevo) {
		return incidenteService.validarUsuario(datosIncidenteNuevo);
	}
	
}
