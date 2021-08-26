package com.serviceDesk.runner.application.repository.impl;

import java.util.Optional;
import com.serviceDesk.runner.application.dao.IMaquinaDao;
import com.serviceDesk.runner.application.entities.Maquina;
import com.serviceDesk.runner.application.repository.IMaquinaRespository;

public class MaquinaRepository implements IMaquinaRespository{
	
	private final IMaquinaDao iMaquinaDao;
	
	public MaquinaRepository(IMaquinaDao iMaquinaDao) {
		this.iMaquinaDao = iMaquinaDao;
	}

	@Override
	public boolean consultarExistenciaMaquina(int idMaquina) {
		Optional<Maquina> maquinaEntity = iMaquinaDao.findById(idMaquina);
		if(!maquinaEntity.isPresent())
			return false;
		return true;
	}

	@Override
	public Optional<Maquina> obtenerDatosMaquina(int idMaquina) {
		return iMaquinaDao.findById(idMaquina);
	}

	@Override
	public Optional<Maquina> obtenerMaquinaPorSalon(int numeroComputador, int numeroDependencia,
			String bloqueDependencia) {
		return iMaquinaDao.obtenerMaquinaPorSalon(numeroComputador, numeroDependencia, bloqueDependencia);
	}

	@Override
	public boolean consultarExisteMaquinaSalon(int numeroComputador, int numeroDependencia, String bloqueDependencia) {
		Optional<Maquina> maquinaData = iMaquinaDao.obtenerMaquinaPorSalon(numeroComputador, numeroDependencia, bloqueDependencia);
		if(!maquinaData.isPresent())
			return false;
		return true;
	}

}
