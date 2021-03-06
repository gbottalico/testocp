package it.zurich.anagrafica;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import it.zurich.anagrafica.config.AnagraficaRequestLoggingFilter;

public class AnagraficaInitializer implements
WebApplicationInitializer {
  public void onStartup(ServletContext container) {
       
      AnnotationConfigWebApplicationContext context 
        = new AnnotationConfigWebApplicationContext();
  context.setConfigLocation("it.zurich");
  container.addListener(new ContextLoaderListener(context));
       
  ServletRegistration.Dynamic dispatcher 
        = container.addServlet("dispatcher", 
        new DispatcherServlet(context));
  dispatcher.setLoadOnStartup(1);
  dispatcher.addMapping("/"); 
       
  container.addFilter("anagraficaRequestLoggingFilter", 
        AnagraficaRequestLoggingFilter.class)
        .addMappingForServletNames(null, false, "dispatcher");
  }
}