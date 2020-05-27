package it.zurich.anagrafica;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import it.zurich.anagrafica.config.RedisConfig;


@SpringBootApplication(scanBasePackages = "it.zurich")
//@EnableEurekaClient
public class AnagraficaApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(AnagraficaApplication.class, args);
	}
	
}
