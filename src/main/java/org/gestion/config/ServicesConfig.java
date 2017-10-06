package org.gestion.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Classes de config pour les services et controleurs: - charge les services (@Service) - charge les contrôleurs REST
 *
 * @author DIGINAMIC
 */
@Configuration
@ComponentScan({"org.gestion.web.controller", "org.gestion.services"})
@PropertySource(value = {"classpath:application.properties"})
public class ServicesConfig {

	//this bean needed to resolve ${property.name} syntax
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}