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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bank.runner.application.dto.RequestMovimientosDto;
import com.serviceDesk.runner.application.models.IncidenteModel;
import com.serviceDesk.runner.application.models.MaquinaModel;
import com.serviceDesk.runner.application.models.ResponseMensajeDto;
import com.serviceDesk.runner.application.service.IMaquinaService;

@RestController
public class MaquinaController{
	
	private final IMaquinaService iMaquinaService;
	
	@Autowired
	public MaquinaController(IMaquinaService iMaquinaService) {
		this.iMaquinaService = iMaquinaService;
	}
	
	@GetMapping(value = "")
	@CrossOrigin
	@ResponseStatus(code = HttpStatus.OK)
	public List<MaquinaModel> mostrarMaquinas(){
		return iMaquinaService.mostrarListaMaquinas();
	}
	
	@GetMapping(value = "/{idMaquina}")
	@CrossOrigin
	@ResponseStatus(code = HttpStatus.OK)
	public MaquinaModel mostrarMaquina(
			@Valid @NotNull(message = "The value is required") @PathVariable("idMaquina") Integer idMaquina) {
		return iMaquinaService.mostrarMaquina(idMaquina);
	}
	
	@PostMapping(value = "", produces = "application/json", consumes = "application/json")
	@CrossOrigin
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseMensajeDto registrarMaquina(@RequestBody MaquinaModel datosMaquinaNueva) {
		return iMaquinaService.registrarMaquina(datosMaquinaNueva);
	}
	
	@PutMapping(produces = "application/json", consumes = "application/json")
	@CrossOrigin
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseMensajeDto actualizarMovimiento(@RequestBody MaquinaModel datosMaquinaModificar) {
		return iMaquinaService.actualizarMaquina(datosMaquinaModificar);
	}

	@DeleteMapping(value = "/{idMaquina}")
	@CrossOrigin
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseMensajeDto eliminarMaquina(@PathVariable("idMaquina") Integer idMaquina) {
		return iMaquinaService.eliminarMovimiento(idMaquina);
	}
	
	
}
