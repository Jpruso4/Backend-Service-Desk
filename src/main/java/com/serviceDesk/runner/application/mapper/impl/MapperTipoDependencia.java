package com.serviceDesk.runner.application.mapper.impl;

import org.springframework.stereotype.Service;

import com.serviceDesk.runner.application.entities.TipoDependencia;
import com.serviceDesk.runner.application.mapper.IMapperTipoDependencia;
import com.serviceDesk.runner.application.model.TipoDependenciaModel;

@Service
public class MapperTipoDependencia implements IMapperTipoDependencia{

	@Override
	public TipoDependenciaModel mappearTipoDependencia(TipoDependencia tipoDependencia) {
		TipoDependenciaModel tipoDependenciaModel = new TipoDependenciaModel();
		tipoDependenciaModel.setIdTipoDependencia(tipoDependencia.getIdTipoDependencia());
		tipoDependenciaModel.setNombreDependencia(tipoDependencia.getNombreDependencia());
		return tipoDependenciaModel;
	}

}
