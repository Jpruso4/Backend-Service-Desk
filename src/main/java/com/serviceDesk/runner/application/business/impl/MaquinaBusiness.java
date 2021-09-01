package com.serviceDesk.runner.application.business.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.serviceDesk.runner.application.business.IMaquinaBusiness;
import com.serviceDesk.runner.application.dao.IMaquinaDao;
import com.serviceDesk.runner.application.dao.ITipoDependenciaDao;
import com.serviceDesk.runner.application.entities.BloqueDependencia;
import com.serviceDesk.runner.application.entities.Maquina;
import com.serviceDesk.runner.application.entities.NumeroDependencia;
import com.serviceDesk.runner.application.entities.TipoDependencia;
import com.serviceDesk.runner.application.model.MaquinaModel;
import com.serviceDesk.runner.application.model.Response;
import com.serviceDesk.runner.application.repository.IBloqueDependenciaRepository;
import com.serviceDesk.runner.application.repository.IMaquinaRespository;
import com.serviceDesk.runner.application.repository.INumeroDependenciaRepository;
import com.serviceDesk.runner.application.repository.ITipoDependenciaRepository;
import com.serviceDesk.runner.application.service.IMaquinaService;
import com.serviceDesk.runner.application.util.CodigosError;
import com.serviceDesk.runner.application.util.MensajesError;

public class MaquinaBusiness implements IMaquinaBusiness {

	private final IMaquinaService iMaquinaService;
	private final ITipoDependenciaRepository iTipoDependenciaRepository;
	private final IMaquinaRespository iMaquinaRepository;
	private final IBloqueDependenciaRepository iBloqueDependenciaRepository;
	private final INumeroDependenciaRepository iNumeroDependenciaRepository;

