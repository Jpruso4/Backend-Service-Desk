package com.serviceDesk.runner.application.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serviceDesk.runner.application.dao.ITecnicoDao;
import com.serviceDesk.runner.application.entities.Tecnico;
import com.serviceDesk.runner.application.mapper.IMapperTecnico;
import com.serviceDesk.runner.application.model.Response;
import com.serviceDesk.runner.application.model.TecnicoModel;
import com.serviceDesk.runner.application.service.ITecnicoService;
import com.serviceDesk.runner.application.util.CodigosError;
import com.serviceDesk.runner.application.util.MensajesError;

@Service
public class TecnicoService implements ITecnicoService{
	
	private final ITecnicoDao iTecnicoDao;
	private final IMapperTecnico iMapperTecnico;
	
	@Autowired
	public TecnicoService(ITecnicoDao iTecnicoDao, IMapperTecnico iMapperTecnico) {
		this.iTecnicoDao = iTecnicoDao;
		this.iMapperTecnico = iMapperTecnico;
	}

	@Override
	public Response<TecnicoModel> mostrarTecnico(Integer idTecnico) {
		Optional<Tecnico> tecnicoData = iTecnicoDao.findById(idTecnico);
		
		if(!tecnicoData.isPresent())
			return new Response<TecnicoModel>(CodigosError.COD_TECHNICIAN_NON_EXISTENT, MensajesError.TECHNICIAN_NON_EXISTENT, null);
		return new Response<TecnicoModel>(null, null, iMapperTecnico.mappearTecnico(tecnicoData.get()));
	}
	
	@Override
	public Response<List<TecnicoModel>> mostrarListaTecnicos() {
		List<TecnicoModel> tecnicosModel = new LinkedList<>();
		List<Tecnico> tecnicosData = iTecnicoDao.findAll();
		for(Tecnico tecnico : tecnicosData) {
			tecnicosModel.add(iMapperTecnico.mappearTecnico(tecnico));
		}
		return new Response<List<TecnicoModel>>(null, null, tecnicosModel);
	}

	@Override
	public Response<Boolean> registrarTecnico(Tecnico datosNuevosTecnico) {
		iTecnicoDao.save(datosNuevosTecnico);
		return new Response<Boolean>(null, null, true);
	}

	@Override
	public Response<Boolean> actualizarTecnico(Tecnico tecnicoModificar) {
		iTecnicoDao.save(tecnicoModificar);
		return new Response<Boolean>(null, null, true);
	}

	@Override
	public Response<Boolean> eliminarTecnico(Integer idTecnico, boolean existeTecnico) {
		if(existeTecnico) {
			iTecnicoDao.deleteById(idTecnico);
			return new Response<Boolean>(null, null, true);
		}else
			return new Response<Boolean>(CodigosError.COD_TECHNICIAN_NON_EXISTENT,MensajesError.TECHNICIAN_NON_EXISTENT, null);
	}

}
