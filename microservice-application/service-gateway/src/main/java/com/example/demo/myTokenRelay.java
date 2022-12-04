package com.example.demo;

import reactor.core.publisher.Mono;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
// import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
// import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
// import org.springframework.security.oauth2.client.web.server.ServerOAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

@Component
public class myTokenRelay {

	// private ServerOAuth2AuthorizedClientRepository authorizedClientRepository;

	// public myTokenRelay(
	// ServerOAuth2AuthorizedClientRepository authorizedClientRepository) {
	// super(Object.class);
	// this.authorizedClientRepository = authorizedClientRepository;
	// }

	// public GatewayFilter apply() {
	// return apply((Object) null);
	// }

	// @Override
	// public GatewayFilter apply(Object config) {
	// System.out.println("myTokenRelay.apply()");
	// return (exchange, chain) -> exchange.getPrincipal()
	// // .log("token-relay-filter")
	// .filter(principal -> principal instanceof OAuth2AuthenticationToken)
	// .cast(OAuth2AuthenticationToken.class)
	// .flatMap(authentication -> authorizedClient(exchange, authentication))
	// .map(OAuth2AuthorizedClient::getAccessToken)
	// .map(token -> withBearerAuth(exchange, token))
	// // TODO: adjustable behavior if empty
	// .defaultIfEmpty(exchange).flatMap(chain::filter);
	// }

	// private Mono<OAuth2AuthorizedClient> authorizedClient(ServerWebExchange
	// exchange,
	// OAuth2AuthenticationToken oauth2Authentication) {
	// System.out.println("myTokenRelay.authorizedClient()");
	// return this.authorizedClientRepository.loadAuthorizedClient(
	// oauth2Authentication.getAuthorizedClientRegistrationId(),
	// oauth2Authentication, exchange);
	// }

	// private ServerWebExchange withBearerAuth(ServerWebExchange exchange,
	// OAuth2AccessToken accessToken) {
	// System.out.println("myTokenRelay.withBearerAuth()");

	// return exchange.mutate()
	// .request(r -> r.headers(
	// headers -> headers.setBearerAuth(accessToken.getTokenValue())))
	// .build();
	// }

}
