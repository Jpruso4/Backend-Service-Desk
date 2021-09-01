package com.serviceDesk.runner.application.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serviceDesk.runner.application.dao.INumeroDependenciaDao;
import com.serviceDesk.runner.application.entities.NumeroDependencia;
import com.serviceDesk.runner.application.mapper.IMapperNumeroDependencia;
import com.serviceDesk.runner.application.model.NumeroDependenciaModel;
import com.serviceDesk.runner.application.model.Response;
import com.serviceDesk.runner.application.service.INumeroDependenciaService;

@Service
public class NumeroDependenciaService implements INumeroDependenciaService{

	private final INumeroDependenciaDao iNumeroDependenciaDao;
	private final IMapperNumeroDependencia iMapperNumeroDependencia;
	
	@Autowired
	public NumeroDependenciaService(INumeroDependenciaDao iNumeroDependenciaDao, IMapperNumeroDependencia iMapperNumeroDependencia) {
		this.iNumeroDependenciaDao = iNumeroDependenciaDao;
		this.iMapperNumeroDependencia = iMapperNumeroDependencia;
	}
	
	@Override
	public Response<List<NumeroDependenciaModel>> mostrarListaNumerosDeDependencia() {
		List<NumeroDependenciaModel> numerosDependencia = new LinkedList<>();
		List<NumeroDependencia> numerosDependenciaData = iNumeroDependenciaDao.findAll();
		for(NumeroDependencia numeroDependencia : numerosDependenciaData) {
			numerosDependencia.add(iMapperNumeroDependencia.mappearNumeroDependencia(numeroDependencia));
		}
		return new Response<List<NumeroDependenciaModel>>(null,null,numerosDependencia);
	}

}
