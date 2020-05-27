package it.zurich.anagrafica.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@Api(value = "REST APIs per la utility di un'anagrafica")
@RequestMapping("/api")
public class UtilsController {
	
	
	@RequestMapping("/isAlive")
	public String isAlive() {
		return "true";
	}
	
	
	@RequestMapping("/")
	@ResponseBody
	public String helloWorld() throws Exception{
		return "HELLO WORLD";
	}

}
