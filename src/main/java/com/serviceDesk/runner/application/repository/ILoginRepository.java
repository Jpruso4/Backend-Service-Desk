package com.serviceDesk.runner.application.repository;

public interface ILoginRepository {
	public boolean validarEmailTecnico (String email);
	public boolean validarUsuarioYContraseñaTecnico(String email, String password);
}
