package com.serviceDesk.runner.application.mapper.impl;

import org.springframework.stereotype.Service;

import com.serviceDesk.runner.application.entities.Incidente;
import com.serviceDesk.runner.application.entities.Maquina;
import com.serviceDesk.runner.application.entities.Tecnico;
import com.serviceDesk.runner.application.entities.TipoIncidente;
import com.serviceDesk.runner.application.entities.Usuario;
import com.serviceDesk.runner.application.mapper.IMapperIncidente;
import com.serviceDesk.runner.application.models.IncidenteModel;
import com.serviceDesk.runner.application.models.MaquinaModel;
import com.serviceDesk.runner.application.models.TecnicoModel;
import com.serviceDesk.runner.application.models.TipoIncidenteModel;
import com.serviceDesk.runner.application.models.UsuarioModel;

@Service
public class MapperIncidente implements IMapperIncidente{

	@Override
	public IncidenteModel mostrarIncidente(Incidente incidenteEntity) {
		IncidenteModel mostrarLista = new IncidenteModel();
		mostrarLista.setIdIncidente(incidenteEntity.getIdIncidente());;
		mostrarLista.setFecha(incidenteEntity.getFecha());
		
		Maquina maquina = incidenteEntity.getMaquina();
		MaquinaModel maquinaModel = new MaquinaModel();
		
		Tecnico tecnico = incidenteEntity.getTecnico();
		TecnicoModel tecnicoModel = new TecnicoModel();
		
		TipoIncidente tipoIncidente = incidenteEntity.getTipoIncidente();
		TipoIncidenteModel tipoIncidenteModel = new TipoIncidenteModel();
		
		Usuario usuario = incidenteEntity.getUsuario();
		UsuarioModel usuarioModel = new UsuarioModel();
		
		maquinaModel.setIdMaquina(maquina.getIdMaquina());
		maquinaModel.setNumeroDependencia(maquina.getNumeroDependencia());
		maquinaModel.setNumeroComputador(maquina.getNumeroComputador());
		maquinaModel.setBloqueDependencia(maquina.getBloqueDependencia());
		
		tecnicoModel.setIdTecnico(tecnico.getIdTecnico());
		tecnicoModel.setNombres(tecnico.getNombres());
		
		tipoIncidenteModel.setNombreTipoIncidente(tipoIncidente.getNombreTipoIncidente());
		tipoIncidenteModel.setIdTipoIncidente(tipoIncidente.getIdTipoIncidente());
		
		usuarioModel.setNumeroDocumento(usuario.getNumeroDocumento());
		usuarioModel.setIdUsuario(usuario.getIdUsuario());
		usuarioModel.setCorreo(usuario.getCorreo());
		
		mostrarLista.setMaquina(maquinaModel);
		mostrarLista.setTecnico(tecnicoModel);
		mostrarLista.setTipoIncidente(tipoIncidenteModel);
		mostrarLista.setUsuario(usuarioModel);
		
		if(incidenteEntity.getEstado() == 1){
			mostrarLista.setEstado("Pendiente");
		}else {
			mostrarLista.setEstado("Solucionado");
		}
		
		mostrarLista.setDeclaracionCallcenter(incidenteEntity.getDeclaracionCallcenter());
		mostrarLista.setProblemaUsuario(incidenteEntity.getProblemaUsuario());
		return mostrarLista;
	}

}
