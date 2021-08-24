package com.serviceDesk.runner.application.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.serviceDesk.runner.application.models.MaquinaModel;
import com.serviceDesk.runner.application.models.ResponseMensajeDto;

public interface IMaquinaService {
	
	MaquinaModel mostrarMaquina(@Valid @NotNull(message = "The value is required") Integer idMaquina);

	List<MaquinaModel> mostrarListaMaquinas();

	ResponseMensajeDto registrarMaquina(MaquinaModel datosMaquinaNueva);

	ResponseMensajeDto actualizarMaquina(MaquinaModel datosMaquinaModificar);
	
	ResponseMensajeDto eliminarMovimiento(Integer idMaquina);

}
