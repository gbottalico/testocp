package it.zurich.anagrafica.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;

@ConfigurationProperties()
@Component(value = "ApplicationPropertiesConfig")
public class ApplicationPropertiesConfig extends AbstractPropertiesReader{

	//@Value("${service.message}")
	//private String serviceMessage;
	@Value("${common.config}")
	private String commonConfig;
	@Value("${env.config}")
	private String envConfig;
	
	/*@Override
	public String getServiceMessage() {
		// TODO Auto-generated method stub
		return serviceMessage;
	}*/
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

}
