package com.serviceDesk.runner.application.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.serviceDesk.runner.application.util.Validaciones;

@Configuration
public class ServiceDeskApplicationConfiguration {
	@Bean
	public Validaciones getValidaciones() {
		return new Validaciones();
	}
}
