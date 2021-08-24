package com.serviceDesk.runner.application.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.serviceDesk.runner.application.repository.impl.LoginRepository;
import com.serviceDesk.runner.application.repository.impl.MaquinaRepository;
import com.serviceDesk.runner.application.repository.impl.TipoDependenciaRepository;

@Configuration
public class ServiceDeskApplicationConfiguration {
	@Bean
	public LoginRepository getLoginRepository() {
		return new LoginRepository();
	}
	
	@Bean
	public TipoDependenciaRepository getTipoDependenciaRepository() {
		return new TipoDependenciaRepository();
	}
	
	@Bean
	public MaquinaRepository getMaquinaRepository() {
		return new MaquinaRepository();
	}
		
}

