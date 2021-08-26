package com.serviceDesk.runner.application.mapper;

import com.serviceDesk.runner.application.entities.TipoIncidente;
import com.serviceDesk.runner.application.model.TipoIncidenteModel;

public interface IMapperTipoIncidente {
	public TipoIncidenteModel mappearTipoIncidente(TipoIncidente listaTipoIncidente);
}
