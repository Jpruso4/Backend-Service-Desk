package com.serviceDesk.runner.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.serviceDesk.runner.application.business.IBloqueDependenciaBusiness;
import com.serviceDesk.runner.application.model.BloqueDependenciaModel;
import com.serviceDesk.runner.application.model.Response;
import com.serviceDesk.runner.application.util.UrlsControladores;

@RestController
@RequestMapping(UrlsControladores.BLOQUE_DEPENDENCIA_CONTROLLER)
public class BloqueDependenciaController {

	private final IBloqueDependenciaBusiness iBloqueDependenciaBusiness;
	
	@Autowired
	public BloqueDependenciaController(IBloqueDependenciaBusiness iBloqueDependenciaBusiness) {
		this.iBloqueDependenciaBusiness = iBloqueDependenciaBusiness;
	}
	
	@GetMapping(value = "")
	@CrossOrigin
	@ResponseStatus(code = HttpStatus.OK)
	public Response<List<BloqueDependenciaModel>> mostrarBloquesDeDependencia(){
		return iBloqueDependenciaBusiness.mostrarListaBloquesDeDependencia();
	}
}
