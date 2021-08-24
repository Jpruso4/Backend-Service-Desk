package com.serviceDesk.runner.application.repository.impl;

import java.util.Optional;
import com.serviceDesk.runner.application.dao.IMaquinaDao;
import com.serviceDesk.runner.application.entities.Maquina;
import com.serviceDesk.runner.application.repository.IMaquinaRespository;

public class MaquinaRepository implements IMaquinaRespository{

	@Override
	public boolean consultarExistenciaMaquina(int idMaquina, IMaquinaDao iMaquinaDao) {
		Optional<Maquina> maquinaEntity = iMaquinaDao.findById(idMaquina);
		if(!maquinaEntity.isPresent())
			return false;
		return true;
	}

	@Override
	public Optional<Maquina> obtenerDatosMaquina(int idMaquina, IMaquinaDao iMaquinaDao) {
		Optional<Maquina> maquinaEntity = iMaquinaDao.findById(idMaquina);
		return maquinaEntity;
	}

}
