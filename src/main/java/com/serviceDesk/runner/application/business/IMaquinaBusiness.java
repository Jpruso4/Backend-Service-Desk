package com.serviceDesk.runner.application.business;

import java.util.List;

import com.serviceDesk.runner.application.model.MaquinaModel;
import com.serviceDesk.runner.application.model.Response;

public interface IMaquinaBusiness {

	Response<MaquinaModel> mostrarMaquina(Integer idMaquina);

	Response<List<MaquinaModel>>mostrarListaMaquinas();

	Response<Boolean> registrarMaquina(MaquinaModel datosMaquinaNueva);

	Response<Boolean> actualizarMaquina(MaquinaModel datosMaquinaModificar);
	
	Response<Boolean> eliminarMovimiento(Integer idMaquina);
}
