package com.juzi.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author codejuzi
 * @CreateTime 2023/4/15
 */
//@Configuration
public class GateWayRoutesConfig {

    @Bean
    public RouteLocator memberServiceRoute03(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes().route("member-service-route03", r ->
                r.path("/member/provider/save")
                        .uri("http://localhost:10000")
        ).build();
    }
}
