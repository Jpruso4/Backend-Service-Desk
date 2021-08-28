package com.serviceDesk.runner.application.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.serviceDesk.runner.application.business.ITipoDependenciaBusiness;
import com.serviceDesk.runner.application.model.Response;
import com.serviceDesk.runner.application.model.TipoDependenciaModel;
import com.serviceDesk.runner.application.service.ITipoDependeciaService;

public class TipoDependenciaBusiness implements ITipoDependenciaBusiness{
	
	private final ITipoDependeciaService iTipoDependeciaService;

	@Autowired
	public TipoDependenciaBusiness(ITipoDependeciaService iTipoDependeciaService) {
		this.iTipoDependeciaService = iTipoDependeciaService;
	}

	@Override
	public Response<List<TipoDependenciaModel>> mostrarListaTiposDeDependencia() {
		return iTipoDependeciaService.mostrarListaTiposDeDependencia();
	}
	
	
}
