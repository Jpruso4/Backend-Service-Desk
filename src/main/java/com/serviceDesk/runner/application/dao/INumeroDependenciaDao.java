package com.serviceDesk.runner.application.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.serviceDesk.runner.application.entities.NumeroDependencia;

public interface INumeroDependenciaDao extends JpaRepository<NumeroDependencia, Integer>{

	@Query(value = "SELECT numeroDependencia FROM NumeroDependencia numeroDependencia WHERE numeroDependencia.numeroDependencia = :numeroDependencia", nativeQuery = false)
	Optional<NumeroDependencia> buscarPorNombre(@Param("numeroDependencia") String numeroDependencia);
	
}
