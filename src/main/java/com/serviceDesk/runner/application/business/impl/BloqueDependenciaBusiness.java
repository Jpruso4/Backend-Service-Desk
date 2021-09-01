package com.serviceDesk.runner.application.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.serviceDesk.runner.application.business.IBloqueDependenciaBusiness;
import com.serviceDesk.runner.application.model.BloqueDependenciaModel;
import com.serviceDesk.runner.application.model.Response;
import com.serviceDesk.runner.application.service.IBloqueDependenciaService;

public class BloqueDependenciaBusiness implements IBloqueDependenciaBusiness{
	
	private final IBloqueDependenciaService iBloqueDependenciaService;
	
	@Autowired
	public BloqueDependenciaBusiness(IBloqueDependenciaService iBloqueDependenciaService) {
		this.iBloqueDependenciaService = iBloqueDependenciaService;
	}

	@Override
	public Response<List<BloqueDependenciaModel>> mostrarListaBloquesDeDependencia() {
		return iBloqueDependenciaService.mostrarListaBloquesDeDependencia();
	}

}
