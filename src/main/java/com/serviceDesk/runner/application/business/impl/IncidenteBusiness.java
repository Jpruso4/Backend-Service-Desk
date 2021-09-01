package com.serviceDesk.runner.application.business.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.serviceDesk.runner.application.business.IIncidenteBusiness;
import com.serviceDesk.runner.application.entities.Incidente;
import com.serviceDesk.runner.application.entities.Maquina;
import com.serviceDesk.runner.application.entities.Tecnico;
import com.serviceDesk.runner.application.entities.TipoIncidente;
import com.serviceDesk.runner.application.entities.Usuario;
import com.serviceDesk.runner.application.model.IncidenteModel;
import com.serviceDesk.runner.application.model.Response;
import com.serviceDesk.runner.application.repository.IIncidenteRepository;
import com.serviceDesk.runner.application.repository.IMaquinaRespository;
import com.serviceDesk.runner.application.repository.ITecnicoRepository;
import com.serviceDesk.runner.application.repository.ITipoIncidenteRepository;
import com.serviceDesk.runner.application.repository.IUsuarioRespository;
import com.serviceDesk.runner.application.service.IIncidenteService;
import com.serviceDesk.runner.application.util.CodigosError;
import com.serviceDesk.runner.application.util.MensajesError;

public class IncidenteBusiness implements IIncidenteBusiness {

	private final IIncidenteService iIncidenteService;
	private final IIncidenteRepository iIncidenteRepository;
	private final IUsuarioRespository iUsuarioRespository;
	private final IMaquinaRespository iMaquinaRespository;
	private final ITecnicoRepository iTecnicoRepository;
	private final ITipoIncidenteRepository iTipoIncidenteRepository;

	@Autowired
	public IncidenteBusiness(IIncidenteService iIncidenteService, IIncidenteRepository iIncidenteRepository,
			IUsuarioRespository iUsuarioRespository, IMaquinaRespository iMaquinaRespository,
			ITecnicoRepository iTecnicoRepository, ITipoIncidenteRepository iTipoIncidenteRepository) {
		this.iIncidenteService = iIncidenteService;
		this.iIncidenteRepository = iIncidenteRepository;
		this.iUsuarioRespository = iUsuarioRespository;
		this.iMaquinaRespository = iMaquinaRespository;
		this.iTecnicoRepository = iTecnicoRepository;
		this.iTipoIncidenteRepository = iTipoIncidenteRepository;
	}

	@Override
	public Response<IncidenteModel> mostrarIncidente(Integer idIncidente) {
		return iIncidenteService.mostrarIncidente(idIncidente);
	}

	@Override
	public Response<List<IncidenteModel>> mostrarListaIncidentes() {
		return iIncidenteService.mostrarListaIncidentes();
	}

