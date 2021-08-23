package com.serviceDesk.runner.application.service;

import com.serviceDesk.runner.application.models.LoginModel;
import com.serviceDesk.runner.application.models.ResponseMensajeDto;

public interface ILoginService {
	public ResponseMensajeDto login(LoginModel loginModel);
}
