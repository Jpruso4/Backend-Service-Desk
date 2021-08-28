package com.serviceDesk.runner.application.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serviceDesk.runner.application.entities.TipoTecnico;

public interface ITipoTecnicoDao extends JpaRepository<TipoTecnico, Integer>{

}
