package com.serviceDesk.runner.application.business;

import java.util.List;

import com.serviceDesk.runner.application.model.Response;
import com.serviceDesk.runner.application.model.TecnicoModel;

public interface ITecnicoBusiness {

	Response<List<TecnicoModel>> mostrarListaTecnicos();

	Response<TecnicoModel> mostrarTecnico(Integer idTecnico);

	Response<Boolean> registrarTecnico(TecnicoModel datosTecnicoNuevo);

	Response<Boolean> actualizarTecnico(TecnicoModel datosTecnicoModificar);

	Response<Boolean> eliminarTecnico(Integer idTecnico);
}
