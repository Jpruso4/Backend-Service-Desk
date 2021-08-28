package com.serviceDesk.runner.application.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serviceDesk.runner.application.entities.TipoUsuario;

public interface ITipoUsuarioDao extends JpaRepository<TipoUsuario, Integer>{

}
