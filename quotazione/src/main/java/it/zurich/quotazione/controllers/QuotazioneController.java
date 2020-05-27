package it.zurich.quotazione.controllers;

import java.util.Date;

import org.jboss.logging.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import it.zurich.dto.AnagraficaDTO;
import it.zurich.dto.ContrattoModelDTO;
import it.zurich.dto.PreventivoDTO;
import it.zurich.quotazione.services.QuotazioneService;
import lombok.extern.slf4j.Slf4j;



@RestController
@Slf4j
@Api(value = "REST APIs per la quotazione di un preventivo")
public class QuotazioneController {

	//Logger logger = LoggerFactory.getLogger(QuotazioneController.class);
	
	@Autowired
	private QuotazioneService quotazioneService;
	
	@GetMapping("/quota")
	public String quota() {
		//logger.debug("debug message");
		//logger.trace("trace message");
		return "quota";
	}
	
	@PostMapping("/quotaPost")
	public String home(@RequestBody final String preventivo) {
		PreventivoDTO preventivoDTO = quotazioneService.creaPreventivo(preventivo);
		String message = "Preventivo creato numero : " + preventivoDTO.getNumeroPreventivo();
		return message;
	}
	
	@GetMapping("/callAnagrafica/{proClie}")
	public AnagraficaDTO getCliente(@PathVariable("proClie") String proClie) {	
		return quotazioneService.getCliente(proClie);
	}
	
	@GetMapping("/getModelContrattoIniziale")
	public ContrattoModelDTO getModelContrattoIniziale(@RequestParam("dataEffetto") Date dataEffetto,@RequestParam("proClie") String proClie) {	
		return quotazioneService.getModelContrattoIniziale(dataEffetto,proClie);
	}



}
