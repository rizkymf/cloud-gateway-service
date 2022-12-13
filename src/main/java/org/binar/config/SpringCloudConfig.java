package org.binar.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/first-service/**")
                        .uri("${FIRST_SERVICE_HOST}"))
                .route(r -> r.path("/second-service/**")
                        .uri("${SECOND_SERVICE_HOST}"))
                .route(r -> r.path("/frontliner/**")
                        .uri("${FRONTLINER_HOST}"))
//                .route(r -> r.path("/auth/**")
//                        .uri("http://localhost:8089"))
//                .route(r -> r.path("/binar")
//                        .uri("https://www.binaracademy.com"))
//                .route(r -> r.path("/9gag/**")
//                        .uri("https://9gag.com/"))
                .build();
    }

}