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

import com.serviceDesk.runner.application.business.ILoginBusiness;
import com.serviceDesk.runner.application.model.LoginModel;
import com.serviceDesk.runner.application.model.Response;
import com.serviceDesk.runner.application.service.ILoginService;
import com.serviceDesk.runner.application.util.UrlsControladores;

@RestController
@RequestMapping(UrlsControladores.LOGIN_CONTROLLER)
public class LoginController {
	
	private final ILoginBusiness iLoginBusiness;
	
	@Autowired
	public LoginController(ILoginService iLoginService, ILoginBusiness iLoginBusiness) {
		this.iLoginBusiness = iLoginBusiness;
	}
	
	@PostMapping(value = "", produces = "application/json", consumes = "application/json")
	@CrossOrigin
	@ResponseStatus(code = HttpStatus.OK)
	//TODO:Cambiar el retorno del login, que no sea de Modelo login sino del modelo Usuario, mostrando la info del usuario
	public Response<LoginModel> login (@Valid @RequestBody LoginModel loginModel) {
		return iLoginBusiness.login(loginModel);
	}
}
