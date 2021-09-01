package com.serviceDesk.runner.application.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.serviceDesk.runner.application.entities.BloqueDependencia;

public interface IBloqueDependenciaDao extends JpaRepository<BloqueDependencia, Integer>{

	@Query(value = "SELECT bloqueDependencia FROM BloqueDependencia bloqueDependencia WHERE bloqueDependencia.nombreBloqueDependencia = :nombreBloqueDependencia", nativeQuery = false)
	public Optional<BloqueDependencia> buscarPorNombre(@Param("nombreBloqueDependencia")String nombreBloqueDependencia);

}
