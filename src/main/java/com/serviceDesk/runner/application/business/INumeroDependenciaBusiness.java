package com.serviceDesk.runner.application.business;

import java.util.List;

import com.serviceDesk.runner.application.model.NumeroDependenciaModel;
import com.serviceDesk.runner.application.model.Response;

public interface INumeroDependenciaBusiness {

	Response<List<NumeroDependenciaModel>> mostrarListaNumerosDeDependencia();

}
