package com.serviceDesk.runner.application.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serviceDesk.runner.application.entities.TipoDependencia;

public interface ITipoDependenciaDao extends JpaRepository<TipoDependencia, Integer>{

}
