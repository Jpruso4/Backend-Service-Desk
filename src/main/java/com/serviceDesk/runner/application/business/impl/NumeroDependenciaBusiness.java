package com.serviceDesk.runner.application.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.serviceDesk.runner.application.business.INumeroDependenciaBusiness;
import com.serviceDesk.runner.application.model.NumeroDependenciaModel;
import com.serviceDesk.runner.application.model.Response;
import com.serviceDesk.runner.application.service.INumeroDependenciaService;

public class NumeroDependenciaBusiness implements INumeroDependenciaBusiness{

	private final INumeroDependenciaService iNumeroDependenciaService;
	
	@Autowired
	public NumeroDependenciaBusiness(INumeroDependenciaService iNumeroDependenciaService) {
		this.iNumeroDependenciaService = iNumeroDependenciaService;
	}
	
	@Override
	public Response<List<NumeroDependenciaModel>> mostrarListaNumerosDeDependencia() {
		return iNumeroDependenciaService.mostrarListaNumerosDeDependencia();
	}

}
