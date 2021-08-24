package com.serviceDesk.runner.application.repository;

import java.util.Optional;

import com.serviceDesk.runner.application.dao.IMaquinaDao;
import com.serviceDesk.runner.application.entities.Maquina;

public interface IMaquinaRespository {
	
	public boolean consultarExistenciaMaquina (int idMaquina, IMaquinaDao iMaquinaDao);
	
	public Optional<Maquina> obtenerDatosMaquina (int idMaquina, IMaquinaDao iMaquinaDao);
}

