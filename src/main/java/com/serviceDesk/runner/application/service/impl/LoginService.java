package com.serviceDesk.runner.application.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.serviceDesk.runner.application.repository.ILoginRepository;
import com.serviceDesk.runner.application.dao.ITecnicoDao;
import com.serviceDesk.runner.application.model.LoginModel;
import com.serviceDesk.runner.application.model.Response;
import com.serviceDesk.runner.application.service.ILoginService;
import com.serviceDesk.runner.application.util.MensajesErrorLogin;

@Service
public class LoginService implements ILoginService {

	private final ITecnicoDao iTecnicoDao;
	private final ILoginRepository iLoginRepository;

	@Autowired
	public LoginService(ITecnicoDao iTecnicoDao, ILoginRepository iLoginRepository) {
		this.iTecnicoDao = iTecnicoDao;
		this.iLoginRepository = iLoginRepository;
	}

	@Override
	public Response<LoginModel>login(LoginModel loginModel) {
		boolean flagUser = false;
		boolean flagPassword = false;
		//Response<LoginModel> responseMessage = new Response<LoginModel>();
		
		flagUser = iLoginRepository.validarEmailTecnico(loginModel.getEmail(), iTecnicoDao);
		flagPassword = iLoginRepository.validarUsuarioYContraseñaTecnico(loginModel.getEmail(), loginModel.getPassword(),iTecnicoDao);

		if (flagUser && flagPassword) {
			return new Response<LoginModel>(null,null,loginModel);
		} else {
			if (flagUser) {
				return new Response<LoginModel>(MensajesErrorLogin.COD_INCORRECT_PASSWORD, MensajesErrorLogin.MESSAGE_INCORRECT_PASSWORD, null);
			} else {
				return new Response<LoginModel>(MensajesErrorLogin.COD_INCORRECT_USER, MensajesErrorLogin.MESSAGE_INCORRECT_USER, null);
			}
		}

	}
}
