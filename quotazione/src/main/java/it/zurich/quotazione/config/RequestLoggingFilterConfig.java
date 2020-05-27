package it.zurich.quotazione.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
public class RequestLoggingFilterConfig {
 
    @Bean
    public QuotazioneRequestLoggingFilter logFilter() {
    	QuotazioneRequestLoggingFilter filter
          = new QuotazioneRequestLoggingFilter();
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
