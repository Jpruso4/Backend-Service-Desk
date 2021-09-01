package com.serviceDesk.runner.application.repository.impl;

import java.util.Optional;
import com.serviceDesk.runner.application.dao.IMaquinaDao;
import com.serviceDesk.runner.application.entities.BloqueDependencia;
import com.serviceDesk.runner.application.entities.Maquina;
import com.serviceDesk.runner.application.entities.NumeroDependencia;
import com.serviceDesk.runner.application.repository.IBloqueDependenciaRepository;
import com.serviceDesk.runner.application.repository.IMaquinaRespository;
import com.serviceDesk.runner.application.repository.INumeroDependenciaRepository;

public class MaquinaRepository implements IMaquinaRespository{
	
	private final IMaquinaDao iMaquinaDao;
	private final IBloqueDependenciaRepository iBloqueDependenciaRepository;
	private final INumeroDependenciaRepository iNumeroDependenciaRepository;
	
	public MaquinaRepository(IMaquinaDao iMaquinaDao, IBloqueDependenciaRepository iBloqueDependenciaRepository, INumeroDependenciaRepository iNumeroDependenciaRepository) {
		this.iMaquinaDao = iMaquinaDao;
		this.iBloqueDependenciaRepository = iBloqueDependenciaRepository;
		this.iNumeroDependenciaRepository = iNumeroDependenciaRepository;
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
	public Optional<Maquina> obtenerMaquinaPorSalon(int numeroComputador, String numeroDependenciaModel,
			String bloqueDependenciaModel) {
		Optional<BloqueDependencia> bloqueDependenciaData = iBloqueDependenciaRepository.obtenerElBloqueDeDependenciaPorNombre(bloqueDependenciaModel);
		BloqueDependencia bloqueDependencia = bloqueDependenciaData.get();
		
		Optional<NumeroDependencia> numeroDependenciaData = iNumeroDependenciaRepository.obtenerElNumeroDeDependenciaPorNombre(numeroDependenciaModel);
		NumeroDependencia numeroDependencia = numeroDependenciaData.get();
		return iMaquinaDao.obtenerMaquinaPorSalon(numeroComputador, numeroDependencia.getIdNumeroDependencia(), bloqueDependencia.getIdBloqueDependencia());
	}

	@Override
	public boolean consultarExisteMaquinaSalon(int numeroComputador, String numeroDependenciaModel, String bloqueDependenciaModel) {
		if(!iBloqueDependenciaRepository.existeBloqueDeDependenciaPorNombre(bloqueDependenciaModel))
			return false;
		Optional<BloqueDependencia> bloqueDependenciaData = iBloqueDependenciaRepository.obtenerElBloqueDeDependenciaPorNombre(bloqueDependenciaModel);
		BloqueDependencia bloqueDependencia = bloqueDependenciaData.get();
		
		if(!iNumeroDependenciaRepository.existeNumeroDeDependenciaPorNombre(numeroDependenciaModel))
			return false;
		Optional<NumeroDependencia> numeroDependenciaData = iNumeroDependenciaRepository.obtenerElNumeroDeDependenciaPorNombre(numeroDependenciaModel);
		NumeroDependencia numeroDependencia = numeroDependenciaData.get();
		
		Optional<Maquina> maquinaData = iMaquinaDao.obtenerMaquinaPorSalon(numeroComputador, numeroDependencia.getIdNumeroDependencia(), bloqueDependencia.getIdBloqueDependencia());
		if(!maquinaData.isPresent())
			return false;
		return true;
	}

}
