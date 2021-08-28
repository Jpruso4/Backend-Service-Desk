package com.serviceDesk.runner.application.business.impl;

import java.util.List;
import java.util.Optional;

import com.serviceDesk.runner.application.business.ITecnicoBusiness;
import com.serviceDesk.runner.application.entities.Tecnico;
import com.serviceDesk.runner.application.entities.TipoDocumento;
import com.serviceDesk.runner.application.entities.TipoTecnico;
import com.serviceDesk.runner.application.model.Response;
import com.serviceDesk.runner.application.model.TecnicoModel;
import com.serviceDesk.runner.application.repository.ITecnicoRepository;
import com.serviceDesk.runner.application.repository.ITipoDocumentoRepository;
import com.serviceDesk.runner.application.repository.ITipoTecnicoRepository;
import com.serviceDesk.runner.application.service.ITecnicoService;
import com.serviceDesk.runner.application.util.CodigosError;
import com.serviceDesk.runner.application.util.MensajesError;

public class TecnicoBusiness implements ITecnicoBusiness {

	private final ITecnicoService iTecnicoService;
	private final ITipoDocumentoRepository iTipoDocumentoRepository;
	private final ITipoTecnicoRepository iTipoTecnicoRepository;
	private final ITecnicoRepository iTecnicoRepository;

	public TecnicoBusiness(ITecnicoService iTecnicoService, ITipoDocumentoRepository iTipoDocumentoRepository,
			ITipoTecnicoRepository iTipoTecnicoRepository, ITecnicoRepository iTecnicoRepository) {
		this.iTecnicoService = iTecnicoService;
		this.iTipoDocumentoRepository = iTipoDocumentoRepository;
		this.iTipoTecnicoRepository = iTipoTecnicoRepository;
		this.iTecnicoRepository = iTecnicoRepository;
	}

	@Override
	public Response<List<TecnicoModel>> mostrarListaTecnicos() {
		return iTecnicoService.mostrarListaTecnicos();
	}

	@Override
	public Response<TecnicoModel> mostrarTecnico(Integer idTecnico) {
		return iTecnicoService.mostrarTecnico(idTecnico);
	}

	@Override
	public Response<Boolean> registrarTecnico(TecnicoModel datosTecnicoNuevo) {
		Tecnico registroNuevoTecnico = new Tecnico();

		if (!iTipoDocumentoRepository
				.consultarExistenciaTipoDocumento(datosTecnicoNuevo.getTipoDocumento().getIdTipoDocumento()))
			return new Response<Boolean>(CodigosError.COD_TIPO_DE_DOCUMENTO_INEXISTENTE, MensajesError.TIPO_DE_DOCUMENTO_INEXISTENTE, null);

		registroNuevoTecnico.setTipoDocumento(
				iTipoDocumentoRepository.obtenerDatosTipoDocumento(datosTecnicoNuevo.getIdTecnico()).get());

		if (!iTipoTecnicoRepository
				.consultarExistenciaTipoTecnico(datosTecnicoNuevo.getTipoTecnico().getIdTipoTecnico()))
			return new Response<Boolean>(CodigosError.COD_TIPO_DE_TECNICO_INEXISTENTE, MensajesError.TIPO_DE_TECNICO_INEXISTENTE, null);

		registroNuevoTecnico.setTipoTecnico(iTipoTecnicoRepository
				.obtenerDatosTipoTecnico(datosTecnicoNuevo.getTipoTecnico().getIdTipoTecnico()).get());

		registroNuevoTecnico.setNumeroDocumento(datosTecnicoNuevo.getNumeroDocumento());
		registroNuevoTecnico.setNombres(datosTecnicoNuevo.getNombres());
		registroNuevoTecnico.setApellidos(datosTecnicoNuevo.getApellidos());
		registroNuevoTecnico.setTelefono(datosTecnicoNuevo.getTelefono());
		registroNuevoTecnico.setCelular(datosTecnicoNuevo.getCelular());
		registroNuevoTecnico.setCorreo(datosTecnicoNuevo.getCorreo());
		registroNuevoTecnico.setContrasena(datosTecnicoNuevo.getContrasena());
		return iTecnicoService.registrarTecnico(registroNuevoTecnico);
	}

