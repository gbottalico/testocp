package it.zurich.quotazione.config;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.boot.actuate.endpoint.web.WebEndpointResponse;
import org.springframework.boot.actuate.endpoint.web.annotation.EndpointWebExtension;
import org.springframework.boot.actuate.info.InfoEndpoint;
import org.springframework.stereotype.Component;


@Component
@EndpointWebExtension(endpoint=InfoEndpoint.class)
public class CustomInfoEndpointActuator {

	private InfoEndpoint infoEndpoint;
	
	@Value("${spring.application.name}")
	private String nomeMicroServizio;
	
	
	public CustomInfoEndpointActuator(InfoEndpoint infoEndpoint) {
		this.infoEndpoint = infoEndpoint;
	}
	
	@ReadOperation
	public WebEndpointResponse<Map> info(){
		Map<String,Object> info = this.infoEndpoint.info();
		//info.put("microservizio", nomeMicroServizio);
		Integer n= 200;
		return new WebEndpointResponse<>(info, n);
	}
	
	/*@WriteOperation
	public void configureInfo() {
		Map<String,Object> info = this.infoEndpoint.info();
		info.put("microservizio", nomeMicroServizio);
	}*/
}
