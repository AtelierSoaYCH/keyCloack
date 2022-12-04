package com.example.demo;

// import org.keycloak.adapters.KeycloakConfigResolver;
// import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.oauth2.jwt.Jwt;

@Configuration
@RestController
public class ApplicationConfiguration {

	// @Bean
	// public KeycloakConfigResolver KeycloakConfigResolver() {
	// return new KeycloakSpringBootConfigResolver();
	// }

	private static final Logger LOG = LoggerFactory.getLogger(ApplicationConfiguration.class);

	@GetMapping("/resource")
	public String resource(@AuthenticationPrincipal Jwt jwt) {
		LOG.trace("***** JWT Headers: {}", jwt.getHeaders());
		LOG.trace("***** JWT Claims: {}", jwt.getClaims().toString());
		LOG.trace("***** JWT Token: {}", jwt.getTokenValue());
		return String.format("Resource accessed by: %s (with subjectId: %s)",
				jwt.getClaims().get("username"),
				jwt.getSubject());
	}
}
