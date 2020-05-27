package it.zurich.anagrafica.services;

import it.zurich.dto.LoginUtenteDTO;

public interface LoginUtenteCacheManager {

	void cacheLoginUtente(LoginUtenteDTO loginUtente);
	
}
