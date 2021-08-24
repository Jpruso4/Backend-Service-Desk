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

import com.serviceDesk.runner.application.model.MaquinaModel;
import com.serviceDesk.runner.application.model.Response;
import com.serviceDesk.runner.application.service.IMaquinaService;
import com.serviceDesk.runner.application.util.UrlsControladores;

@RestController
@RequestMapping(UrlsControladores.MAQUINA_CONTROLLER)
public class MaquinaController{
	
	private final IMaquinaService iMaquinaService;
	
	@Autowired
	public MaquinaController(IMaquinaService iMaquinaService) {
		this.iMaquinaService = iMaquinaService;
	}
	
	@GetMapping(value = "")
	@CrossOrigin
	@ResponseStatus(code = HttpStatus.OK)
	public Response<List<MaquinaModel>> mostrarMaquinas(){
		return iMaquinaService.mostrarListaMaquinas();
	}
	
	@GetMapping(value = "/{idMaquina}")
	@CrossOrigin
	@ResponseStatus(code = HttpStatus.OK)
	public Response<MaquinaModel> mostrarMaquina(
			@Valid @NotNull(message = "The value is required") @PathVariable("idMaquina") Integer idMaquina) {
		return iMaquinaService.mostrarMaquina(idMaquina);
	}
	
	@PostMapping(value = "", produces = "application/json", consumes = "application/json")
	@CrossOrigin
	@ResponseStatus(code = HttpStatus.CREATED)
	public Response<MaquinaModel> registrarMaquina(@RequestBody MaquinaModel datosMaquinaNueva) {
		return iMaquinaService.registrarMaquina(datosMaquinaNueva);
	}
	
	@PutMapping(produces = "application/json", consumes = "application/json")
	@CrossOrigin
	@ResponseStatus(code = HttpStatus.OK)
	public Response<MaquinaModel>  actualizarMovimiento(@RequestBody MaquinaModel datosMaquinaModificar) {
		return iMaquinaService.actualizarMaquina(datosMaquinaModificar);
	}

	@DeleteMapping(value = "/{idMaquina}")
	@CrossOrigin
	@ResponseStatus(code = HttpStatus.OK)
	public Response<MaquinaModel> eliminarMaquina(@PathVariable("idMaquina") Integer idMaquina) {
		return iMaquinaService.eliminarMovimiento(idMaquina);
	}
	
	
}
