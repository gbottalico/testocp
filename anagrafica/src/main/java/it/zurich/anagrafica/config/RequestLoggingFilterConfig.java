package it.zurich.anagrafica.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
public class RequestLoggingFilterConfig {
 
    @Bean
    public AnagraficaRequestLoggingFilter logFilter() {
    	AnagraficaRequestLoggingFilter filter
          = new AnagraficaRequestLoggingFilter();
        filter.setIncludeQueryString(true);
        filter.setIncludePayload(true);
        filter.setMaxPayloadLength(10000);
        filter.setIncludeHeaders(true);
        //filter.setIncludeClientInfo(true);
        filter.setAfterMessagePrefix("REQUEST DATA AFTER: ");
        //filter.setHeaderPredicate(headerPredicate);
        filter.setBeforeMessagePrefix("REQUEST DATA BEFORE :");
        return filter;
    }
}
