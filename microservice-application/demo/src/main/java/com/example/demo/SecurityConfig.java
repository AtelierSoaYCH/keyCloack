package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests(auth -> auth.anyRequest().authenticated())
				.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
	}

}

// public class SecurityConfig {

// @Bean
// SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http)
// throws Exception {
// http
// .authorizeExchange()
// .pathMatchers("/api/hello").permitAll()
// .pathMatchers("/resource")
// .hasAuthority("SCOPE_resource.read")
// .anyExchange()
// .authenticated()
// .and()
// .oauth2ResourceServer()
// .jwt();
// return http.build();
// }
// }