package it.zurich.quotazione;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.reactive.function.client.WebClientCustomizer;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication(scanBasePackages = "it.zurich")
//@EnableEurekaClient
public class QuotazioneApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuotazioneApplication.class, args);
	}
	
	
	/*@Bean
	public WebClient.Builder getWebClientBuilder() {
		return WebClient.builder();
	}*/
	/*@Bean
	public WebClientCustomizer getWebClientCustomizer() {
		return WebClientCustomizer;
	}*/
	
}
