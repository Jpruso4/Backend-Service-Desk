package com.serviceDesk.runner.application.business;

import com.serviceDesk.runner.application.model.Response;
import com.serviceDesk.runner.application.model.UsuarioModel;

public interface IUsuarioBusiness {

	Response<Boolean> registrarUsuario(UsuarioModel datosUsuarioNuevo);

}
