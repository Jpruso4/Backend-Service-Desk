package com.serviceDesk.runner.application.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.serviceDesk.runner.application.repository.ILoginRepository;
import com.serviceDesk.runner.application.dao.ITecnicoDao;
import com.serviceDesk.runner.application.models.BodyModel;
import com.serviceDesk.runner.application.models.LoginModel;
import com.serviceDesk.runner.application.models.ResponseMensajeDto;
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
	public ResponseMensajeDto login(LoginModel loginModel) {
		boolean flagUser = false;
		boolean flagPassword = false;
		ResponseMensajeDto responseMessage = new ResponseMensajeDto();

		flagUser = iLoginRepository.validarEmailTecnico(loginModel.getEmail(), iTecnicoDao);
		flagPassword = iLoginRepository.validarUsuarioYContraseñaTecnico(loginModel.getEmail(), loginModel.getPassword(),iTecnicoDao);

		if (flagUser && flagPassword) {
			responseMessage.setBody(new BodyModel(true));
		} else {
			if (flagUser) {
				responseMessage.setErrorCode(MensajesErrorLogin.COD_INCORRECT_PASSWORD);
				responseMessage.setErrorMessage(MensajesErrorLogin.MESSAGE_INCORRECT_PASSWORD);
				responseMessage.setBody(new BodyModel(false));
			} else {
				responseMessage.setErrorCode(MensajesErrorLogin.COD_INCORRECT_USER);
				responseMessage.setErrorMessage(MensajesErrorLogin.MESSAGE_INCORRECT_USER);
				responseMessage.setBody(new BodyModel(false));
			}
		}

		return responseMessage;
	}
}
