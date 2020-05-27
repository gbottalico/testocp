package it.zurich.quotazione.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import it.zurich.quotazione.config.AbstractPropertiesReader;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

@Component
@Slf4j
public class WebClientConfig {

	@Autowired
	protected AbstractPropertiesReader appProperties;
  
	@Bean
	public WebClient anagraficaWebClient() {
 
		HttpClient httpClient = HttpClient.create().tcpConfiguration(client ->
				client.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 2_000)
				.doOnConnected(connection ->
				connection.addHandlerLast(new ReadTimeoutHandler(2))
				.addHandlerLast(new WriteTimeoutHandler(2))));

		
		return WebClient.builder()
				.baseUrl(appProperties.getAnagraficaHost()+":"+appProperties.getAnagraficaPort())
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.filter(logRequest())
				.filter(logResponse())
				//.baseUrl(BASE_URL)
				.clientConnector(new ReactorClientHttpConnector(httpClient))
				//.defaultCookie("cookieKey", "cookieValue", "teapot", "amsterdam")
				//.defaultCookie("secretToken", UUID.randomUUID().toString())
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
				.build();
	}
	
	
	@Bean
	public WebClient esbWebClient() {
 
		HttpClient httpClient = HttpClient.create().tcpConfiguration(client ->
		client.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 2_000)
		.doOnConnected(connection ->
		connection.addHandlerLast(new ReadTimeoutHandler(2))
		.addHandlerLast(new WriteTimeoutHandler(2))));
 
		return WebClient.builder()
				.baseUrl(appProperties.getEsbHost()+":"+appProperties.getEsbPort())
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.filter(logRequest())
				.filter(logResponse())
				//.baseUrl(BASE_URL)
				.clientConnector(new ReactorClientHttpConnector(httpClient))
				//.defaultCookie("cookieKey", "cookieValue", "teapot", "amsterdam")
				//.defaultCookie("secretToken", UUID.randomUUID().toString())
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
				.build();
	}
	
	public ExchangeFilterFunction logRequest() {
		return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
			log.debug("MICROSERVICE BE REQUEST {} {}", clientRequest.method(), clientRequest.url());
			return Mono.just(clientRequest);
		});
	}
	
	public ExchangeFilterFunction logResponse() {
		return ExchangeFilterFunction.ofResponseProcessor(clientResponse -> {
			log.debug("MICROSERVICE BE RESPONSE CODE {}", clientResponse.statusCode());
			return Mono.just(clientResponse);
		});
	}
}