package com.serviceDesk.runner.application.util;

import java.util.Optional;

import com.serviceDesk.runner.application.dao.ITecnicoDao;
import com.serviceDesk.runner.application.entities.Tecnico;

public class Validaciones {
	
	public boolean validarEmailTecnico (String email, ITecnicoDao iTecnicoDao) {
		Optional<Tecnico> technicalEmailData = iTecnicoDao.getUserOfTheTechnician(email);
		if (!technicalEmailData.isPresent()) {
			 return false;
		}
		return true;
	}
	
	public boolean validarUsuarioYContraseñaTecnico(String email, String password, ITecnicoDao iTecnicoDao) {
		Optional<Tecnico> technicalData = iTecnicoDao.getUserAndPasswordOfTheTechnician(email, password);
		if (!technicalData.isPresent()) {
			return false; 
		}
		return true;
	}
	
}
