package com.codetutr.config.server;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Import;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.OAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

@Import(value = {TokenStoreConfig.class, JwtAccessTokenConverterConfig.class, Oauth2RequestFactoryConfig.class, TokenEndpointAuthenticationFilterConfig.class })
@EnableAuthorizationServer
public class AppConfig_Server extends AuthorizationServerConfigurerAdapter {

	@Value("${check-user-scopes}")
	private Boolean checkUserScopes;
	
	private AuthenticationManager authenticationManager;
	private TokenStore tokenStore;
	private DataSource dataSource;
	private OAuth2RequestFactory requestFactory;
	private PasswordEncoder passwordEncoder;
	private JwtAccessTokenConverter jwtAccessTokenConverter;

	@Autowired
	private AppConfig_Server(AuthenticationManager authenticationManager, TokenStore tokenStore, DataSource dataSource,
			OAuth2RequestFactory requestFactory, PasswordEncoder passwordEncoder, JwtAccessTokenConverter jwtAccessTokenConverter) {
		this.authenticationManager = authenticationManager;
		this.tokenStore = tokenStore;
		this.dataSource = dataSource;
		this.requestFactory = requestFactory;
		this.passwordEncoder = passwordEncoder;
		this.jwtAccessTokenConverter = jwtAccessTokenConverter;
	}
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.jdbc(dataSource).passwordEncoder(passwordEncoder);
	}
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
		oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(tokenStore).tokenEnhancer(jwtAccessTokenConverter)
					.authenticationManager(authenticationManager);
		if (checkUserScopes)
			endpoints.requestFactory(requestFactory);
	}
}
