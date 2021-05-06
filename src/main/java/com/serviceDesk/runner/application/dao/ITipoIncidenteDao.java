package com.serviceDesk.runner.application.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.serviceDesk.runner.application.entities.TipoIncidente;

public interface ITipoIncidenteDao extends JpaRepository<TipoIncidente, Integer>{

	@Query(value = "SELECT tipoIncidente FROM TipoIncidente tipoIncidente WHERE tipoIncidente.nombreTipoIncidente = :nombreTipoIncidente", nativeQuery = false)
	public Optional<TipoIncidente> obtenerTipoIncidente(@Param("nombreTipoIncidente") String nombreTipoIncidente);

}
