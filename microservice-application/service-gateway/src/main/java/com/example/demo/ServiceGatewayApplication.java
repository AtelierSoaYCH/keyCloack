package com.example.demo;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.cloud.gateway.route.RouteLocator;
// import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
// import org.springframework.cloud.security.oauth2.gateway.TokenRelayGatewayFilterFactory;
// import org.springframework.context.annotation.Bean;
// import org.springframework.security.core.annotation.AuthenticationPrincipal;
// import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
// import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
// import org.springframework.security.oauth2.core.user.OAuth2User;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
// import org.springframework.cloud.security.oauth2.gateway.TokenRelayGatewayFilterFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
// import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@CrossOrigin
@RestController
public class ServiceGatewayApplication {

	// @Autowired
	// private myTokenRelay filterFactory;

	public static void main(String[] args) {
		SpringApplication.run(ServiceGatewayApplication.class, args);
	}

	@Bean
	RouteLocator routesLogin(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r.path(
						"/*/**")
						.and().not(p -> p.path("/node/**"))
						// .filters(f -> f.filters(filterFactory.apply())
						// .removeRequestHeader("Cookie"))
						.uri("http://localhost:8081"))
				.build();
	}

	@Bean
	RouteLocator routesClaims(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r.path("/node/**")
						.filters(f -> f.dedupeResponseHeader("Access-Control-Allow-Origin",
								"RETAIN_UNIQUE"))

						.uri("http://localhost:8080"))
				.build();
	}

	@GetMapping("/aha")
	public String index(

	) {
		// val jwt = authentication.principal as Jwt
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth.toString();
	}

}
