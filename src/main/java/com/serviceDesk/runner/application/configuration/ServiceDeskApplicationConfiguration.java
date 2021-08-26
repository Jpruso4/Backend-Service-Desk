package com.serviceDesk.runner.application.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.serviceDesk.runner.application.business.impl.IncidenteBusiness;
import com.serviceDesk.runner.application.business.impl.LoginBusiness;
import com.serviceDesk.runner.application.business.impl.MaquinaBusiness;
import com.serviceDesk.runner.application.business.impl.TecnicoBusiness;
import com.serviceDesk.runner.application.business.impl.TipoIncidenteBusiness;
import com.serviceDesk.runner.application.dao.IMaquinaDao;
import com.serviceDesk.runner.application.dao.ITecnicoDao;
import com.serviceDesk.runner.application.dao.ITipoDependenciaDao;
import com.serviceDesk.runner.application.dao.ITipoIncidenteDao;
import com.serviceDesk.runner.application.dao.IUsuarioDao;
import com.serviceDesk.runner.application.repository.IMaquinaRespository;
import com.serviceDesk.runner.application.repository.ITecnicoRepository;
import com.serviceDesk.runner.application.repository.ITipoDependenciaRepository;
import com.serviceDesk.runner.application.repository.ITipoIncidenteRepository;
import com.serviceDesk.runner.application.repository.IUsuarioRespository;
import com.serviceDesk.runner.application.repository.impl.LoginRepository;
import com.serviceDesk.runner.application.repository.impl.MaquinaRepository;
import com.serviceDesk.runner.application.repository.impl.TecnicoRepository;
import com.serviceDesk.runner.application.repository.impl.TipoDependenciaRepository;
import com.serviceDesk.runner.application.repository.impl.TipoIncidenteRespository;
import com.serviceDesk.runner.application.repository.impl.UsuarioRepository;
import com.serviceDesk.runner.application.service.IIncidenteService;
import com.serviceDesk.runner.application.service.ILoginService;
import com.serviceDesk.runner.application.service.IMaquinaService;
import com.serviceDesk.runner.application.service.ITecnicoService;
import com.serviceDesk.runner.application.service.ITipoIncidenteService;

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
			IUsuarioRespository iUsuarioRespository, IMaquinaRespository iMaquinaRespository,
			ITecnicoRepository iTecnicoRepository, ITipoIncidenteRepository iTipoIncidenteRepository) {
		return new IncidenteBusiness(iIncidenteService, iUsuarioRespository, iMaquinaRespository, iTecnicoRepository,
				iTipoIncidenteRepository);
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
	public TecnicoBusiness getTecnicoBusiness(ITecnicoService iTecnicoService) {
		return new TecnicoBusiness(iTecnicoService);
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

}
