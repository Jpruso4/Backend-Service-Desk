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

import com.serviceDesk.runner.application.model.IncidenteModel;
import com.serviceDesk.runner.application.model.MaquinaModel;
import com.serviceDesk.runner.application.model.Response;
import com.serviceDesk.runner.application.model.UsuarioModel;
import com.serviceDesk.runner.application.service.impl.IncidenteService;
import com.serviceDesk.runner.application.util.UrlsControladores;

@RestController
@RequestMapping(UrlsControladores.INCIDENTE_CONTROLLER)
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
	
	//Falta metodo para buscar un incidente por id en especifico
//	@GetMapping(value = "/{idIncidente}")
//	@CrossOrigin
//	@ResponseStatus(code = HttpStatus.OK)
//	public IncidenteModel mostrarIncidente(
//			@Valid @NotNull(message = "The value is required") @PathVariable("idIncidente") Integer idIncidente) {
//		return incidenteService.mostrarIncidente(idIncidente);
//	}
	
	//Falta metodo de modificar incidente
	
	//Falta metodo de eliminar un incidente cambiar estado Solucionado / pendiente
	
	@PostMapping(value = "", produces = "application/json", consumes = "application/json")
	@CrossOrigin
	@ResponseStatus(code = HttpStatus.CREATED)
	public Response<IncidenteModel> registrarIncidente(@RequestBody IncidenteModel datosIncidenteNuevo) {
		return incidenteService.registrarIncidente(datosIncidenteNuevo);
	}
	
//	@PostMapping(value = "/validarEquipo", produces = "application/json", consumes = "application/json")
//	@CrossOrigin
//	@ResponseStatus(code = HttpStatus.OK)
//	public MaquinaModel validarMaquina(@RequestBody IncidenteModel datosIncidenteNuevo) {
//		return incidenteService.validarMaquina(datosIncidenteNuevo);
//	}
//	
//	@PostMapping(value = "/validarUsuario", produces = "application/json", consumes = "application/json")
//	@CrossOrigin
//	@ResponseStatus(code = HttpStatus.OK)
//	public UsuarioModel validarUsuario(@RequestBody IncidenteModel datosIncidenteNuevo) {
//		return incidenteService.validarUsuario(datosIncidenteNuevo);
//	}
	
}
