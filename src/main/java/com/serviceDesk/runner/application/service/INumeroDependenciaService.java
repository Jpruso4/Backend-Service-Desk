package com.serviceDesk.runner.application.service;

import java.util.List;

import com.serviceDesk.runner.application.model.NumeroDependenciaModel;
import com.serviceDesk.runner.application.model.Response;

public interface INumeroDependenciaService {

	Response<List<NumeroDependenciaModel>> mostrarListaNumerosDeDependencia();

}
