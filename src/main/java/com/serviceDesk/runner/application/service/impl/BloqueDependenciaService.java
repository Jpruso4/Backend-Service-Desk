package com.serviceDesk.runner.application.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serviceDesk.runner.application.dao.IBloqueDependenciaDao;
import com.serviceDesk.runner.application.entities.BloqueDependencia;
import com.serviceDesk.runner.application.mapper.IMapperBloqueDependencia;
import com.serviceDesk.runner.application.model.BloqueDependenciaModel;
import com.serviceDesk.runner.application.model.Response;
import com.serviceDesk.runner.application.service.IBloqueDependenciaService;

@Service
public class BloqueDependenciaService implements IBloqueDependenciaService{
	
	private final IBloqueDependenciaDao iBloqueDependenciaDao;
	private final IMapperBloqueDependencia iMapperBloqueDependencia;
	
	@Autowired
	public BloqueDependenciaService(IBloqueDependenciaDao iBloqueDependenciaDao, IMapperBloqueDependencia iMapperBloqueDependencia) {
		this.iBloqueDependenciaDao = iBloqueDependenciaDao;
		this.iMapperBloqueDependencia = iMapperBloqueDependencia;
	}

	@Override
	public Response<List<BloqueDependenciaModel>> mostrarListaBloquesDeDependencia() {
		List<BloqueDependenciaModel> bloquesDependencia = new LinkedList<>();
		List<BloqueDependencia> tipoDependenciaData = iBloqueDependenciaDao.findAll();
		for(BloqueDependencia bloqueDependencia : tipoDependenciaData) {
			bloquesDependencia.add(iMapperBloqueDependencia.mappearBloqueDependencia(bloqueDependencia));
		}
		return new Response<List<BloqueDependenciaModel>>(null,null, bloquesDependencia);
	}

}
