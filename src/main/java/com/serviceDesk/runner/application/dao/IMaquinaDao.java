package com.serviceDesk.runner.application.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.serviceDesk.runner.application.entities.Maquina;

public interface IMaquinaDao extends JpaRepository<Maquina, Integer>{

	@Query(value = "SELECT maquina FROM Maquina maquina WHERE maquina.numeroComputador = :numeroComputador AND maquina.numeroDependencia.idNumeroDependencia = :numeroDependencia AND maquina.bloqueDependencia.idBloqueDependencia =:bloqueDependencia", nativeQuery = false)
	public Optional<Maquina> obtenerMaquinaPorSalon(@Param("numeroComputador") int numeroComputador, @Param("numeroDependencia") int numeroDependencia, @Param("bloqueDependencia") int bloqueDependencia);
}
