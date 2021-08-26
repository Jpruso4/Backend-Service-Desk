package com.serviceDesk.runner.application.service;

import java.util.List;

import com.serviceDesk.runner.application.entities.Maquina;
import com.serviceDesk.runner.application.model.MaquinaModel;
import com.serviceDesk.runner.application.model.Response;

public interface IMaquinaService {
	
	Response<MaquinaModel> mostrarMaquina(Integer idMaquina);

	Response<List<MaquinaModel>>mostrarListaMaquinas();

	Response<Boolean> registrarMaquina(Maquina datosMaquinaNueva);

	Response<Boolean> actualizarMaquina(Maquina datosMaquinaModificar);
	
	Response<Boolean> eliminarMovimiento(Integer idMaquina, boolean existeMaquina);

}
