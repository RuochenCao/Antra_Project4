package com.example.search.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced // Enable Eureka client-side load balancing
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
