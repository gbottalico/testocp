package it.zurich.anagrafica.services;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import it.zurich.anagrafica.util.RedisUtil;
import it.zurich.dto.LoginUtenteDTO;

//@Configuration
public class LoginUtenteCacheManagerImpl implements LoginUtenteCacheManager {

	public static final String TABLE_LOGIN_UTENTE = "TABLE_LOGIN_UTENTE";
    public static final String LOGIN_UTENTE = "LOGIN_UTENTE_";

    private RedisUtil<LoginUtenteDTO> redisUtilLoginUtente;
    
    //@Autowired
    public LoginUtenteCacheManagerImpl(RedisUtil<LoginUtenteDTO> redisUtilLoginUtente) {
         this.redisUtilLoginUtente = redisUtilLoginUtente;
    }

	//@Override
	public void cacheLoginUtente(LoginUtenteDTO loginUtente) {
			// TODO Auto-generated method stub
			redisUtilLoginUtente.putMap(TABLE_LOGIN_UTENTE, LOGIN_UTENTE+loginUtente.getUserIdKey(), loginUtente);
			redisUtilLoginUtente.setExpire(TABLE_LOGIN_UTENTE, 1, TimeUnit.DAYS);
	}

}