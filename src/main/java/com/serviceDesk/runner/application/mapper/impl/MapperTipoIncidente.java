package com.serviceDesk.runner.application.mapper.impl;

import org.springframework.stereotype.Service;

import com.serviceDesk.runner.application.entities.TipoIncidente;
import com.serviceDesk.runner.application.mapper.IMapperTipoIncidente;
import com.serviceDesk.runner.application.model.TipoIncidenteModel;

@Service
public class MapperTipoIncidente implements IMapperTipoIncidente{

	@Override
	public TipoIncidenteModel mappearTipoIncidente(TipoIncidente listaTipoIncidente) {
		TipoIncidenteModel listTipoIncidenteModel = new TipoIncidenteModel();
		listTipoIncidenteModel.setIdTipoIncidente(listaTipoIncidente.getIdTipoIncidente());
		listTipoIncidenteModel.setNombreTipoIncidente(listaTipoIncidente.getNombreTipoIncidente());
		return listTipoIncidenteModel;
	}
	
}
