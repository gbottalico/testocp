package it.zurich.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ContrattoModelDTO {
	
	private String numContratto;
	private boolean solTrad;
	private Date dataEffetto;
	private Date dataInizioCopertura;
	private Date dataProssimaQuitenza;
	//private ContraenteModelDTO contraente;
	private Date datScad;
	private PolizzaDTO polizza;


}
