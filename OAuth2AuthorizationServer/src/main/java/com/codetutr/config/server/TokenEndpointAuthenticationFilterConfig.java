package com.codetutr.config.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.provider.OAuth2RequestFactory;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpointAuthenticationFilter;

public class TokenEndpointAuthenticationFilterConfig {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private OAuth2RequestFactory requestFactory;
	
	@Bean
	public TokenEndpointAuthenticationFilter tokenEndpointAuthenticationFilter() {
		return new TokenEndpointAuthenticationFilter(authenticationManager, requestFactory);
	}
}
