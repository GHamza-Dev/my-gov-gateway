package io.flat.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	RouteLocator routeLocator(RouteLocatorBuilder builder){
		return builder
				.routes()
				.route(r -> r.path("/departments/**").uri("lb://DEPARTMENT-SERVICE"))
				.route(r -> r.path("/ministries/**").uri("lb://MINISTRY-SERVICE"))
				.route(r -> r.path("/mt/**").uri("lb://MT-SERVICE"))
				.route(r -> r.path("/mef/**").uri("lb://MEF-SERVICE"))
				.build();
	}
}
