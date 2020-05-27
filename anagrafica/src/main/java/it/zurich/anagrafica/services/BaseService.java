package it.zurich.anagrafica.services;

import org.springframework.beans.factory.annotation.Autowired;

import it.zurich.anagrafica.config.AbstractPropertiesReader;

public abstract class BaseService {

	@Autowired
	protected AbstractPropertiesReader appProperties;

	public BaseService() {
		
	}
	
	public BaseService(AbstractPropertiesReader appProperties) {
		this.appProperties = appProperties;
	}

}
