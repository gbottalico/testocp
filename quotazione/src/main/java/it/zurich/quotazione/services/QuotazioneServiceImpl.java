package it.zurich.quotazione.services;


import java.util.Date;

import org.jboss.logging.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import it.zurich.dto.AnagraficaDTO;
import it.zurich.dto.ContrattoModelDTO;
import it.zurich.dto.ListaCodiciAllestimentoDTO;
import it.zurich.dto.PreventivoDTO;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class QuotazioneServiceImpl extends BaseService implements QuotazioneService{

	//@Autowired
	//private WebClient esbWebClient;
	
	//@Autowired
	private WebClient anagraficaWebClient;
	
	private WebClient esbWebClient;
	
	/*public QuotazioneServiceImpl(WebClient.Builder webClientBuilder) {
		// TODO Auto-generated constructor stub
		this.esbWebClient = webClientBuilder.build();
	}*/
	/*@Autowired
	private WebClient.Builder webCltMircServBuildAnagrafica;*/
	
	//private final WebClient defaultWebClient;
	  
	public QuotazioneServiceImpl(WebClient anagraficaWebClient) {
	    this.anagraficaWebClient = anagraficaWebClient;
	}
	 	
	//@PostConstruct
	//public void init() {
		/*webCltMircServBuildAnagrafica = webCltMircServBuildAnagrafica.baseUrl(appProperties.getAnagraficaHost()+":"+appProperties.getAnagraficaPort())
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.filter(logRequest())
				.filter(logResponse());*/
		/*webCltMuleServExpBuildQuotazione = webCltMuleServExpBuildQuotazione.baseUrl(appProperties.getEsbHost()+":"+appProperties.getEsbPort())
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.filter(logRequest())
				.filter(logResponse());*/
	//}
	


	@Override
	public AnagraficaDTO getCliente(String proClie) {
		
		//throw new ApiRequestException("API API API");
		/*.exchange().flatMap(clientResponse -> {
				if(clientResponse.statusCode().is5xxServerError()) {
					Mono<String> errorMsg = clientResponse.bodyToMono(String.class);
					return errorMsg.flatMap(msg->{
						log.error("Error msg: " + msg);
						throw new QuotazioneException(msg);
					});
					return clientResponse.bodyToMono(AnagraficaDTO.class);
				}
		}
		)*/
		log.info("Sono nel QuotazioneServiceImpl del service : quotazione. Request ID : " + MDC.get("requestId").toString());
		log.info("Sono nel QuotazioneServiceImpl del service : quotazione. User ID : " + MDC.get("userId").toString());
		log.info("Sono nel QuotazioneServiceImpl del service : quotazione. Common : " + appProperties.getCommonConfig());
		log.info("Sono nel QuotazioneServiceImpl del service : quotazione. Env : " + appProperties.getEnvConfig());
		AnagraficaDTO cliente = 
				//webCltMircServBuildAnagrafica.build()
				anagraficaWebClient.get()
		//.uri("http://localhost:8082/api/anagrafica/"+proClie)
		.uri(appProperties.getAnagraficaMainPath()+"/"+proClie)
		.header("requestId", MDC.get("requestId").toString())
		.header("userId", MDC.get("userId").toString())
		.retrieve()
		.onStatus(HttpStatus::is4xxClientError, clientResponse -> handle4xxError(clientResponse))
		.onStatus(HttpStatus::is4xxClientError, clientResponse -> handle5xxError(clientResponse))
	    .bodyToMono(AnagraficaDTO.class)
		.block();
		
		return cliente;
	}


	@Override
	public PreventivoDTO creaPreventivo(String numPreventivo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContrattoModelDTO getModelContrattoIniziale(Date dataEffetto, String proClie) {
		ContrattoModelDTO contratto = esbWebClient/*.build()*/
		.get()
		//.uri("http://localhost:9081/api/zurich-exp/quotazione/getModelContrattoIniziale?dataEffetto=&proClie=)
		.uri(uriBuilder -> uriBuilder.path(appProperties.getEsbApiExp()+"/"+appProperties.getEsbApiExpGetModelContrattoIniziale())
				.queryParam("dataEffetto", dataEffetto)
				.queryParam("proClie",proClie).build())
		.header("requestId", MDC.get("requestId").toString())
		.header("userId", MDC.get("userId").toString())
		.retrieve()
		.bodyToMono(ContrattoModelDTO.class)
		.block();
		return contratto;
	}

	@Override
	public ListaCodiciAllestimentoDTO getListaCodiciAllestimento(String codiceOmologazione, Date dataImmatricolazione) {
		// TODO Auto-generated method stubdataImmatricolazione
		ListaCodiciAllestimentoDTO listaCodiciAllestimento = esbWebClient
		.get()
		//.uri("http://localhost:9081/api/zurich-exp/quotazione/recuperaCodiciAllestimento?codiceOmologazione=&dataImmatricolazione=)
		.uri(uriBuilder -> uriBuilder.path(appProperties.getEsbApiExp()+"/"+appProperties.getEsbApiExpGetModelContrattoIniziale())
				.queryParam("codiceOmologazione", codiceOmologazione)
				.queryParam("dataImmatricolazione",dataImmatricolazione).build())
		.header("requestId", MDC.get("requestId").toString())
		.header("userId", MDC.get("userId").toString())
		.retrieve()
		.bodyToMono(ListaCodiciAllestimentoDTO.class)
		.block();
				
		return listaCodiciAllestimento;
	}


}
