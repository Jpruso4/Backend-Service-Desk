package com.serviceDesk.runner.application.repository;

import com.serviceDesk.runner.application.dao.ITecnicoDao;

public interface ILoginRepository {
	public boolean validarEmailTecnico (String email, ITecnicoDao iTecnicoDao);
	public boolean validarUsuarioYContrase├▒aTecnico(String email, String password, ITecnicoDao iTecnicoDao);
}
