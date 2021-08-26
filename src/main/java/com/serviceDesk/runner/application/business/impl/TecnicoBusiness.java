package com.serviceDesk.runner.application.business.impl;

import com.serviceDesk.runner.application.business.ITecnicoBusiness;
import com.serviceDesk.runner.application.service.ITecnicoService;

public class TecnicoBusiness implements ITecnicoBusiness{

	private final ITecnicoService iTecnicoService;
	
	public TecnicoBusiness (ITecnicoService iTecnicoService) {
		this.iTecnicoService = iTecnicoService;
	}
}
