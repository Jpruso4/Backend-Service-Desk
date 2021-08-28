package com.serviceDesk.runner.application.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serviceDesk.runner.application.dao.IUsuarioDao;
import com.serviceDesk.runner.application.entities.Usuario;
import com.serviceDesk.runner.application.model.Response;
import com.serviceDesk.runner.application.service.IUsuarioService;

@Service
public class UsuarioService implements IUsuarioService{

	private final IUsuarioDao iUsuarioDao;
	
	@Autowired
	public UsuarioService(IUsuarioDao iUsuarioDao) {
		this.iUsuarioDao = iUsuarioDao;
	}
	
	@Override
	public Response<Boolean> registrarUsuario(Usuario registroUsuarioNuevo) {
		iUsuarioDao.save(registroUsuarioNuevo);
		return new Response<Boolean>(null,null,true);
	}

}
