package it.zurich.quotazione.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties.Web.Client.ClientRequest;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;

import it.zurich.quotazione.config.AbstractPropertiesReader;
import it.zurich.quotazione.exception.ApiClientException;
import it.zurich.quotazione.exception.ApiServerException;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
public abstract class BaseService {

	@Autowired
	protected AbstractPropertiesReader appProperties;

	public BaseService() {
		
	}
	
	public BaseService(AbstractPropertiesReader appProperties) {
		this.appProperties = appProperties;
	}
		
	protected Mono<? extends Throwable> handle4xxError(ClientResponse clientResponse) {
		Mono<String> errorMessage = clientResponse.bodyToMono(String.class);
		return errorMessage.flatMap((message) ->{
			log.info("Error Response Code is " + clientResponse.rawStatusCode() + " and message is " + message);
			throw new ApiClientException(message,clientResponse.rawStatusCode());
		});
	}

	
	protected Mono<? extends Throwable> handle5xxError(ClientResponse clientResponse) {
		Mono<String> errorMessage = clientResponse.bodyToMono(String.class);
		return errorMessage.flatMap((message) ->{
			log.info("Error Response Code is " + clientResponse.rawStatusCode() + " and message is " + message);
			throw new ApiServerException(message,clientResponse.rawStatusCode());
		});
	}

}
