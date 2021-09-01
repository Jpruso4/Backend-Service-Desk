package com.serviceDesk.runner.application.mapper.impl;

import org.springframework.stereotype.Service;

import com.serviceDesk.runner.application.entities.BloqueDependencia;
import com.serviceDesk.runner.application.entities.Incidente;
import com.serviceDesk.runner.application.entities.Maquina;
import com.serviceDesk.runner.application.entities.NumeroDependencia;
import com.serviceDesk.runner.application.entities.Tecnico;
import com.serviceDesk.runner.application.entities.TipoIncidente;
import com.serviceDesk.runner.application.entities.Usuario;
import com.serviceDesk.runner.application.mapper.IMapperIncidente;
import com.serviceDesk.runner.application.model.BloqueDependenciaModel;
import com.serviceDesk.runner.application.model.IncidenteModel;
import com.serviceDesk.runner.application.model.MaquinaModel;
import com.serviceDesk.runner.application.model.NumeroDependenciaModel;
import com.serviceDesk.runner.application.model.TecnicoModel;
import com.serviceDesk.runner.application.model.TipoIncidenteModel;
import com.serviceDesk.runner.application.model.UsuarioModel;

@Service
public class MapperIncidente implements IMapperIncidente{

	@Override
	public IncidenteModel mappearIncidente(Incidente incidenteEntity) {
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
		
		BloqueDependencia bloqueDependencia = maquina.getBloqueDependencia();
		BloqueDependenciaModel bloqueDependenciaModel = new BloqueDependenciaModel();
		NumeroDependencia numeroDependencia = maquina.getNumeroDependencia();
		NumeroDependenciaModel numeroDependenciaModel = new NumeroDependenciaModel();
		
		bloqueDependenciaModel.setIdBloqueDependencia(bloqueDependencia.getIdBloqueDependencia());
		bloqueDependenciaModel.setNombreBloqueDependencia(bloqueDependencia.getNombreBloqueDependenciaa());
		numeroDependenciaModel.setIdNumeroDependencia(numeroDependencia.getIdNumeroDependencia());
		numeroDependenciaModel.setNumeroDependencia(numeroDependencia.getNumeroDependencia());
		
		maquinaModel.setIdMaquina(maquina.getIdMaquina());
		maquinaModel.setBloqueDependencia(bloqueDependenciaModel);
		maquinaModel.setNumeroComputador(maquina.getNumeroComputador());
		maquinaModel.setNumeroDependencia(numeroDependenciaModel);
		
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
		mostrarLista.setDeclaracionTecnico(incidenteEntity.getDeclaracionTecnico());
		mostrarLista.setDeclaracionEscalonamiento(incidenteEntity.getDeclaracionEscalonamiento());
		mostrarLista.setFechaSolucion(incidenteEntity.getFechaSolucion());
		mostrarLista.setIdTecnicoEscalono(incidenteEntity.getIdTecnicoEscalono());
		
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