	@Override
	public Response<Boolean> actualizarTecnico(TecnicoModel datosTecnicoModificar) {

		if (!iTecnicoRepository.consultarExistenciaTecnico(datosTecnicoModificar.getIdTecnico()))
			return new Response<Boolean>(CodigosError.COD_TECHNICIAN_NON_EXISTENT, MensajesError.TECHNICIAN_NON_EXISTENT, null);

		if (!iTipoDocumentoRepository
				.consultarExistenciaTipoDocumento(datosTecnicoModificar.getTipoDocumento().getIdTipoDocumento()))
			return new Response<Boolean>(CodigosError.COD_TIPO_DE_DOCUMENTO_INEXISTENTE, MensajesError.TIPO_DE_DOCUMENTO_INEXISTENTE, null);

		if (!iTipoTecnicoRepository
				.consultarExistenciaTipoTecnico(datosTecnicoModificar.getTipoTecnico().getIdTipoTecnico()))
			return new Response<Boolean>(CodigosError.COD_TIPO_DE_TECNICO_INEXISTENTE, MensajesError.TIPO_DE_TECNICO_INEXISTENTE, null);

		Tecnico tecnicoModificar = validarCambiosActualizarTecnico(
				iTecnicoRepository.obtenerDatosTecnico(datosTecnicoModificar.getIdTecnico()), datosTecnicoModificar,
				iTipoDocumentoRepository
						.obtenerDatosTipoDocumento(datosTecnicoModificar.getTipoDocumento().getIdTipoDocumento()),
				iTipoTecnicoRepository
						.obtenerDatosTipoTecnico(datosTecnicoModificar.getTipoTecnico().getIdTipoTecnico()));

		return iTecnicoService.actualizarTecnico(tecnicoModificar);
	}

	@Override
	public Response<Boolean> eliminarTecnico(Integer idTecnico) {
		return iTecnicoService.eliminarTecnico(idTecnico, iTecnicoRepository.consultarExistenciaTecnico(idTecnico));
	}

	private Tecnico validarCambiosActualizarTecnico(Optional<Tecnico> datosTecnicoBD,
			TecnicoModel datosTecnicoModificar, Optional<TipoDocumento> datosTipoDocumentoBD,
			Optional<TipoTecnico> datosTipoTecnicoBD) {
		
		Tecnico tecnicoData = datosTecnicoBD.get();
		TipoDocumento tipoDocumento = datosTipoDocumentoBD.get();
		TipoTecnico tipoTecnico = datosTipoTecnicoBD.get();
		
		tecnicoData.setTipoDocumento(tipoDocumento);
		tecnicoData.setTipoTecnico(tipoTecnico);
		
		if (!(tecnicoData.getNumeroDocumento() == datosTecnicoModificar.getNumeroDocumento()))
			tecnicoData.setNumeroDocumento(datosTecnicoModificar.getNumeroDocumento());
		
		if(!(tecnicoData.getNombres().equals(datosTecnicoModificar.getNombres())))
			tecnicoData.setNombres(datosTecnicoModificar.getNombres());
		
		if(!(tecnicoData.getApellidos().equals(datosTecnicoModificar.getApellidos())))
			tecnicoData.setApellidos(datosTecnicoModificar.getApellidos());
		
		if(!(tecnicoData.getTelefono().equals(datosTecnicoModificar.getTelefono())))
			tecnicoData.setTelefono(datosTecnicoModificar.getTelefono());
		
		if(!(tecnicoData.getCelular().equals(datosTecnicoModificar.getCelular())))
			tecnicoData.setCelular(datosTecnicoModificar.getCelular());
		
		if(!(tecnicoData.getCorreo().equals(datosTecnicoModificar.getCorreo())))
			tecnicoData.setCorreo(datosTecnicoModificar.getCorreo());
		
		if(!(tecnicoData.getContrasena().equals(datosTecnicoModificar.getContrasena())))
			tecnicoData.setContrasena(datosTecnicoModificar.getContrasena());
		
		return tecnicoData;
	}
}
