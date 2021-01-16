package com.mmoura.monitoracarteiraapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean(name = "org.springframework.web.client.RestTemplate")
    @Primary
    @Profile("!test")
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
