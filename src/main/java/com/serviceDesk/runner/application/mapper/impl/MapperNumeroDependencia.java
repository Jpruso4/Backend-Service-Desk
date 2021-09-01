package com.serviceDesk.runner.application.mapper.impl;

import org.springframework.stereotype.Service;

import com.serviceDesk.runner.application.entities.NumeroDependencia;
import com.serviceDesk.runner.application.mapper.IMapperNumeroDependencia;
import com.serviceDesk.runner.application.model.NumeroDependenciaModel;

@Service
public class MapperNumeroDependencia implements IMapperNumeroDependencia{

	@Override
	public NumeroDependenciaModel mappearNumeroDependencia(NumeroDependencia numeroDependencia) {
		NumeroDependenciaModel numeroDependenciaModel = new NumeroDependenciaModel();
		numeroDependenciaModel.setIdNumeroDependencia(numeroDependencia.getIdNumeroDependencia());
		numeroDependenciaModel.setNumeroDependencia(numeroDependencia.getNumeroDependencia());
		return numeroDependenciaModel;
	}

}
