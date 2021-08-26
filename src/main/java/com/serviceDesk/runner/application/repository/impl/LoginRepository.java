package com.serviceDesk.runner.application.repository.impl;

import java.util.Optional;

import com.serviceDesk.runner.application.dao.ITecnicoDao;
import com.serviceDesk.runner.application.entities.Tecnico;
import com.serviceDesk.runner.application.repository.ILoginRepository;

public class LoginRepository implements ILoginRepository{
	
	private final ITecnicoDao iTecnicoDao;
	
	public LoginRepository(ITecnicoDao iTecnicoDao) {
		this.iTecnicoDao = iTecnicoDao;
	}
	
	@Override
	public boolean validarEmailTecnico (String email) {
		Optional<Tecnico> technicalEmailData = iTecnicoDao.getUserOfTheTechnician(email);
		if (!technicalEmailData.isPresent()) {
			 return false;
		}
		return true;
	}
	
	@Override
	public boolean validarUsuarioYContraseñaTecnico(String email, String password) {
		Optional<Tecnico> technicalData = iTecnicoDao.getUserAndPasswordOfTheTechnician(email, password);
		if (!technicalData.isPresent()) {
			return false; 
		}
		return true;
	}
	
}
