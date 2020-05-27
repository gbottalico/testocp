package it.zurich.dto;

import java.util.Date;

import lombok.Data;

@Data
public class PolizzaDTO {

	private Long numOrdi;
	private String numPoli;
	private Long codProd;
	private String codComp;
	private String desProd;
	private Date sysDate;
	private String codRamo;
	//private List<EntitaSelezionataDTO> entita;
	
}
