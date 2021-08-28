package com.serviceDesk.runner.application.business;

import java.util.List;

import com.serviceDesk.runner.application.model.Response;
import com.serviceDesk.runner.application.model.TipoDependenciaModel;

public interface ITipoDependenciaBusiness {

	Response<List<TipoDependenciaModel>> mostrarListaTiposDeDependencia();

}
