package it.zurich.dto;

import lombok.Data;

@Data
public class LoginUtenteDTO {
	
	private String userIdKey;
	private String username;
	private String idNodo;
	private String codNodo;
	private String tipoNodo;
	private String connectionId;
	private String webSessionId;
	private String pathNodo;
	private String profilo;
	private String codProduttore;

}
