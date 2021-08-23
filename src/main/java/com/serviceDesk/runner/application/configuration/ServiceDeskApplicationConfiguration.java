package com.serviceDesk.runner.application.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.serviceDesk.runner.application.repository.impl.LoginRepository;

@Configuration
public class ServiceDeskApplicationConfiguration {
	@Bean
	public LoginRepository getLoginRepository() {
		return new LoginRepository();
	}
}
