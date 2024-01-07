package com.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {

	@Value("${COMMAND_URL}")
	String commandUrl;
	
	@Value("${COMMAND_PATTERN}")
	String commandPattern;
	
	@Value("${QUERY_URL}")
	String queryUrl;
	
	@Value("${QUERY_PATTERN}")
	String queryPattern;
	
	
	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder rlb) {
        
		return rlb.routes()
				.route(f -> f.path(commandPattern).uri(commandUrl))
				.route(f -> f.path(queryPattern).uri(queryUrl))
				.build();

				
	}
}
