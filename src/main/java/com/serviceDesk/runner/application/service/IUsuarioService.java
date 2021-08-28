package com.serviceDesk.runner.application.service;

import com.serviceDesk.runner.application.entities.Usuario;
import com.serviceDesk.runner.application.model.Response;

public interface IUsuarioService {

	Response<Boolean> registrarUsuario(Usuario registroUsuarioNuevo);

}
