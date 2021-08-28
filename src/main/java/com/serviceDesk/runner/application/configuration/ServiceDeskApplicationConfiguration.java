package com.serviceDesk.runner.application.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.serviceDesk.runner.application.business.impl.IncidenteBusiness;
import com.serviceDesk.runner.application.business.impl.LoginBusiness;
import com.serviceDesk.runner.application.business.impl.MaquinaBusiness;
import com.serviceDesk.runner.application.business.impl.TecnicoBusiness;
import com.serviceDesk.runner.application.business.impl.TipoIncidenteBusiness;
import com.serviceDesk.runner.application.business.impl.UsuarioBusiness;
import com.serviceDesk.runner.application.dao.IMaquinaDao;
import com.serviceDesk.runner.application.dao.ITecnicoDao;
import com.serviceDesk.runner.application.dao.ITipoDependenciaDao;
import com.serviceDesk.runner.application.dao.ITipoDocumentoDao;
import com.serviceDesk.runner.application.dao.ITipoIncidenteDao;
import com.serviceDesk.runner.application.dao.ITipoTecnicoDao;
import com.serviceDesk.runner.application.dao.ITipoUsuarioDao;
import com.serviceDesk.runner.application.dao.IUsuarioDao;
import com.serviceDesk.runner.application.repository.IIncidenteRepository;
import com.serviceDesk.runner.application.repository.IMaquinaRespository;
import com.serviceDesk.runner.application.repository.ITecnicoRepository;
import com.serviceDesk.runner.application.repository.ITipoDependenciaRepository;
import com.serviceDesk.runner.application.repository.ITipoDocumentoRepository;
import com.serviceDesk.runner.application.repository.ITipoIncidenteRepository;
import com.serviceDesk.runner.application.repository.ITipoTecnicoRepository;
import com.serviceDesk.runner.application.repository.ITipoUsuarioRepository;
import com.serviceDesk.runner.application.repository.IUsuarioRespository;
import com.serviceDesk.runner.application.repository.impl.LoginRepository;
import com.serviceDesk.runner.application.repository.impl.MaquinaRepository;
import com.serviceDesk.runner.application.repository.impl.TecnicoRepository;
import com.serviceDesk.runner.application.repository.impl.TipoDependenciaRepository;
import com.serviceDesk.runner.application.repository.impl.TipoDocumentoRepository;
import com.serviceDesk.runner.application.repository.impl.TipoIncidenteRespository;
import com.serviceDesk.runner.application.repository.impl.TipoTecnicoRepository;
import com.serviceDesk.runner.application.repository.impl.TipoUsuarioRepository;
import com.serviceDesk.runner.application.repository.impl.UsuarioRepository;
import com.serviceDesk.runner.application.service.IIncidenteService;
import com.serviceDesk.runner.application.service.ILoginService;
import com.serviceDesk.runner.application.service.IMaquinaService;
import com.serviceDesk.runner.application.service.ITecnicoService;
import com.serviceDesk.runner.application.service.ITipoIncidenteService;
import com.serviceDesk.runner.application.service.IUsuarioService;

@Configuration
public class ServiceDeskApplicationConfiguration {
	@Bean
	public LoginRepository getLoginRepository(ITecnicoDao iTecnicoDao) {
		return new LoginRepository(iTecnicoDao);
	}

	@Bean
	public TipoDependenciaRepository getTipoDependenciaRepository(ITipoDependenciaDao iTipoDependenciaDao) {
		return new TipoDependenciaRepository(iTipoDependenciaDao);
	}

	@Bean
	public MaquinaRepository getMaquinaRepository(IMaquinaDao iMaquinaDao) {
		return new MaquinaRepository(iMaquinaDao);
	}

	@Bean
	public IncidenteBusiness getIncidenteBusiness(IIncidenteService iIncidenteService,
			IIncidenteRepository iIncidenteRepository, IUsuarioRespository iUsuarioRespository,
			IMaquinaRespository iMaquinaRespository, ITecnicoRepository iTecnicoRepository,
			ITipoIncidenteRepository iTipoIncidenteRepository) {
		return new IncidenteBusiness(iIncidenteService, iIncidenteRepository, iUsuarioRespository, iMaquinaRespository,
				iTecnicoRepository, iTipoIncidenteRepository);
	}

	@Bean
	public LoginBusiness getLoginBusiness(ILoginService iLoginService) {
		return new LoginBusiness(iLoginService);
	}

	@Bean
	public MaquinaBusiness getMaquinaBusiness(IMaquinaService iMaquinaService,
			ITipoDependenciaRepository iTipoDependenciaRepository, ITipoDependenciaDao iTipoDependenciaDao,
			IMaquinaRespository iMaquinaRepository, IMaquinaDao iMaquinaDao) {
		return new MaquinaBusiness(iMaquinaService, iTipoDependenciaRepository, iTipoDependenciaDao, iMaquinaRepository,
				iMaquinaDao);
	}

	@Bean
	public TecnicoBusiness getTecnicoBusiness(ITecnicoService iTecnicoService,
			ITipoDocumentoRepository iTipoDocumentoRepository, ITipoTecnicoRepository iTipoTecnicoRepository,
			ITecnicoRepository iTecnicoRepository) {
		return new TecnicoBusiness(iTecnicoService, iTipoDocumentoRepository, iTipoTecnicoRepository,
				iTecnicoRepository);
	}

	@Bean
	public TipoIncidenteBusiness getTipoIncidenteBusiness(ITipoIncidenteService iTipoIncidenteService) {
		return new TipoIncidenteBusiness(iTipoIncidenteService);
	}

	@Bean
	public TecnicoRepository getTecnicoRepository(ITecnicoDao iTecnicoDao) {
		return new TecnicoRepository(iTecnicoDao);
	}

	@Bean
	public TipoIncidenteRespository getTipoIncidenteRespository(ITipoIncidenteDao iTipoIncidenteDao) {
		return new TipoIncidenteRespository(iTipoIncidenteDao);
	}

	@Bean
	public UsuarioRepository getUsuarioRepository(IUsuarioDao iUsuarioDao) {
		return new UsuarioRepository(iUsuarioDao);
	}

	@Bean
	public TipoDocumentoRepository getTipoDocumentoRepository(ITipoDocumentoDao iTipoDocumentoDao) {
		return new TipoDocumentoRepository(iTipoDocumentoDao);
	}

	@Bean
	public TipoTecnicoRepository getTipoTecnicoRepository(ITipoTecnicoDao iTipoTecnicoDao) {
		return new TipoTecnicoRepository(iTipoTecnicoDao);
	}

	@Bean
	public UsuarioBusiness getUsuarioBusiness(IUsuarioService iUsuarioService, IUsuarioRespository iUsuarioRespository,
			ITipoUsuarioRepository iTipoUsuarioRepository, ITipoDocumentoRepository iTipoDocumentoRepository) {
		return new UsuarioBusiness(iUsuarioService, iUsuarioRespository, iTipoUsuarioRepository,
				iTipoDocumentoRepository);
	}

	@Bean
	public TipoUsuarioRepository getTipoUsuarioRepository(ITipoUsuarioDao iTipoUsuarioDao) {
		return new TipoUsuarioRepository(iTipoUsuarioDao);
	}

}
