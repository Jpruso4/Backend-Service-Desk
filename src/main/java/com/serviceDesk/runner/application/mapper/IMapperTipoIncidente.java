package com.serviceDesk.runner.application.mapper;

import com.serviceDesk.runner.application.entities.TipoIncidente;
import com.serviceDesk.runner.application.models.TipoIncidenteModel;

public interface IMapperTipoIncidente {
	public TipoIncidenteModel mostrarTipoIncidente(TipoIncidente listaTipoIncidente);
}
