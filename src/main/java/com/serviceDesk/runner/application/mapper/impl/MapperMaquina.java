package com.serviceDesk.runner.application.mapper.impl;

import org.springframework.stereotype.Service;

import com.serviceDesk.runner.application.entities.Maquina;
import com.serviceDesk.runner.application.entities.TipoDependencia;
import com.serviceDesk.runner.application.mapper.IMapperMaquina;
import com.serviceDesk.runner.application.models.MaquinaModel;
import com.serviceDesk.runner.application.models.TipoDependenciaModel;

@Service
public class MapperMaquina implements IMapperMaquina{
	
	@Override
	public MaquinaModel mostrarMaquina(Maquina maquinaEntity){
		MaquinaModel mostrarMaquina = new MaquinaModel();
		mostrarMaquina.setIdMaquina(maquinaEntity.getIdMaquina());
		
		TipoDependencia tipoDependencia = maquinaEntity.getTipoDependencia();
		TipoDependenciaModel tipoDependenciaModel = new TipoDependenciaModel();
		
		tipoDependenciaModel.setIdTipoDependencia(tipoDependencia.getIdTipoDependencia());
		tipoDependenciaModel.setNombreDependencia(tipoDependencia.getNombreDependencia());
		
		mostrarMaquina.setTipoDependencia(tipoDependenciaModel);
		mostrarMaquina.setNumeroComputador(maquinaEntity.getNumeroComputador());
		mostrarMaquina.setNumeroDependencia(maquinaEntity.getNumeroDependencia());
		mostrarMaquina.setBloqueDependencia(maquinaEntity.getBloqueDependencia());
		mostrarMaquina.setSerialPantalla(maquinaEntity.getSerialPantalla());
		mostrarMaquina.setSerialCpu(maquinaEntity.getSerialCpu());
		mostrarMaquina.setSerialTeclado(maquinaEntity.getSerialTeclado());
		mostrarMaquina.setSerialMouse(maquinaEntity.getSerialMouse());
		mostrarMaquina.setSistemaOperativo(maquinaEntity.getSistemaOperativo());
		mostrarMaquina.setNombreEquipo(maquinaEntity.getNombreEquipo());
		mostrarMaquina.setProcesador(maquinaEntity.getProcesador());
		mostrarMaquina.setRam(maquinaEntity.getRam());
		return mostrarMaquina;
	}
}
