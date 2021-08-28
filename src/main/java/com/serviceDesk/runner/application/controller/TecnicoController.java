package com.serviceDesk.runner.application.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.serviceDesk.runner.application.business.ITecnicoBusiness;
import com.serviceDesk.runner.application.model.Response;
import com.serviceDesk.runner.application.model.TecnicoModel;
import com.serviceDesk.runner.application.util.UrlsControladores;

@RestController
@RequestMapping(UrlsControladores.TECNICO_CONTROLLER)
public class TecnicoController {

	private final ITecnicoBusiness iTecnicoBusiness;
	
	@Autowired
	public TecnicoController(ITecnicoBusiness iTecnicoBusiness) {
		this.iTecnicoBusiness = iTecnicoBusiness;
	}
	
	@GetMapping(value = "")
	@CrossOrigin
	@ResponseStatus(code = HttpStatus.OK)
	public Response<List<TecnicoModel>> mostrarListaTecnicos(){
		return iTecnicoBusiness.mostrarListaTecnicos();
	}
	
	@GetMapping(value = "/{idTecnico}")
	@CrossOrigin
	@ResponseStatus(code = HttpStatus.OK)
	public Response<TecnicoModel> mostrarTecnico(
			@Valid @NotNull(message = "The value is required") @PathVariable("idTecnico") Integer idTecnico) {
		return iTecnicoBusiness.mostrarTecnico(idTecnico);
	}
	
	@PostMapping(value = "", produces = "application/json", consumes = "application/json")
	@CrossOrigin
	@ResponseStatus(code = HttpStatus.CREATED)
	public Response<Boolean> registrarTecnico(@RequestBody TecnicoModel datosTecnicoNuevo) {
		return iTecnicoBusiness.registrarTecnico(datosTecnicoNuevo);
	}
	
	@PutMapping(produces = "application/json", consumes = "application/json")
	@CrossOrigin
	@ResponseStatus(code = HttpStatus.OK)
	public Response<Boolean>  actualizarTecnico(@RequestBody TecnicoModel datosTecnicoModificar) {
		return iTecnicoBusiness.actualizarTecnico(datosTecnicoModificar);
	}

	@DeleteMapping(value = "/{idTecnico}")
	@CrossOrigin
	@ResponseStatus(code = HttpStatus.OK)
	public Response<Boolean> eliminarTecnico(@PathVariable("idTecnico") Integer idTecnico) {
		return iTecnicoBusiness.eliminarTecnico(idTecnico);
	}
	
}
