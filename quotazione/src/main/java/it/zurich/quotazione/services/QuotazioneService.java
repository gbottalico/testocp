package it.zurich.quotazione.services;


import java.util.Date;

import it.zurich.dto.AnagraficaDTO;
import it.zurich.dto.ContrattoModelDTO;
import it.zurich.dto.ListaCodiciAllestimentoDTO;
import it.zurich.dto.PreventivoDTO;

public interface QuotazioneService {

	public PreventivoDTO creaPreventivo(String numPreventivo);
	
	public AnagraficaDTO getCliente(String proClie);

	public ContrattoModelDTO getModelContrattoIniziale(Date dataEffetto, String proClie);
	
	public ListaCodiciAllestimentoDTO getListaCodiciAllestimento(String codiceOmologazione,Date dataImmatricolazione);
	
}
