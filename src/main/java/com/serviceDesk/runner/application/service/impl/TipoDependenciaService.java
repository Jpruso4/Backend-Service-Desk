package com.serviceDesk.runner.application.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serviceDesk.runner.application.dao.ITipoDependenciaDao;
import com.serviceDesk.runner.application.entities.TipoDependencia;
import com.serviceDesk.runner.application.mapper.IMapperTipoDependencia;
import com.serviceDesk.runner.application.model.Response;
import com.serviceDesk.runner.application.model.TipoDependenciaModel;
import com.serviceDesk.runner.application.service.ITipoDependeciaService;

@Service
public class TipoDependenciaService implements ITipoDependeciaService{

	private final ITipoDependenciaDao iTipoDependenciaDao;
	private final IMapperTipoDependencia iMapperTipoDependencia;
		
	@Autowired
	public TipoDependenciaService(ITipoDependenciaDao iTipoDependenciaDao,
			IMapperTipoDependencia iMapperTipoDependencia) {
		this.iTipoDependenciaDao = iTipoDependenciaDao;
		this.iMapperTipoDependencia = iMapperTipoDependencia;
	}

	@Override
	public Response<List<TipoDependenciaModel>> mostrarListaTiposDeDependencia() {
		List<TipoDependenciaModel> tipoDependencias = new LinkedList<>();
		List<TipoDependencia> tipoDependenciaData = iTipoDependenciaDao.findAll();
		for(TipoDependencia tipoDependencia : tipoDependenciaData) {
			tipoDependencias.add(iMapperTipoDependencia.mappearTipoDependencia(tipoDependencia));
		}
		return new Response<List<TipoDependenciaModel>>(null,null, tipoDependencias);
	}

}
