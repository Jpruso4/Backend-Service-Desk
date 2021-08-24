 package com.serviceDesk.runner.application.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serviceDesk.runner.application.dao.IIncidenteDao;
import com.serviceDesk.runner.application.dao.IMaquinaDao;
import com.serviceDesk.runner.application.dao.ITecnicoDao;
import com.serviceDesk.runner.application.dao.ITipoIncidenteDao;
import com.serviceDesk.runner.application.dao.IUsuarioDao;
import com.serviceDesk.runner.application.entities.Incidente;
import com.serviceDesk.runner.application.entities.Maquina;
import com.serviceDesk.runner.application.entities.Tecnico;
import com.serviceDesk.runner.application.entities.TipoIncidente;
import com.serviceDesk.runner.application.entities.Usuario;
import com.serviceDesk.runner.application.mapper.impl.MapperIncidente;
import com.serviceDesk.runner.application.mapper.impl.MapperMaquina;
import com.serviceDesk.runner.application.mapper.impl.MapperUsuario;
import com.serviceDesk.runner.application.model.IncidenteModel;
import com.serviceDesk.runner.application.model.MaquinaModel;
import com.serviceDesk.runner.application.model.Response;
import com.serviceDesk.runner.application.model.UsuarioModel;
import com.serviceDesk.runner.application.service.IIncidenteService;
import com.serviceDesk.runner.application.util.MensajesError;

@Service
public class IncidenteService  implements IIncidenteService{

	private final IIncidenteDao incidenteDao;
	private final IUsuarioDao usuarioDao;
	private final IMaquinaDao maquinaDao;
	private final ITipoIncidenteDao tipoIncidenteDao;
	private final ITecnicoDao tecnicoDao;
	final MapperIncidente mapperIncidente = new MapperIncidente();
	final MapperUsuario mapperUsuario = new MapperUsuario();
	final MapperMaquina mapperMaquina = new MapperMaquina();
	
	@Autowired
	public IncidenteService(IIncidenteDao incidenteDao, IUsuarioDao usuarioDao, IMaquinaDao maquinaDao, ITipoIncidenteDao tipoIncidenteDao, ITecnicoDao tecnicoDao, IMaquinaDao maquinaDao2, ITecnicoDao tecnicoDao2) {
		this.incidenteDao = incidenteDao;
		this.usuarioDao = usuarioDao;
		this.maquinaDao = maquinaDao;
		this.tipoIncidenteDao = tipoIncidenteDao;
		this.tecnicoDao = tecnicoDao;
	}
	
	public IncidenteModel mostrarIncidentes(IncidenteModel obtenerIncidente) {
		IncidenteModel incidentes = new IncidenteModel();
		Optional<Incidente> incidenteEntity = incidenteDao.findById(obtenerIncidente.getIdIncidente());
		incidentes = mapperIncidente.mostrarIncidente(incidenteEntity.get());
		
		return incidentes;
	}

	@Override
	public List<IncidenteModel> mostrarListaIncidentes() {
		List<IncidenteModel> incidentes = new LinkedList<>();
		List<Incidente> incidenteEntities = incidenteDao.findAll();
		for(Incidente incidente : incidenteEntities) {
			incidentes.add(mapperIncidente.mostrarIncidente(incidente));
		}
		return incidentes;
	}
	
	public UsuarioModel validarUsuario(IncidenteModel datosIncidenteModel) {
		Optional<Usuario> usuarioEntity = usuarioDao.obtenerUsuarioDocumento(datosIncidenteModel.getUsuario().getNumeroDocumento());
		return mapperUsuario.mostrarUsuario(usuarioEntity.get());
	}
	
	public MaquinaModel validarMaquina(IncidenteModel datosIncidenteModel) {
		Optional<Maquina> maquinaEntity = maquinaDao.obtenerMaquinaPorSalon(datosIncidenteModel.getMaquina().getNumeroComputador(), datosIncidenteModel.getMaquina().getNumeroDependencia(), datosIncidenteModel.getMaquina().getBloqueDependencia());
		return mapperMaquina.mostrarMaquina(maquinaEntity.get());
	}


	@Override
	public Response<IncidenteModel> registrarIncidente(IncidenteModel datosIncidenteNuevo) {
		Incidente registroIncidente = new Incidente();

		Optional<Tecnico> tecnicoEntity;
		
		registroIncidente.setFecha(datosIncidenteNuevo.getFecha());
		
		Optional<Usuario> usuarioEntity = usuarioDao.obtenerUsuarioDocumento(datosIncidenteNuevo.getUsuario().getNumeroDocumento());
		if (!usuarioEntity.isPresent()) {
			throw new NoSuchElementException(MensajesError.USUARIO_INEXISTENTE);
		}
		registroIncidente.setUsuario(usuarioEntity.get());
		
		Optional<Maquina> maquinaEntity = maquinaDao.obtenerMaquinaPorSalon(datosIncidenteNuevo.getMaquina().getNumeroComputador(), datosIncidenteNuevo.getMaquina().getNumeroDependencia(), datosIncidenteNuevo.getMaquina().getBloqueDependencia());
		if(!maquinaEntity.isPresent()) {
			throw new NoSuchElementException(MensajesError.MAQUINA_INEXISTENTE);
		}
		registroIncidente.setMaquina(maquinaEntity.get());
		
		if(datosIncidenteNuevo.getTecnico().getNombres() == "") {
			tecnicoEntity = tecnicoDao.obtenerTecnicoPorNombre("call");
			registroIncidente.setEstado(0);
		}else {
			tecnicoEntity = tecnicoDao.obtenerTecnicoPorNombre(datosIncidenteNuevo.getTecnico().getNombres());
			registroIncidente.setEstado(1);
		}
		if(!tecnicoEntity.isPresent()) {
			throw new NoSuchElementException(MensajesError.TECHNICIAN_NON_EXISTENT);
		}
		registroIncidente.setTecnico(tecnicoEntity.get());
		
		Optional<TipoIncidente> tipoIncidenteEntity = tipoIncidenteDao.obtenerTipoIncidente(datosIncidenteNuevo.getTipoIncidente().getNombreTipoIncidente());
		if(!tipoIncidenteEntity.isPresent()) {
			throw new NoSuchElementException(MensajesError.TIPO_DE_INCIDENTE_INEXISTENTE);
		}
		registroIncidente.setTipoIncidente(tipoIncidenteEntity.get());
		registroIncidente.setProblemaUsuario(datosIncidenteNuevo.getProblemaUsuario());
		registroIncidente.setDeclaracionCallcenter(datosIncidenteNuevo.getDeclaracionCallcenter());
		
		incidenteDao.save(registroIncidente);
		
		return new Response<IncidenteModel>(null,null,datosIncidenteNuevo);
	}
	
	
}
