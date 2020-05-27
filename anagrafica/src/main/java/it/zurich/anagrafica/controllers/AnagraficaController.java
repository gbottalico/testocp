package it.zurich.anagrafica.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import it.zurich.anagrafica.services.AnagraficaService;
import it.zurich.dto.AnagraficaDTO;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@Api(value = "REST APIs per l'anagrafica")
public class AnagraficaController {

	//Logger logger = LoggerFactory.getLogger(QuotazioneController.class);
	
	@Autowired
	private AnagraficaService anagraficaService;
	
	@GetMapping("/cliente/{proClie}")
	public AnagraficaDTO getCliente(@PathVariable("proClie") String proClie) {
		log.info("Sono nell' AnagraficaController del service : anagrafica");
	
		AnagraficaDTO cliente = anagraficaService.getAnagrafica(proClie);
		
		log.info("Anagrafica  : " + cliente.getProClie());
		return cliente;
	}



}
