package com.serviceDesk.runner.application.service;

import java.util.List;

import com.serviceDesk.runner.application.model.Response;
import com.serviceDesk.runner.application.model.TipoDependenciaModel;

public interface ITipoDependeciaService {

	Response<List<TipoDependenciaModel>> mostrarListaTiposDeDependencia();

}
