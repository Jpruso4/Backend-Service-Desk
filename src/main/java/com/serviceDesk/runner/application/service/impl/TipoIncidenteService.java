package com.serviceDesk.runner.application.service.impl;

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.serviceDesk.runner.application.dao.ITipoIncidenteDao;
import com.serviceDesk.runner.application.entities.TipoIncidente;
import com.serviceDesk.runner.application.mapper.IMapperTipoIncidente;
import com.serviceDesk.runner.application.models.TipoIncidenteModel;
import com.serviceDesk.runner.application.service.ITipoIncidenteService;

public class TipoIncidenteService implements ITipoIncidenteService{
	
	private final ITipoIncidenteDao iTipoIncidenteDao;
	private final IMapperTipoIncidente iMapperTipoIncidente;
	
	@Autowired
	public TipoIncidenteService(ITipoIncidenteDao iTipoIncidenteDao,  IMapperTipoIncidente iMapperTipoIncidente) {
		this.iTipoIncidenteDao = iTipoIncidenteDao;
		this.iMapperTipoIncidente = iMapperTipoIncidente;
	}

	@Override
	public List<TipoIncidenteModel> mostrarListaIncidentes() {
		List<TipoIncidenteModel> tipoIncidentes = new LinkedList<>();
		List<TipoIncidente> tipoIncidenteEntities = iTipoIncidenteDao.findAll();
		for(TipoIncidente tipoIncidente : tipoIncidenteEntities) {
			tipoIncidentes.add(iMapperTipoIncidente.mostrarTipoIncidente(tipoIncidente));
		}
		return tipoIncidentes;
	}

}
