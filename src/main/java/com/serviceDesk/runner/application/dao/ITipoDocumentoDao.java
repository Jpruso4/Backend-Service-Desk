package com.serviceDesk.runner.application.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serviceDesk.runner.application.entities.TipoDocumento;

public interface ITipoDocumentoDao extends JpaRepository<TipoDocumento, Integer>{

}
