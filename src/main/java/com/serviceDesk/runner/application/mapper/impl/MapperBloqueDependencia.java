package com.serviceDesk.runner.application.mapper.impl;

import org.springframework.stereotype.Service;

import com.serviceDesk.runner.application.entities.BloqueDependencia;
import com.serviceDesk.runner.application.mapper.IMapperBloqueDependencia;
import com.serviceDesk.runner.application.model.BloqueDependenciaModel;

@Service
public class MapperBloqueDependencia implements IMapperBloqueDependencia{

	@Override
	public BloqueDependenciaModel mappearBloqueDependencia(BloqueDependencia bloqueDependencia) {
		BloqueDependenciaModel bloqueDependenciaModel = new BloqueDependenciaModel();
		bloqueDependenciaModel.setIdBloqueDependencia(bloqueDependencia.getIdBloqueDependencia());
		bloqueDependenciaModel.setNombreBloqueDependencia(bloqueDependencia.getNombreBloqueDependenciaa());
		return bloqueDependenciaModel;
	}

}
