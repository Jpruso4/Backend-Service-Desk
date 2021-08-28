package com.serviceDesk.runner.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.serviceDesk.runner.application.business.IUsuarioBusiness;
import com.serviceDesk.runner.application.model.Response;
import com.serviceDesk.runner.application.model.UsuarioModel;
import com.serviceDesk.runner.application.util.UrlsControladores;

@RestController
@RequestMapping(UrlsControladores.USUARIO_CONTROLLER)
public class UsuarioContoller {
	
	private final IUsuarioBusiness iUsuarioBusiness;
	
	@Autowired
	public UsuarioContoller(IUsuarioBusiness iUsuarioBusiness) {
		this.iUsuarioBusiness = iUsuarioBusiness;
	}
	
	@PostMapping(value = "", produces = "application/json", consumes = "application/json")
	@CrossOrigin
	@ResponseStatus(code = HttpStatus.CREATED)
	public Response<Boolean> registrarUsuario(@RequestBody UsuarioModel datosUsuarioNuevo) {
		return iUsuarioBusiness.registrarUsuario(datosUsuarioNuevo);
	}
}
