package com.serviceDesk.runner.application.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.serviceDesk.runner.application.models.LoginModel;
import com.serviceDesk.runner.application.models.ResponseMensajeDto;
import com.serviceDesk.runner.application.service.ILoginService;
import com.serviceDesk.runner.application.util.UrlsControladores;

@RestController
@RequestMapping(UrlsControladores.LOGIN_CONTROLLER)
public class LoginController {
	
	private final ILoginService iLoginService;
	
	@Autowired
	public LoginController(ILoginService iLoginService) {
		this.iLoginService = iLoginService;
	}
	
	@PostMapping(value = "", produces = "application/json", consumes = "application/json")
	@CrossOrigin
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseMensajeDto login (@Valid @RequestBody LoginModel loginModel) {
		return iLoginService.login(loginModel);
	}
}
