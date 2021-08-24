package com.serviceDesk.runner.application.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serviceDesk.runner.application.dao.IMaquinaDao;
import com.serviceDesk.runner.application.dao.ITipoDependenciaDao;
import com.serviceDesk.runner.application.entities.Maquina;
import com.serviceDesk.runner.application.entities.TipoDependencia;
import com.serviceDesk.runner.application.mapper.IMapperMaquina;
import com.serviceDesk.runner.application.model.MaquinaModel;
import com.serviceDesk.runner.application.model.Response;
import com.serviceDesk.runner.application.repository.IMaquinaRespository;
import com.serviceDesk.runner.application.repository.ITipoDependenciaRepository;
import com.serviceDesk.runner.application.service.IMaquinaService;
import com.serviceDesk.runner.application.util.MensajesError;

@Service
public class MaquinaService implements IMaquinaService {

	private final IMaquinaDao iMaquinaDao;
	private final ITipoDependenciaDao iTipoDependenciaDao;
	private final IMapperMaquina iMapperMaquina;
	private final ITipoDependenciaRepository iTipoDependenciaRepository;
	private final IMaquinaRespository iMaquinaRepository;

	@Autowired
	public MaquinaService(IMaquinaDao iMaquinaDao, ITipoDependenciaDao iTipoDependenciaDao,
			IMapperMaquina iMapperMaquina, ITipoDependenciaRepository iTipoDependenciaRepository,
			IMaquinaRespository iMaquinaRepository) {
		this.iMaquinaDao = iMaquinaDao;
		this.iTipoDependenciaDao = iTipoDependenciaDao;
		this.iMapperMaquina = iMapperMaquina;
		this.iTipoDependenciaRepository = iTipoDependenciaRepository;
		this.iMaquinaRepository = iMaquinaRepository;
	}

	@Override
	public Response<MaquinaModel> mostrarMaquina(@Valid @NotNull(message = "The value is required") Integer idMaquina) {
		Optional<Maquina> maquinaData = iMaquinaDao.findById(idMaquina);

		if (!maquinaData.isPresent()) {
			return new Response<MaquinaModel>(null, MensajesError.MAQUINA_INEXISTENTE, null);
		}
		Maquina maquina = maquinaData.get();
		return new Response<MaquinaModel>(null, null, iMapperMaquina.mostrarMaquina(maquina));
	}

	@Override
	public Response<List<MaquinaModel>> mostrarListaMaquinas() {
		List<MaquinaModel> maquinas = new LinkedList<>();
		List<Maquina> maquinaEntities = iMaquinaDao.findAll();
		for (Maquina maquina : maquinaEntities) {
			maquinas.add(iMapperMaquina.mostrarMaquina(maquina));
		}
		return new Response<List<MaquinaModel>>(null, null, maquinas);
	}

	@Override
	public Response<MaquinaModel> registrarMaquina(MaquinaModel datosMaquinaNueva) {
		Maquina registroMaquina = new Maquina();

		Optional<TipoDependencia> tipoDependenciaEntity = iTipoDependenciaRepository.obtenerElTipoDeDependencia(
				datosMaquinaNueva.getTipoDependencia().getIdTipoDependencia(), iTipoDependenciaDao);

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
		iMaquinaDao.save(registroMaquina);
		return new Response<MaquinaModel>(null, null, datosMaquinaNueva);
	}

	@Override
	public Response<MaquinaModel> actualizarMaquina(MaquinaModel datosMaquinaModificar) {
		boolean existeMaquina = iMaquinaRepository.consultarExistenciaMaquina(datosMaquinaModificar.getIdMaquina(),
				iMaquinaDao);
		if (!existeMaquina)
			return new Response<MaquinaModel>(null, MensajesError.MAQUINA_INEXISTENTE, null);

		boolean existeTipoDependencia = iTipoDependenciaRepository.existeTipoDeDependencia(
				datosMaquinaModificar.getTipoDependencia().getIdTipoDependencia(), iTipoDependenciaDao);
		if (!existeTipoDependencia)
			return new Response<MaquinaModel>(null, MensajesError.TIPO_DE_DEPENDENCIA_INEXISTENTE, null);

		Maquina maquinaModificar = validarCambiosActualizarMaquina(
				iMaquinaRepository.obtenerDatosMaquina(datosMaquinaModificar.getIdMaquina(), iMaquinaDao),
				datosMaquinaModificar, iTipoDependenciaRepository.obtenerElTipoDeDependencia(
						datosMaquinaModificar.getTipoDependencia().getIdTipoDependencia(), iTipoDependenciaDao));
		iMaquinaDao.save(maquinaModificar);
		return new Response<MaquinaModel>(null, null, datosMaquinaModificar);
	}

	@Override
	public Response<MaquinaModel> eliminarMovimiento(Integer idMaquina) {
		if(iMaquinaRepository.consultarExistenciaMaquina(idMaquina, iMaquinaDao)) {
			Optional<Maquina> maquinaBorrada = iMaquinaRepository.obtenerDatosMaquina(idMaquina, iMaquinaDao);
			Maquina maquina = maquinaBorrada.get();
			iMaquinaDao.deleteById(idMaquina);
			return new Response<MaquinaModel>(null,null, iMapperMaquina.mostrarMaquina(maquina));
		}else 
			return new Response<MaquinaModel>(null,MensajesError.MAQUINA_INEXISTENTE,null);
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
