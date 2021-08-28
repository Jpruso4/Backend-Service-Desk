package com.serviceDesk.runner.application.mapper;

import com.serviceDesk.runner.application.entities.Tecnico;
import com.serviceDesk.runner.application.model.TecnicoModel;

public interface IMapperTecnico {
	TecnicoModel mappearTecnico(Tecnico tecnicoData);
}
