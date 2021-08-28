package com.serviceDesk.runner.application.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.serviceDesk.runner.application.entities.Incidente;

public interface IIncidenteDao  extends JpaRepository<Incidente, Integer>{
	
	@Query(value = "select count(tecnico.idTecnico) as numero_de_repeticiones from Incidente incidente group by incidente.tecnico.idTecnico" , nativeQuery = false)
	public List<Integer> obtenerIdTecnicoMasRepetido();
}
