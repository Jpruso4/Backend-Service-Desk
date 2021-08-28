package com.serviceDesk.runner.application.mapper.impl;

import org.springframework.stereotype.Service;

import com.serviceDesk.runner.application.entities.Tecnico;
import com.serviceDesk.runner.application.entities.TipoDocumento;
import com.serviceDesk.runner.application.entities.TipoTecnico;
import com.serviceDesk.runner.application.mapper.IMapperTecnico;
import com.serviceDesk.runner.application.model.TecnicoModel;
import com.serviceDesk.runner.application.model.TipoDocumentoModel;
import com.serviceDesk.runner.application.model.TipoTecnicoModel;

@Service
public class MapperTecnico implements IMapperTecnico{

	@Override
	public TecnicoModel mappearTecnico(Tecnico tecnicoData) {
		TecnicoModel tecnicoMappeado = new TecnicoModel();
		
		tecnicoMappeado.setIdTecnico(tecnicoData.getIdTecnico());
		
		TipoDocumento tipoDocumentoData = tecnicoData.getTipoDocumento();
		TipoTecnico tipoTecnicoData = tecnicoData.getTipoTecnico();
		
		TipoDocumentoModel tipoDocumentoModel = new TipoDocumentoModel();
		TipoTecnicoModel tipoTecnicoModel = new TipoTecnicoModel();
		
		tipoDocumentoModel.setIdTipoDocumento(tipoDocumentoData.getIdTipoDocumento());
		tipoDocumentoModel.setNombreDocumento(tipoDocumentoData.getNombreDocumento());
		tipoTecnicoModel.setIdTipoTecnico(tipoTecnicoData.getIdTipoTecnico());
		tipoTecnicoModel.setEspecialidad(tipoTecnicoData.getEspecialidad());
		
		tecnicoMappeado.setTipoDocumento(tipoDocumentoModel);
		tecnicoMappeado.setTipoTecnico(tipoTecnicoModel);
		tecnicoMappeado.setNumeroDocumento(tecnicoData.getNumeroDocumento());
		tecnicoMappeado.setNombres(tecnicoData.getNombres());
		tecnicoMappeado.setApellidos(tecnicoData.getApellidos());
		tecnicoMappeado.setTelefono(tecnicoData.getTelefono());
		tecnicoMappeado.setCelular(tecnicoData.getCelular());
		tecnicoMappeado.setCorreo(tecnicoData.getCorreo());
		tecnicoMappeado.setContrasena(tecnicoData.getContrasena());
		return tecnicoMappeado;
	}

}
