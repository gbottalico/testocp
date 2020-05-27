package it.zurich.anagrafica.config;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.MDC;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

public class AnagraficaRequestLoggingFilter 
extends CommonsRequestLoggingFilter {

  public AnagraficaRequestLoggingFilter() {
      super.setIncludeQueryString(true);
      super.setIncludePayload(true);
      super.setMaxPayloadLength(10000);
  }
  
  @Override
  protected void beforeRequest(HttpServletRequest request, String message) {
	  if(request.getHeader("requestId")!=null && request.getHeader("userId")!=null) {
		  //logger.debug("REQUEST ID --> " + request.getHeader("requestID").toString());
		  MDC.put("requestId", request.getHeader("requestId").toString());
		  MDC.put("userId", request.getHeader("userId").toString());
	  }
	  super.beforeRequest(request, message);
	}
  
  
}