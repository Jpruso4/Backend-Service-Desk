package com.serviceDesk.runner.application.business.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.serviceDesk.runner.application.business.IUsuarioBusiness;
import com.serviceDesk.runner.application.entities.Usuario;
import com.serviceDesk.runner.application.model.Response;
import com.serviceDesk.runner.application.model.UsuarioModel;
import com.serviceDesk.runner.application.repository.ITipoDocumentoRepository;
import com.serviceDesk.runner.application.repository.ITipoUsuarioRepository;
import com.serviceDesk.runner.application.repository.IUsuarioRespository;
import com.serviceDesk.runner.application.service.IUsuarioService;
import com.serviceDesk.runner.application.util.CodigosError;
import com.serviceDesk.runner.application.util.MensajesError;

public class UsuarioBusiness implements IUsuarioBusiness {

	private final IUsuarioService iUsuarioService;
	private final IUsuarioRespository iUsuarioRespository;
	private final ITipoUsuarioRepository iTipoUsuarioRepository;
	private final ITipoDocumentoRepository iTipoDocumentoRepository;

	@Autowired
	public UsuarioBusiness(IUsuarioService iUsuarioService, IUsuarioRespository iUsuarioRespository,
			ITipoUsuarioRepository iTipoUsuarioRepository, ITipoDocumentoRepository iTipoDocumentoRepository) {
		this.iUsuarioService = iUsuarioService;
		this.iUsuarioRespository = iUsuarioRespository;
		this.iTipoUsuarioRepository = iTipoUsuarioRepository;
		this.iTipoDocumentoRepository = iTipoDocumentoRepository;
	}

	@Override
	public Response<Boolean> registrarUsuario(UsuarioModel datosUsuarioNuevo) {
		Usuario registroUsuarioNuevo = new Usuario();

		if (iUsuarioRespository.consultarExistenciaUsuario(datosUsuarioNuevo.getNumeroDocumento()))
			return new Response<Boolean>(CodigosError.COD_USUARIO_EXISTENTE, MensajesError.USUARIO_EXISTENTE, null);

		if (!iTipoDocumentoRepository
				.consultarExistenciaTipoDocumento(datosUsuarioNuevo.getTipoDocumento().getIdTipoDocumento()))
			return new Response<Boolean>(CodigosError.COD_TIPO_DE_DOCUMENTO_INEXISTENTE, MensajesError.TIPO_DE_DOCUMENTO_INEXISTENTE, null);

		registroUsuarioNuevo.setTipoDocumento(iTipoDocumentoRepository
				.obtenerDatosTipoDocumento(datosUsuarioNuevo.getTipoDocumento().getIdTipoDocumento()).get());

		if (!iTipoUsuarioRepository
				.consultarExistenciaTipoUsuario(datosUsuarioNuevo.getTipoUsuario().getIdTipoUsuario()))
			return new Response<Boolean>(CodigosError.COD_TIPO_DE_USUARIO_INEXISTENTE, MensajesError.TIPO_DE_USUARIO_INEXISTENTE, null);

		registroUsuarioNuevo.setTipoUsuario(iTipoUsuarioRepository
				.obtenerDatosTipoUsuario(datosUsuarioNuevo.getTipoUsuario().getIdTipoUsuario()).get());
		
		registroUsuarioNuevo.setNumeroDocumento(datosUsuarioNuevo.getNumeroDocumento());
		registroUsuarioNuevo.setPrimerNombre(datosUsuarioNuevo.getPrimerNombre());
		registroUsuarioNuevo.setSegundoNombre(datosUsuarioNuevo.getSegundoNombre());
		registroUsuarioNuevo.setPrimerApellido(datosUsuarioNuevo.getPrimerApellido());
		registroUsuarioNuevo.setSegundoApellido(datosUsuarioNuevo.getSegundoApellido());
		registroUsuarioNuevo.setTelefono(datosUsuarioNuevo.getTelefono());
		registroUsuarioNuevo.setCelular(datosUsuarioNuevo.getCelular());
		registroUsuarioNuevo.setCorreo(datosUsuarioNuevo.getCorreo());
		return iUsuarioService.registrarUsuario(registroUsuarioNuevo);
	}

}
