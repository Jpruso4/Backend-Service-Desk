package com.serviceDesk.runner.application.service;

import java.util.List;

import com.serviceDesk.runner.application.model.BloqueDependenciaModel;
import com.serviceDesk.runner.application.model.Response;

public interface IBloqueDependenciaService {

	Response<List<BloqueDependenciaModel>> mostrarListaBloquesDeDependencia();

}