	@Autowired
	public MaquinaBusiness(IMaquinaService iMaquinaService, ITipoDependenciaRepository iTipoDependenciaRepository,
			ITipoDependenciaDao iTipoDependenciaDao, IMaquinaRespository iMaquinaRepository, IMaquinaDao iMaquinaDao,
			IBloqueDependenciaRepository iBloqueDependenciaRepository,
			INumeroDependenciaRepository iNumeroDependenciaRepository) {
		this.iMaquinaService = iMaquinaService;
		this.iTipoDependenciaRepository = iTipoDependenciaRepository;
		this.iMaquinaRepository = iMaquinaRepository;
		this.iBloqueDependenciaRepository = iBloqueDependenciaRepository;
		this.iNumeroDependenciaRepository = iNumeroDependenciaRepository;
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

		if (!iTipoDependenciaRepository
				.existeTipoDeDependencia(datosMaquinaNueva.getTipoDependencia().getIdTipoDependencia()))
			return new Response<Boolean>(CodigosError.COD_TIPO_DE_DEPENDENCIA_INEXISTENTE,
					MensajesError.TIPO_DE_DEPENDENCIA_INEXISTENTE, null);

		registroMaquina.setTipoDependencia(iTipoDependenciaRepository
				.obtenerElTipoDeDependencia(datosMaquinaNueva.getTipoDependencia().getIdTipoDependencia()).get());

		if (!iBloqueDependenciaRepository
				.existeBloqueDeDependencia(datosMaquinaNueva.getBloqueDependencia().getIdBloqueDependencia()))
			return new Response<Boolean>(CodigosError.COD_BLOQUE_DE_DEPENDENCIA_INEXISTENTE,
					MensajesError.BLOQUE_DE_DEPENDENCIA_INEXISTENTE, null);

		registroMaquina.setBloqueDependencia(iBloqueDependenciaRepository
				.obtenerElBloqueDeDependencia(datosMaquinaNueva.getBloqueDependencia().getIdBloqueDependencia()).get());

		if (!iNumeroDependenciaRepository
				.existeNumeroDeDependencia(datosMaquinaNueva.getNumeroDependencia().getIdNumeroDependencia()))
			return new Response<Boolean>(CodigosError.COD_NUMERO_DE_DEPENDENCIA_INEXISTENTE,
					MensajesError.NUMERO_DE_DEPENDENCIA_INEXISTENTE, null);

		registroMaquina.setNumeroDependencia(iNumeroDependenciaRepository
				.obtenerElNumeroDeDependencia(datosMaquinaNueva.getNumeroDependencia().getIdNumeroDependencia()).get());

		registroMaquina.setNumeroComputador(datosMaquinaNueva.getNumeroComputador());
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
		if (!iMaquinaRepository.consultarExistenciaMaquina(datosMaquinaModificar.getIdMaquina()))
			return new Response<Boolean>(CodigosError.COD_MAQUINA_INEXISTENTE, MensajesError.MAQUINA_INEXISTENTE, null);

		if (!iTipoDependenciaRepository
				.existeTipoDeDependencia(datosMaquinaModificar.getTipoDependencia().getIdTipoDependencia()))
			return new Response<Boolean>(CodigosError.COD_TIPO_DE_DEPENDENCIA_INEXISTENTE,
					MensajesError.TIPO_DE_DEPENDENCIA_INEXISTENTE, null);

		if (!iBloqueDependenciaRepository
				.existeBloqueDeDependencia(datosMaquinaModificar.getBloqueDependencia().getIdBloqueDependencia()))
			return new Response<Boolean>(CodigosError.COD_BLOQUE_DE_DEPENDENCIA_INEXISTENTE,
					MensajesError.BLOQUE_DE_DEPENDENCIA_INEXISTENTE, null);

		if (!iNumeroDependenciaRepository
				.existeNumeroDeDependencia(datosMaquinaModificar.getNumeroDependencia().getIdNumeroDependencia()))
			return new Response<Boolean>(CodigosError.COD_NUMERO_DE_DEPENDENCIA_INEXISTENTE,
					MensajesError.NUMERO_DE_DEPENDENCIA_INEXISTENTE, null);

		Maquina maquinaModificar = validarCambiosActualizarMaquina(
				iMaquinaRepository.obtenerDatosMaquina(datosMaquinaModificar.getIdMaquina()), datosMaquinaModificar,
				iTipoDependenciaRepository
						.obtenerElTipoDeDependencia(datosMaquinaModificar.getTipoDependencia().getIdTipoDependencia()),
				iBloqueDependenciaRepository.obtenerElBloqueDeDependencia(
						datosMaquinaModificar.getNumeroDependencia().getIdNumeroDependencia()),
				iNumeroDependenciaRepository.obtenerElNumeroDeDependencia(
						datosMaquinaModificar.getNumeroDependencia().getIdNumeroDependencia()));
		return iMaquinaService.actualizarMaquina(maquinaModificar);
	}

	@Override
	public Response<Boolean> eliminarMaquina(Integer idMaquina) {
		return iMaquinaService.eliminarMaquina(idMaquina, iMaquinaRepository.consultarExistenciaMaquina(idMaquina));
	}

	private Maquina validarCambiosActualizarMaquina(Optional<Maquina> datosMaquinaBD,
			MaquinaModel datosMaquinaModificar, Optional<TipoDependencia> datosTipoDependenciaBD,
			Optional<BloqueDependencia> datosBloqueDependenciaBD,
			Optional<NumeroDependencia> datosNumeroDependenciaBD) {

		Maquina maquinaData = datosMaquinaBD.get();
		TipoDependencia tipoDependenciaData = datosTipoDependenciaBD.get();
		NumeroDependencia numeroDependencia = datosNumeroDependenciaBD.get();
		BloqueDependencia bloqueDependencia = datosBloqueDependenciaBD.get();

		maquinaData.setTipoDependencia(tipoDependenciaData);
		maquinaData.setBloqueDependencia(bloqueDependencia);
		maquinaData.setNumeroDependencia(numeroDependencia);

		if (!(maquinaData.getNumeroComputador() == datosMaquinaModificar.getNumeroComputador()))
			maquinaData.setNumeroComputador(datosMaquinaModificar.getNumeroComputador());

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
