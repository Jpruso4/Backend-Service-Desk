package com.serviceDesk.runner.application.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serviceDesk.runner.application.dao.IMaquinaDao;
import com.serviceDesk.runner.application.dao.ITipoDependenciaDao;
import com.serviceDesk.runner.application.entities.Maquina;
import com.serviceDesk.runner.application.mapper.IMapperMaquina;
import com.serviceDesk.runner.application.model.MaquinaModel;
import com.serviceDesk.runner.application.model.Response;
import com.serviceDesk.runner.application.service.IMaquinaService;
import com.serviceDesk.runner.application.util.MensajesError;

@Service
public class MaquinaService implements IMaquinaService {

	private IMaquinaDao iMaquinaDao;
	private final IMapperMaquina iMapperMaquina;
	

	@Autowired
	public MaquinaService(IMaquinaDao iMaquinaDao, ITipoDependenciaDao iTipoDependenciaDao,
			IMapperMaquina iMapperMaquina) {
		this.iMaquinaDao = iMaquinaDao;
		this.iMapperMaquina = iMapperMaquina;
	}

	@Override
	public Response<MaquinaModel> mostrarMaquina(Integer idMaquina) {
		Optional<Maquina> maquinaData = iMaquinaDao.findById(idMaquina);

		if (!maquinaData.isPresent()) {
			return new Response<MaquinaModel>(null, MensajesError.MAQUINA_INEXISTENTE, null);
		}
		return new Response<MaquinaModel>(null, null, iMapperMaquina.mappearMaquina(maquinaData.get()));
	}

	@Override
	public Response<List<MaquinaModel>> mostrarListaMaquinas() {
		List<MaquinaModel> maquinas = new LinkedList<>();
		List<Maquina> maquinaEntities = iMaquinaDao.findAll();
		for (Maquina maquina : maquinaEntities) {
			maquinas.add(iMapperMaquina.mappearMaquina(maquina));
		}
		return new Response<List<MaquinaModel>>(null, null, maquinas);
	}

	@Override
	public Response<Boolean> registrarMaquina(Maquina datosMaquinaNueva) {
		iMaquinaDao.save(datosMaquinaNueva);
		return new Response<Boolean>(null, null, true);
	}

	@Override
	public Response<Boolean> actualizarMaquina(Maquina maquinaModificar) {
		iMaquinaDao.save(maquinaModificar);
		return new Response<Boolean>(null, null, true);
	}

	@Override
	public Response<Boolean> eliminarMovimiento(Integer idMaquina, boolean existeMaquina) {
		 if(existeMaquina) {
			iMaquinaDao.deleteById(idMaquina);
			return new Response<Boolean>(null, null, true);
		} else
			return new Response<Boolean>(null, MensajesError.MAQUINA_INEXISTENTE, null);
	}
}
