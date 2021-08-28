package com.serviceDesk.runner.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.serviceDesk.runner.application.business.ITipoDependenciaBusiness;
import com.serviceDesk.runner.application.model.Response;
import com.serviceDesk.runner.application.model.TipoDependenciaModel;
import com.serviceDesk.runner.application.util.UrlsControladores;

@RestController
@RequestMapping(UrlsControladores.TIPO_DEPENDENCIA_CONTROLLER)
public class TipoDependenciaController {
	
	private final ITipoDependenciaBusiness iTipoDependenciaBusiness;
	
	@Autowired
	public TipoDependenciaController(ITipoDependenciaBusiness iTipoDependenciaBusiness) {
		this.iTipoDependenciaBusiness = iTipoDependenciaBusiness;
	}
	
	@GetMapping(value = "")
	@CrossOrigin
	@ResponseStatus(code = HttpStatus.OK)
	public Response<List<TipoDependenciaModel>> mostrarTiposDeDependencia(){
		return iTipoDependenciaBusiness.mostrarListaTiposDeDependencia();
	}

}
