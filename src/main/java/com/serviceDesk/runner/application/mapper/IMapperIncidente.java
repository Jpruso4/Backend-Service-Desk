package com.serviceDesk.runner.application.mapper;

import com.serviceDesk.runner.application.entities.Incidente;
import com.serviceDesk.runner.application.model.IncidenteModel;

public interface IMapperIncidente {
	public IncidenteModel mostrarIncidente(Incidente listaIncidente);
}
