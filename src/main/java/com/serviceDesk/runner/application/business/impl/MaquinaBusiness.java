package com.serviceDesk.runner.application.business.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.serviceDesk.runner.application.business.IMaquinaBusiness;
import com.serviceDesk.runner.application.dao.IMaquinaDao;
import com.serviceDesk.runner.application.dao.ITipoDependenciaDao;
import com.serviceDesk.runner.application.entities.Maquina;
import com.serviceDesk.runner.application.entities.TipoDependencia;
import com.serviceDesk.runner.application.model.MaquinaModel;
import com.serviceDesk.runner.application.model.Response;
import com.serviceDesk.runner.application.repository.IMaquinaRespository;
import com.serviceDesk.runner.application.repository.ITipoDependenciaRepository;
import com.serviceDesk.runner.application.service.IMaquinaService;
import com.serviceDesk.runner.application.util.MensajesError;

public class MaquinaBusiness implements IMaquinaBusiness {

	private final IMaquinaService iMaquinaService;
	private final ITipoDependenciaRepository iTipoDependenciaRepository;
	private final IMaquinaRespository iMaquinaRepository;

	@Autowired
	public MaquinaBusiness(IMaquinaService iMaquinaService, ITipoDependenciaRepository iTipoDependenciaRepository,
			ITipoDependenciaDao iTipoDependenciaDao, IMaquinaRespository iMaquinaRepository, IMaquinaDao iMaquinaDao) {
		this.iMaquinaService = iMaquinaService;
		this.iTipoDependenciaRepository = iTipoDependenciaRepository;
		this.iMaquinaRepository = iMaquinaRepository;
	}

	@Override
	public Response<MaquinaModel> mostrarMaquina(Integer idMaquina) {
		return iMaquinaService.mostrarMaquina(idMaquina);
	}

	@Override
	public Response<List<MaquinaModel>> mostrarListaMaquinas() {
		return iMaquinaService.mostrarListaMaquinas();
	}

	@Override
	public Response<Boolean> registrarMaquina(MaquinaModel datosMaquinaNueva) {
		Maquina registroMaquina = new Maquina();

		Optional<TipoDependencia> tipoDependenciaEntity = iTipoDependenciaRepository.obtenerElTipoDeDependencia(
				datosMaquinaNueva.getTipoDependencia().getIdTipoDependencia());

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
		registroMaquina.setSistemaOperativo(datosMaquinaNueva.getSistemaOperativo());
		return iMaquinaService.registrarMaquina(registroMaquina);
	}

	@Override
	public Response<Boolean> actualizarMaquina(MaquinaModel datosMaquinaModificar) {
		boolean existeMaquina = iMaquinaRepository.consultarExistenciaMaquina(datosMaquinaModificar.getIdMaquina());
		if (!existeMaquina)
			return new Response<Boolean>(null, MensajesError.MAQUINA_INEXISTENTE, null);

		boolean existeTipoDependencia = iTipoDependenciaRepository.existeTipoDeDependencia(
				datosMaquinaModificar.getTipoDependencia().getIdTipoDependencia());
		if (!existeTipoDependencia)
			return new Response<Boolean>(null, MensajesError.TIPO_DE_DEPENDENCIA_INEXISTENTE, null);

		Maquina maquinaModificar = validarCambiosActualizarMaquina(
				iMaquinaRepository.obtenerDatosMaquina(datosMaquinaModificar.getIdMaquina()),
				datosMaquinaModificar, iTipoDependenciaRepository.obtenerElTipoDeDependencia(
						datosMaquinaModificar.getTipoDependencia().getIdTipoDependencia()));
		return iMaquinaService.actualizarMaquina(maquinaModificar);
	}

	@Override
	public Response<Boolean> eliminarMovimiento(Integer idMaquina) {
		return iMaquinaService.eliminarMovimiento(idMaquina, iMaquinaRepository.consultarExistenciaMaquina(idMaquina));
	}
	
	private Maquina validarCambiosActualizarMaquina(Optional<Maquina> datosMaquinaBD,
			MaquinaModel datosMaquinaModificar, Optional<TipoDependencia> datosTipoDependenciaBD) {

		Maquina maquinaData = datosMaquinaBD.get();
		TipoDependencia tipoDependenciaData = datosTipoDependenciaBD.get();

		maquinaData.setTipoDependencia(tipoDependenciaData);

		if (!(maquinaData.getNumeroComputador() == datosMaquinaModificar.getNumeroComputador()))
			maquinaData.setNumeroComputador(datosMaquinaModificar.getNumeroComputador());

		if (!(maquinaData.getNumeroDependencia() == datosMaquinaModificar.getNumeroDependencia()))
			maquinaData.setNumeroDependencia(datosMaquinaModificar.getNumeroDependencia());

		if (!(maquinaData.getBloqueDependencia().equals(datosMaquinaModificar.getBloqueDependencia())))
			maquinaData.setBloqueDependencia(datosMaquinaModificar.getBloqueDependencia());

		if (!(maquinaData.getSerialPantalla() == (datosMaquinaModificar.getSerialPantalla())))
			maquinaData.setSerialPantalla(datosMaquinaModificar.getSerialPantalla());

		if (!(maquinaData.getSerialCpu() == datosMaquinaModificar.getSerialCpu()))
			maquinaData.setSerialCpu(datosMaquinaModificar.getSerialCpu());

		if (!(maquinaData.getSerialTeclado() == datosMaquinaModificar.getSerialTeclado()))
			maquinaData.setSerialTeclado(datosMaquinaModificar.getSerialTeclado());

		if (!(maquinaData.getSerialMouse() == datosMaquinaModificar.getSerialMouse()))
			maquinaData.setSerialMouse(datosMaquinaModificar.getSerialMouse());

		if (!(maquinaData.getSistemaOperativo().equals(datosMaquinaModificar.getSistemaOperativo())))
			maquinaData.setSistemaOperativo(datosMaquinaModificar.getSistemaOperativo());

		if (!(maquinaData.getNombreEquipo().equals(datosMaquinaModificar.getNombreEquipo())))
			maquinaData.setNombreEquipo(datosMaquinaModificar.getNombreEquipo());

		if (!(maquinaData.getProcesador().equals(datosMaquinaModificar.getProcesador())))
			maquinaData.setProcesador(datosMaquinaModificar.getProcesador());

		if (!(maquinaData.getRam() == datosMaquinaModificar.getRam()))
			maquinaData.setRam(datosMaquinaModificar.getRam());

		return maquinaData;
	}

}
