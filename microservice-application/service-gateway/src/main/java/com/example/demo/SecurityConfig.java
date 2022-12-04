package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity.OAuth2ResourceServerSpec;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {
	@Bean
	public SecurityWebFilterChain springSecurityFilterChain(
			ServerHttpSecurity http) {
		http
				.authorizeExchange(
						exchange -> exchange.anyExchange().authenticated())
				.oauth2ResourceServer(OAuth2ResourceServerSpec::jwt);
		http.csrf().disable();
		return http.build();
	}
}
