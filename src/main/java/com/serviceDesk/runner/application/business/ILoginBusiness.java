package com.serviceDesk.runner.application.business;

import com.serviceDesk.runner.application.model.LoginModel;
import com.serviceDesk.runner.application.model.Response;

public interface ILoginBusiness {

	Response<LoginModel> login(LoginModel loginModel);

}
