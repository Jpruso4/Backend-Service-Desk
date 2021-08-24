package com.serviceDesk.runner.application.service;

import com.serviceDesk.runner.application.model.LoginModel;
import com.serviceDesk.runner.application.model.Response;

public interface ILoginService {
	public Response<LoginModel> login(LoginModel loginModel);
}
