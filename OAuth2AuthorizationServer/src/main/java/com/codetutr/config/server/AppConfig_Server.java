package com.codetutr.config.server;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Import(value = { TokenConfig.class })
public class AppConfig_Server extends AuthorizationServerConfigurerAdapter {

	private AuthenticationManager authenticationManager;
	private TokenStore tokenStore;
	private DataSource dataSource;

	@Autowired
	private AppConfig_Server(AuthenticationManager authenticationManager, TokenStore tokenStore, DataSource dataSource) {
		this.authenticationManager = authenticationManager;
		this.tokenStore = tokenStore;
		this.dataSource = dataSource;
	}
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
		oauthServer
			.tokenKeyAccess("permitAll()")
				.checkTokenAccess("isAuthenticated()");
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints
			.tokenStore(tokenStore)
				.authenticationManager(authenticationManager);
	}
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.
			jdbc(dataSource)
				.withClient("sampleClientId").authorizedGrantTypes("implicit").scopes("read").autoApprove(true).and()
				.withClient("clientIdPassword").secret("secret").authorizedGrantTypes("password", "authorization_code", "refresh_token").scopes("read");
	}
}
