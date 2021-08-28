package com.serviceDesk.runner.application.service;

import java.util.List;

import com.serviceDesk.runner.application.entities.Tecnico;
import com.serviceDesk.runner.application.model.Response;
import com.serviceDesk.runner.application.model.TecnicoModel;

public interface ITecnicoService {

	Response<List<TecnicoModel>> mostrarListaTecnicos();

	Response<TecnicoModel> mostrarTecnico(Integer idTecnico);

	Response<Boolean> registrarTecnico(Tecnico datosNuevosTecnico);

	Response<Boolean> actualizarTecnico(Tecnico tecnicoModificar);

	Response<Boolean> eliminarTecnico(Integer idTecnico, boolean existeTecnico);

}
