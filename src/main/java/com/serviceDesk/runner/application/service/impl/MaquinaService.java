package com.serviceDesk.runner.application.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;

import com.serviceDesk.runner.application.dao.IMaquinaDao;
import com.serviceDesk.runner.application.dao.ITipoDependenciaDao;
import com.serviceDesk.runner.application.entities.Maquina;
import com.serviceDesk.runner.application.entities.TipoDependencia;
import com.serviceDesk.runner.application.mapper.IMapperMaquina;
import com.serviceDesk.runner.application.models.BodyModel;
import com.serviceDesk.runner.application.models.MaquinaModel;
import com.serviceDesk.runner.application.models.ResponseMensajeDto;
import com.serviceDesk.runner.application.service.IMaquinaService;
import com.serviceDesk.runner.application.util.MensajesError;

public class MaquinaService implements IMaquinaService {

	private final IMaquinaDao iMaquinaDao;
	private final ITipoDependenciaDao iTipoDependenciaDao;
	private final IMapperMaquina iMapperMaquina;
	private final ResponseMensajeDto respuestaMensaje;

	@Autowired
	public MaquinaService(IMaquinaDao iMaquinaDao, ITipoDependenciaDao iTipoDependenciaDao,
			IMapperMaquina iMapperMaquina, ResponseMensajeDto respuestaMensaje) {
		this.iMaquinaDao = iMaquinaDao;
		this.iTipoDependenciaDao = iTipoDependenciaDao;
		this.iMapperMaquina = iMapperMaquina;
		this.respuestaMensaje = respuestaMensaje;
	}

	@Override
	public MaquinaModel mostrarMaquina(@Valid @NotNull(message = "The value is required") Integer idMaquina) {
		Optional<Maquina> maquinaData = iMaquinaDao.findById(idMaquina);
		if (!maquinaData.isPresent()) {
			throw new NoSuchElementException(MensajesError.MESSAGE_NULL);
		}
		Maquina maquina = maquinaData.get();
		return iMapperMaquina.mostrarMaquina(maquina);
	}

	@Override
	public List<MaquinaModel> mostrarListaMaquinas() {
		List<MaquinaModel> maquinas = new LinkedList<>();
		List<Maquina> maquinaEntities = iMaquinaDao.findAll();
		for (Maquina maquina : maquinaEntities) {
			maquinas.add(iMapperMaquina.mostrarMaquina(maquina));

		}
		return maquinas;
	}

	@Override
	public ResponseMensajeDto registrarMaquina(MaquinaModel datosMaquinaNueva) {
		Maquina registroMaquina = new Maquina();

		Optional<TipoDependencia> tipoDependenciaEntity = iTipoDependenciaDao.findById(datosMaquinaNueva.getTipoDependencia().getIdTipoDependencia());
		if (!tipoDependenciaEntity.isPresent())
			throw new NoSuchElementException(MensajesError.MESSAGE_NULL);

		registroMaquina.setTipoDependencia(tipoDependenciaEntity.get());
		registroMaquina.setNumeroComputador(datosMaquinaNueva.getNumeroComputador());
		registroMaquina.setNumeroDependencia(datosMaquinaNueva.getNumeroDependencia());
		registroMaquina.setBloqueDependencia(datosMaquinaNueva.getBloqueDependencia());
		registroMaquina.setSerialPantalla(datosMaquinaNueva.getSerialPantalla());
		registroMaquina.setSerialCpu(datosMaquinaNueva.getSerialCpu());
		registroMaquina.setSerialTeclado(datosMaquinaNueva.getSerialTeclado());
		registroMaquina.setSerialMouse(datosMaquinaNueva.getSerialMouse());
		registroMaquina.setNombreEquipo(datosMaquinaNueva.getNombreEquipo());
		registroMaquina.setProcesador(datosMaquinaNueva.getProcesador());
		registroMaquina.setRam(datosMaquinaNueva.getRam());
		iMaquinaDao.save(registroMaquina);
		respuestaMensaje.setBody(new BodyModel(true));
		return respuestaMensaje;
	}

	@Override
	public ResponseMensajeDto actualizarMaquina(MaquinaModel datosMaquinaModificar) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseMensajeDto eliminarMovimiento(Integer idMaquina) {
		// TODO Auto-generated method stub
		return null;
	}

}
