package com.serviceDesk.runner.application.mapper.impl;

import com.serviceDesk.runner.application.entities.TipoIncidente;
import com.serviceDesk.runner.application.mapper.IMapperTipoIncidente;
import com.serviceDesk.runner.application.model.TipoIncidenteModel;

public class MapperTipoIncidente implements IMapperTipoIncidente{

	@Override
	public TipoIncidenteModel mostrarTipoIncidente(TipoIncidente listaTipoIncidente) {
		TipoIncidenteModel listTipoIncidenteModel = new TipoIncidenteModel();
		listTipoIncidenteModel.setIdTipoIncidente(listaTipoIncidente.getIdTipoIncidente());
		listTipoIncidenteModel.setNombreTipoIncidente(listaTipoIncidente.getNombreTipoIncidente());
		return listTipoIncidenteModel;
	}
	
}
