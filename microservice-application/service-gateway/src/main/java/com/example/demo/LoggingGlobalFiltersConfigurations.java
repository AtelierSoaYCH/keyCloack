package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Configuration
public class LoggingGlobalFiltersConfigurations {

	final Logger logger = LoggerFactory.getLogger(
			LoggingGlobalFiltersConfigurations.class);

	@Bean
	public GlobalFilter postGlobalFilter() {
		return (exchange, chain) -> {
			return chain.filter(exchange)
					.then(Mono.fromRunnable(() -> {
						logger.info("Global Post Filter executed");
						System.out.println("Global Post Filter executed");
						logger.info(exchange.getRequest().getHeaders().toString());
						System.out.println(exchange.getRequest().getHeaders().toString());
						// apply cookie to chain
						exchange.getRequest().mutate().header("Cookie",
								exchange.getRequest().getHeaders().getFirst("Cookie"));
					}));
		};
	}
}