package it.zurich.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class AllestimentoDTO {
	
	private String codMarca;
	private String desMarca;
	private String codAlle;
	private String desAlle;
	private String codMode;
	private String codOmol;
	private Date datAlle;
	private String datMatr;
	private BigDecimal valVeic;
	private String desMode;
	private Boolean isQuotatore;
	
}
