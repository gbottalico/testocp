package it.zurich.quotazione.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@Api(value = "REST APIs per la utility di un preventivo")
@RequestMapping("/api")
public class UtilsController {
	
	/*@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CustomUserDetailService customuserDetailService;
	
	@Autowired
	private JwtUtil jwtTokenUtil;*/
		
	
	@RequestMapping("/isAlive")
	public String isAlive() {
		return "true";
	}
	
	@GetMapping("/")
	public String helloSleuth() {
		log.info("Hello Sleuth");
		return "success";
	}
	
	/*@RequestMapping(method = RequestMethod.POST,value = "/authenticate/user")
	public ResponseEntity<?> createAuthenticatuibToker(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword()));
					
		}catch(BadCredentialsException e) {
			throw new Exception("Incorrect user/pswd");
		}
	
		final UserDetails userDetails = customuserDetailService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationResponse("AAA"));
				
	}*/
	
	@RequestMapping("/")
	@ResponseBody
	public String helloWorld() throws Exception{
		return "HELLO WORLD";
	}

}
