package com.serviceDesk.runner.application.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.serviceDesk.runner.application.entities.Tecnico;

public interface ITecnicoDao extends JpaRepository<Tecnico, Integer>{

	@Query(value = "SELECT tecnico FROM Tecnico tecnico WHERE tecnico.nombres = :nombres", nativeQuery = false)
	public Optional<Tecnico> obtenerTecnicoPorNombre(@Param("nombres")String nombres);

}
