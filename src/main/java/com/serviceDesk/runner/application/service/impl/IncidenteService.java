 package com.serviceDesk.runner.application.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.serviceDesk.runner.application.dao.IIncidenteDao;
import com.serviceDesk.runner.application.entities.Incidente;
import com.serviceDesk.runner.application.mapper.IMapperIncidente;
import com.serviceDesk.runner.application.model.IncidenteModel;
import com.serviceDesk.runner.application.model.Response;

import com.serviceDesk.runner.application.service.IIncidenteService;
import com.serviceDesk.runner.application.util.MensajesError;

@Service
public class IncidenteService  implements IIncidenteService{

	private final IIncidenteDao iIncidenteDao;
	private final IMapperIncidente iMapperIncidente;

	
	@Autowired
	public IncidenteService(IIncidenteDao iIncidenteDao, IMapperIncidente iMapperIncidente) {
		this.iIncidenteDao = iIncidenteDao;
		this.iMapperIncidente = iMapperIncidente;
	}
	
	@Override
	public Response<IncidenteModel> mostrarIncidente(Integer idIncidente) {
		Optional<Incidente> incidenteData = iIncidenteDao.findById(idIncidente);

		if(!incidenteData.isPresent()) {
			return new Response<IncidenteModel>(null, MensajesError.INCIDENTE_INEXISTENTE, null);
		}
		return new Response<IncidenteModel>(null,null, iMapperIncidente.mappearIncidente(incidenteData.get()));
	}

	@Override
	public Response<List<IncidenteModel>> mostrarListaIncidentes() {
		List<IncidenteModel> incidentes = new LinkedList<>();
		List<Incidente> incidenteEntities = iIncidenteDao.findAll();
		for(Incidente incidente : incidenteEntities) {
			incidentes.add(iMapperIncidente.mappearIncidente(incidente));
		}
		return new Response<List<IncidenteModel>>(null, null, incidentes);
	}
	
//	public UsuarioModel validarUsuario(IncidenteModel datosIncidenteModel) {
//		Optional<Usuario> usuarioEntity = usuarioDao.obtenerUsuarioDocumento(datosIncidenteModel.getUsuario().getNumeroDocumento());
//		return mapperUsuario.mostrarUsuario(usuarioEntity.get());
//	}
	
//	public MaquinaModel validarMaquina(IncidenteModel datosIncidenteModel) {
//		Optional<Maquina> maquinaEntity = maquinaDao.obtenerMaquinaPorSalon(datosIncidenteModel.getMaquina().getNumeroComputador(), datosIncidenteModel.getMaquina().getNumeroDependencia(), datosIncidenteModel.getMaquina().getBloqueDependencia());
//		return mapperMaquina.mappearMaquina(maquinaEntity.get());
//	}

	@Override
	public Response<Boolean> registrarIncidente(Incidente datosIncidenteNuevo) {
		iIncidenteDao.save(datosIncidenteNuevo);
		return new Response<Boolean>(null,null,true);
	}
}