	@Override
	public Response<Boolean> registrarIncidente(IncidenteModel datosIncidenteNuevo) {
		Incidente registroIncidente = new Incidente();

		registroIncidente.setFecha(datosIncidenteNuevo.getFecha());

		if (!iUsuarioRespository.consultarExistenciaUsuario(datosIncidenteNuevo.getUsuario().getNumeroDocumento()))
			return new Response<Boolean>(CodigosError.COD_USUARIO_INEXISTENTE, MensajesError.USUARIO_INEXISTENTE, null);
		registroIncidente.setUsuario(
				iUsuarioRespository.obtenerDatosUsuario(datosIncidenteNuevo.getUsuario().getNumeroDocumento()).get());

		if (!iMaquinaRespository.consultarExisteMaquinaSalon(datosIncidenteNuevo.getMaquina().getNumeroComputador(),
				datosIncidenteNuevo.getMaquina().getNumeroDependencia().getNumeroDependencia(),
				datosIncidenteNuevo.getMaquina().getBloqueDependencia().getNombreBloqueDependencia()))
			return new Response<Boolean>(CodigosError.COD_MAQUINA_INEXISTENTE, MensajesError.MAQUINA_INEXISTENTE, null);
		registroIncidente
				.setMaquina(iMaquinaRespository
						.obtenerMaquinaPorSalon(datosIncidenteNuevo.getMaquina().getNumeroComputador(),
								datosIncidenteNuevo.getMaquina().getNumeroDependencia().getNumeroDependencia(),
								datosIncidenteNuevo.getMaquina().getBloqueDependencia().getNombreBloqueDependencia())
						.get());

		if (datosIncidenteNuevo.getTecnico().getNombres() == "") {
			registroIncidente.setTecnico(iTecnicoRepository.obtenerDatosTecnicoPorNombres("call").get());
			registroIncidente.setEstado(0);
		} else {
			if (iTecnicoRepository
					.consultarExistenciaTecnicoPorNombres(datosIncidenteNuevo.getTecnico().getNombres())) {
				registroIncidente.setTecnico(iTecnicoRepository
						.obtenerDatosTecnicoPorNombres(datosIncidenteNuevo.getTecnico().getNombres()).get());
				registroIncidente.setEstado(1);
			} else
				return new Response<Boolean>(CodigosError.COD_TECHNICIAN_NON_EXISTENT,
						MensajesError.TECHNICIAN_NON_EXISTENT, null);
		}

		if (!iTipoIncidenteRepository.consultarExistenciaTipoIncidentePorNombre(
				datosIncidenteNuevo.getTipoIncidente().getNombreTipoIncidente()))
			return new Response<Boolean>(CodigosError.COD_TIPO_DE_INCIDENTE_INEXISTENTE,
					MensajesError.TIPO_DE_INCIDENTE_INEXISTENTE, null);
		registroIncidente.setTipoIncidente(iTipoIncidenteRepository
				.obtenerDatosTipoIncidentePorNombre(datosIncidenteNuevo.getTipoIncidente().getNombreTipoIncidente())
				.get());

		registroIncidente.setProblemaUsuario(datosIncidenteNuevo.getProblemaUsuario());
		registroIncidente.setDeclaracionCallcenter(datosIncidenteNuevo.getDeclaracionCallcenter());
		return iIncidenteService.registrarIncidente(registroIncidente);
	}

	@Override
	public Response<Boolean> actualizarIncidente(IncidenteModel datosIncidenteModificar) {
		if (!iIncidenteRepository.consultarExistenciaIncidente(datosIncidenteModificar.getIdIncidente()))
			return new Response<Boolean>(CodigosError.COD_INCIDENTE_INEXISTENTE, MensajesError.INCIDENTE_INEXISTENTE,
					null);

		if (!iMaquinaRespository.consultarExistenciaMaquina(datosIncidenteModificar.getMaquina().getIdMaquina()))
			return new Response<Boolean>(CodigosError.COD_MAQUINA_INEXISTENTE, MensajesError.MAQUINA_INEXISTENTE, null);

		if (!iTecnicoRepository.consultarExistenciaTecnico(datosIncidenteModificar.getTecnico().getIdTecnico()))
			return new Response<Boolean>(CodigosError.COD_TECHNICIAN_NON_EXISTENT,
					MensajesError.TECHNICIAN_NON_EXISTENT, null);

		if (!iTipoIncidenteRepository
				.consultarExistenciaTipoIncidente(datosIncidenteModificar.getTipoIncidente().getIdTipoIncidente()))
			return new Response<Boolean>(CodigosError.COD_TIPO_DE_INCIDENTE_INEXISTENTE,
					MensajesError.TIPO_DE_INCIDENTE_INEXISTENTE, null);

		if (!iUsuarioRespository.consultarExistenciaUsuario(datosIncidenteModificar.getUsuario().getNumeroDocumento()))
			return new Response<Boolean>(CodigosError.COD_USUARIO_INEXISTENTE, MensajesError.USUARIO_INEXISTENTE, null);

		Incidente incidenteModificar = validarCambiosActualizarIncidente(
				iIncidenteRepository.obtenerDatosIncidente(datosIncidenteModificar.getIdIncidente()),
				datosIncidenteModificar,
				iMaquinaRespository.obtenerDatosMaquina(datosIncidenteModificar.getMaquina().getIdMaquina()),
				iTecnicoRepository.obtenerDatosTecnico(datosIncidenteModificar.getTecnico().getIdTecnico()),
				iTipoIncidenteRepository
						.obtenerDatosTipoIncidente(datosIncidenteModificar.getTipoIncidente().getIdTipoIncidente()),
				iUsuarioRespository.obtenerDatosUsuario(datosIncidenteModificar.getUsuario().getNumeroDocumento()));
		return iIncidenteService.actualizarIncidente(incidenteModificar);
	}

