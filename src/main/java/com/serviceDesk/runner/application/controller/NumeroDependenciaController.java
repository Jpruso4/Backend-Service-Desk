package com.serviceDesk.runner.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.serviceDesk.runner.application.business.INumeroDependenciaBusiness;
import com.serviceDesk.runner.application.model.NumeroDependenciaModel;
import com.serviceDesk.runner.application.model.Response;
import com.serviceDesk.runner.application.util.UrlsControladores;

@RestController
@RequestMapping(UrlsControladores.NUMERO_DEPENDENCIA_CONTROLLER)
public class NumeroDependenciaController {
	
	private final INumeroDependenciaBusiness iNumeroDependenciaBusiness;
	
	@Autowired
	public NumeroDependenciaController(INumeroDependenciaBusiness iNumeroDependenciaBusiness) {
		this.iNumeroDependenciaBusiness = iNumeroDependenciaBusiness;
	}
	
	@GetMapping(value = "")
	@CrossOrigin
	@ResponseStatus(code = HttpStatus.OK)
	public Response<List<NumeroDependenciaModel>> mostrarNumerosDeDependencia(){
		return iNumeroDependenciaBusiness.mostrarListaNumerosDeDependencia();
	}

}
