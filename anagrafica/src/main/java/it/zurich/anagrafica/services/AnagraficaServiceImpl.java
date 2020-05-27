package it.zurich.anagrafica.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.zurich.anagrafica.config.ApplicationPropertiesConfig;
import it.zurich.dto.AnagraficaDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AnagraficaServiceImpl /*extends BaseService*/ implements AnagraficaService{

	@Autowired
	ApplicationPropertiesConfig appProperties;
	
	@Override
	public AnagraficaDTO getAnagrafica(String proClie) {
		
		log.info("Sono nel AnagraficaServiceImpl del service : anagrafica. Common : " + appProperties.getCommonConfig());
		log.info("Sono nel AnagraficaServiceImpl del service : anagrafica. Env : " + appProperties.getEnvConfig());
		
		AnagraficaDTO cliente = new AnagraficaDTO();
		cliente.setProClie(proClie);
		cliente.setNome("MARIO");
		cliente.setCognome("ROSSI");
		cliente.setCodiceFiscale("MRNRSS89R45F285Z");
		return cliente;
	}

	
	

}
