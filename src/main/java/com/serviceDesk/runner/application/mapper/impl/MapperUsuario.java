package com.serviceDesk.runner.application.mapper.impl;

import org.springframework.stereotype.Service;

import com.serviceDesk.runner.application.entities.TipoDocumento;
import com.serviceDesk.runner.application.entities.TipoUsuario;
import com.serviceDesk.runner.application.entities.Usuario;
import com.serviceDesk.runner.application.model.TipoDocumentoModel;
import com.serviceDesk.runner.application.model.TipoUsuarioModel;
import com.serviceDesk.runner.application.model.UsuarioModel;

@Service
public class MapperUsuario {

	public UsuarioModel mostrarUsuario(Usuario usuarioEntity) {
		UsuarioModel mostrarUsuario = new UsuarioModel();
		mostrarUsuario.setIdUsuario(usuarioEntity.getIdUsuario());

		TipoDocumento tipoDocumento = usuarioEntity.getTipoDocumento();
		TipoDocumentoModel tipoDocumentoModel = new TipoDocumentoModel();

		TipoUsuario tipoUsuario = usuarioEntity.getTipoUsuario();
		TipoUsuarioModel tipoUsuarioModel = new TipoUsuarioModel();

		tipoDocumentoModel.setIdTipoDocumento(tipoDocumento.getIdTipoDocumento());
		tipoDocumentoModel.setNombreDocumento(tipoDocumento.getNombreDocumento());
		
		tipoUsuarioModel.setIdTipoUsuario(tipoUsuario.getIdTipoUsuario());
		tipoUsuarioModel.setNombreTipoUsuario(tipoUsuario.getNombreTipoUsuario());

		mostrarUsuario.setTipoDocumento(tipoDocumentoModel);
		mostrarUsuario.setTipoUsuario(tipoUsuarioModel);
		mostrarUsuario.setNumeroDocumento(usuarioEntity.getNumeroDocumento());
		mostrarUsuario.setPrimerNombre(usuarioEntity.getPrimerNombre());
		mostrarUsuario.setSegundoNombre(usuarioEntity.getSegundoNombre());
		mostrarUsuario.setPrimerApellido(usuarioEntity.getPrimerApellido());
		mostrarUsuario.setSegundoApellido(usuarioEntity.getSegundoApellido());
		mostrarUsuario.setTelefono(usuarioEntity.getTelefono());
		mostrarUsuario.setCelular(usuarioEntity.getCelular());
		mostrarUsuario.setCorreo(usuarioEntity.getCorreo());
		return mostrarUsuario;
	}
}
