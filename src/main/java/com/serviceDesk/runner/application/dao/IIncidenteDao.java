package com.serviceDesk.runner.application.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serviceDesk.runner.application.entities.Incidente;

public interface IIncidenteDao  extends JpaRepository<Incidente, Integer>{
	
}