	@Override
	public Response<Boolean> eliminarIncidente(Integer idIncidente) {
		return iIncidenteService.eliminarIncidente(idIncidente,
				iIncidenteRepository.consultarExistenciaIncidente(idIncidente));
	}

	private Incidente validarCambiosActualizarIncidente(Optional<Incidente> datosIncidenteBD,
			IncidenteModel datosIncidenteModificar, Optional<Maquina> datosMaquinaBD, Optional<Tecnico> datosTecnicoBD,
			Optional<TipoIncidente> datosTipoIncidenteBD, Optional<Usuario> datosUsuarioBD) {

		Incidente incidenteData = datosIncidenteBD.get();
		Maquina maquinaData = datosMaquinaBD.get();
		Tecnico tecnicoData = datosTecnicoBD.get();
		TipoIncidente tipoIncidenteData = datosTipoIncidenteBD.get();
		Usuario usuarioData = datosUsuarioBD.get();

		incidenteData.setMaquina(maquinaData);
		incidenteData.setTecnico(tecnicoData);
		incidenteData.setTipoIncidente(tipoIncidenteData);
		incidenteData.setUsuario(usuarioData);

		if (!(incidenteData.getProblemaUsuario().equals(datosIncidenteModificar.getProblemaUsuario())))
			incidenteData.setProblemaUsuario(datosIncidenteModificar.getProblemaUsuario());

		if (!(incidenteData.getFecha().equals(datosIncidenteModificar.getFecha())))
			incidenteData.setFecha(datosIncidenteModificar.getFecha());

		if (Objects.nonNull(incidenteData.getDeclaracionCallcenter())) {
			if (!(incidenteData.getDeclaracionCallcenter().equals(datosIncidenteModificar.getDeclaracionCallcenter())))
				incidenteData.setDeclaracionCallcenter(datosIncidenteModificar.getDeclaracionCallcenter());
		}

		if (!(incidenteData.getProblemaUsuario().equals(datosIncidenteModificar.getProblemaUsuario())))
			incidenteData.setProblemaUsuario(datosIncidenteModificar.getProblemaUsuario());

		if (!(incidenteData.getEstado() == (Integer.parseInt(datosIncidenteModificar.getEstado()))))
			incidenteData.setEstado(Integer.parseInt(datosIncidenteModificar.getEstado()));

		if (!(Objects.equals(null, datosIncidenteModificar.getDeclaracionTecnico()))
				&& !(Objects.equals(null, incidenteData.getDeclaracionTecnico()))) {
			if (!(incidenteData.getDeclaracionTecnico().equals(datosIncidenteModificar.getDeclaracionTecnico())))
				incidenteData.setDeclaracionTecnico(datosIncidenteModificar.getDeclaracionTecnico());
		} else {
			if ((Objects.equals(null, incidenteData.getDeclaracionTecnico()))
					&& !(Objects.equals(null, datosIncidenteModificar.getDeclaracionTecnico())))
				incidenteData.setDeclaracionTecnico(datosIncidenteModificar.getDeclaracionTecnico());
		}

		if (Objects.nonNull(incidenteData.getDeclaracionEscalonamiento())) {
			if (!(incidenteData.getDeclaracionEscalonamiento()
					.equals(datosIncidenteModificar.getDeclaracionEscalonamiento())))
				incidenteData.setDeclaracionEscalonamiento(datosIncidenteModificar.getDeclaracionEscalonamiento());
		}
			
		if(Objects.nonNull(datosIncidenteModificar.getFechaSolucion()))
			incidenteData.setFechaSolucion(datosIncidenteModificar.getFechaSolucion());
		
		if(Objects.nonNull(datosIncidenteModificar.getIdTecnicoEscalono())) {
			incidenteData.setIdTecnicoEscalono(datosIncidenteModificar.getIdTecnicoEscalono());
		}
			
		return incidenteData;
	}

}
