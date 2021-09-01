package com.serviceDesk.runner.application.business;

import java.util.List;

import com.serviceDesk.runner.application.model.BloqueDependenciaModel;
import com.serviceDesk.runner.application.model.Response;

public interface IBloqueDependenciaBusiness {

	Response<List<BloqueDependenciaModel>> mostrarListaBloquesDeDependencia();

}
