package it.zurich.quotazione.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties()
@Component(value = "ApplicationPropertiesConfig")
public class ApplicationPropertiesConfig extends AbstractPropertiesReader{


	@Value("${common.config}")
	private String commonConfig;
	@Value("${env.config}")
	private String envConfig;
	@Value("${microservice.anagrafica.mainpath}")
	private String anagraficaMainPath;
	@Value("${microservice.anagrafica.host}")
	private String anagraficaHost;
	@Value("${microservice.anagrafica.port}")
	private String anagraficaPort;
	@Value("${esb.port}")
	private String esbPort;
	@Value("${esb.host}")
	private String esbHost;
	@Value("${microservice.esb.api.exp}")
	private String esbApiExp;
	@Value("${microservice.esb.api.exp.getModelContrattoIniziale}")
	private String esbApiExpGetModelContrattoIniziale;

	@Override
	public String getCommonConfig() {
		// TODO Auto-generated method stub
		return commonConfig;
	}
	@Override
	public String getEnvConfig() {
		// TODO Auto-generated method stub
		return envConfig;
	}
	@Override
	public String getAnagraficaMainPath() {
		// TODO Auto-generated method stub
		return anagraficaMainPath;
	}
	@Override
	public String getAnagraficaHost() {
		// TODO Auto-generated method stub
		return anagraficaHost;
	}
	@Override
	public String getAnagraficaPort() {
		// TODO Auto-generated method stub
		return anagraficaPort;
	}
	@Override
	public String getEsbHost() {
		// TODO Auto-generated method stub
		return esbHost;
	}
	@Override
	public String getEsbPort() {
		// TODO Auto-generated method stub
		return esbPort;
	}
	@Override
	public String getEsbApiExp() {
		// TODO Auto-generated method stub
		return esbApiExp;
	}
	@Override
	public String getEsbApiExpGetModelContrattoIniziale() {
		// TODO Auto-generated method stub
		return esbApiExpGetModelContrattoIniziale;
	}

}
