package com.serviceDesk.runner.application.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.serviceDesk.runner.application.entities.Tecnico;

public interface ITecnicoDao extends JpaRepository<Tecnico, Integer>{

	@Query(value = "SELECT tecnico FROM Tecnico tecnico WHERE tecnico.nombres = :nombres", nativeQuery = false)
	public Optional<Tecnico> obtenerTecnicoPorNombre(@Param("nombres")String nombres);

	@Query(value = "SELECT tecnico FROM Tecnico tecnico WHERE tecnico.correo = :correo AND tecnico.contrasena = :contrasena", nativeQuery = false)
	public Optional<Tecnico> getUserAndPasswordOfTheTechnician(@Param("correo")String correo, @Param ("contrasena") String contrasena);
	
	@Query(value = "SELECT tecnico FROM Tecnico tecnico WHERE tecnico.correo = :correo ", nativeQuery = false)
	public Optional<Tecnico> getUserOfTheTechnician(@Param("correo")String correo);
	
	@Query(value = "SELECT tecnico FROM Tecnico tecnico WHERE tecnico.contrasena = :contrasena ", nativeQuery = false)
	public Optional<Tecnico> getPasswordOfTheTechnician(@Param("contrasena")String contrasena);
}
