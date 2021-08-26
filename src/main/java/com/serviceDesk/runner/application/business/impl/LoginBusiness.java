package com.serviceDesk.runner.application.business.impl;

import com.serviceDesk.runner.application.business.ILoginBusiness;
import com.serviceDesk.runner.application.model.LoginModel;
import com.serviceDesk.runner.application.model.Response;
import com.serviceDesk.runner.application.service.ILoginService;

public class LoginBusiness implements ILoginBusiness{
	
	private final ILoginService iLoginService;
	
	public LoginBusiness(ILoginService iLoginService) {
		this.iLoginService = iLoginService;
	}

	@Override
	public Response<LoginModel> login(LoginModel loginModel) {
		return iLoginService.login(loginModel);
	}

}
