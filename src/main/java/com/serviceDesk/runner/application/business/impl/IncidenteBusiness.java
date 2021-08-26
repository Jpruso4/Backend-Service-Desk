package com.serviceDesk.runner.application.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.serviceDesk.runner.application.business.IIncidenteBusiness;
import com.serviceDesk.runner.application.entities.Incidente;
import com.serviceDesk.runner.application.model.IncidenteModel;
import com.serviceDesk.runner.application.model.Response;
import com.serviceDesk.runner.application.repository.IMaquinaRespository;
import com.serviceDesk.runner.application.repository.ITecnicoRepository;
import com.serviceDesk.runner.application.repository.ITipoIncidenteRepository;
import com.serviceDesk.runner.application.repository.IUsuarioRespository;
import com.serviceDesk.runner.application.service.IIncidenteService;
import com.serviceDesk.runner.application.util.MensajesError;

public class IncidenteBusiness implements IIncidenteBusiness {

	private final IIncidenteService iIncidenteService;
	private final IUsuarioRespository iUsuarioRespository;
	private final IMaquinaRespository iMaquinaRespository;
	private final ITecnicoRepository iTecnicoRepository;
	private final ITipoIncidenteRepository iTipoIncidenteRepository;

	@Autowired
	public IncidenteBusiness(IIncidenteService iIncidenteService, IUsuarioRespository iUsuarioRespository,
			IMaquinaRespository iMaquinaRespository, ITecnicoRepository iTecnicoRepository,
			ITipoIncidenteRepository iTipoIncidenteRepository) {
		this.iIncidenteService = iIncidenteService;
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
			return new Response<Boolean>(null, MensajesError.USUARIO_INEXISTENTE, null);
		registroIncidente.setUsuario(
				iUsuarioRespository.obtenerDatosUsuario(datosIncidenteNuevo.getUsuario().getNumeroDocumento()).get());

		if (!iMaquinaRespository.consultarExisteMaquinaSalon(datosIncidenteNuevo.getMaquina().getNumeroComputador(),
				datosIncidenteNuevo.getMaquina().getNumeroDependencia(),
				datosIncidenteNuevo.getMaquina().getBloqueDependencia()))
			return new Response<Boolean>(null, MensajesError.MAQUINA_INEXISTENTE, null);
		registroIncidente.setMaquina(
				iMaquinaRespository.obtenerMaquinaPorSalon(datosIncidenteNuevo.getMaquina().getNumeroComputador(),
						datosIncidenteNuevo.getMaquina().getNumeroDependencia(),
						datosIncidenteNuevo.getMaquina().getBloqueDependencia()).get());
		
		if (datosIncidenteNuevo.getTecnico().getNombres() == "") {
			registroIncidente.setTecnico(iTecnicoRepository.obtenerDatosTecnico("call").get());
			registroIncidente.setEstado(0);
		} else {
			if(iTecnicoRepository.consultarExistenciaTecnico(datosIncidenteNuevo.getTecnico().getNombres())) {
				registroIncidente.setTecnico(iTecnicoRepository.obtenerDatosTecnico(datosIncidenteNuevo.getTecnico().getNombres()).get());
				registroIncidente.setEstado(1);
			}else 
				return new Response<Boolean>(null, MensajesError.TECHNICIAN_NON_EXISTENT, null);	
		}

		if(!iTipoIncidenteRepository.consultarExistenciaTipoIncidente(datosIncidenteNuevo.getTipoIncidente().getNombreTipoIncidente()))
			return new Response<Boolean>(null, MensajesError.TIPO_DE_INCIDENTE_INEXISTENTE, null);	
		registroIncidente.setTipoIncidente(iTipoIncidenteRepository.obtenerDatosTipoIncidente(datosIncidenteNuevo.getTipoIncidente().getNombreTipoIncidente()).get());
	
		registroIncidente.setProblemaUsuario(datosIncidenteNuevo.getProblemaUsuario());
		registroIncidente.setDeclaracionCallcenter(datosIncidenteNuevo.getDeclaracionCallcenter());
		return iIncidenteService.registrarIncidente(registroIncidente);
	}

}
