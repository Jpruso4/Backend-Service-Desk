package com.serviceDesk.runner.application.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.serviceDesk.runner.application.model.MaquinaModel;
import com.serviceDesk.runner.application.model.Response;

public interface IMaquinaService {
	
	Response<MaquinaModel> mostrarMaquina(@Valid @NotNull(message = "The value is required") Integer idMaquina);

	Response<List<MaquinaModel>>mostrarListaMaquinas();

	Response<MaquinaModel> registrarMaquina(MaquinaModel datosMaquinaNueva);

	Response<MaquinaModel> actualizarMaquina(MaquinaModel datosMaquinaModificar);
	
	Response<MaquinaModel> eliminarMovimiento(Integer idMaquina);

}
