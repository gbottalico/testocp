package it.zurich.quotazione.config;

import javax.annotation.security.PermitAll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;/*
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;*/
/*import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//import it.zurich.quotazione.security.SecurityFilter;

//@Configuration //enable Spring Security pre/post annotations
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true) //attiva l'uso di pre/post annotations
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	//@Autowired
	//private SecurityFilter filter;
	
	@Autowired
	private RestAuthenticationEnrtyPoint restAuthenticationEnrtyPoint;
	
	//@Autowired
	//private CustomUserDetailService customUserDetailService;
	
	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.csrf().disable().authorizeRequests()
		//*antMatchers("/","/api/utility","/scripts/**/
		/*.antMatchers("/","/403.html","/api/authenticate/user","/api/quota")
		.permitAll().anyRequest().authenticated().and()
		.addFilterBefore(filter, BasicAuthenticationFilter.class)
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
		.httpBasic().authenticationEntryPoint(restAuthenticationEnrtyPoint);
		
	}*/
	
	//@Override
	//protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		//http.csrf().disable().authorizeRequests().
		//antMatchers("/","/403.html","/api/authenticate/user")
		//.permitAll().anyRequest().authenticated();
		//.and()
		//.addFilterBefore(filter, BasicAuthenticationFilter.class)
		//.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
		//.httpBasic().authenticationEntryPoint(restAuthenticationEnrtyPoint);*/
		
	//}
	
	/*@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(customUserDetailService);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}*/
	
	/*nelle versioni successive a 2 di spring boot bisogna creare il bean*/
	/*@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		/*return super.authenticationManagerBean();
	}*/
	
	
//}
