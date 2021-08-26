package com.serviceDesk.runner.application.repository;

import java.util.Optional;

import com.serviceDesk.runner.application.entities.Maquina;

public interface IMaquinaRespository {
	
	public boolean consultarExistenciaMaquina (int idMaquina);
	
	public Optional<Maquina> obtenerDatosMaquina (int idMaquina);
	
	public Optional<Maquina> obtenerMaquinaPorSalon (int numeroComputador, int numeroDependencia, String bloqueDependencia);
	
	public boolean consultarExisteMaquinaSalon (int numeroComputador, int numeroDependencia, String bloqueDependencia);
}

