package com.serviceDesk.runner.application.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.serviceDesk.runner.application.entities.Usuario;

public interface IUsuarioDao extends JpaRepository<Usuario, Integer>{

	@Query(value = "SELECT usuario FROM Usuario usuario WHERE usuario.numeroDocumento = :numeroDocumento", nativeQuery = false)
	public Optional<Usuario> obtenerUsuarioDocumento(@Param("numeroDocumento") String numeroDocumento);
}
