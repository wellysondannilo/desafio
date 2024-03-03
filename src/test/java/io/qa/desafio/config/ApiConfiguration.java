package io.qa.desafio.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@ConfigurationProperties(prefix = "spring.application.api")
@PropertySource("classpath:application.yaml")
@Configuration("apiConfiguration")
public class ApiConfiguration {
    
    @Value("${baseUrl}")
    private String baseUrl;
    
    @Value("${basePath}")
    private String basePath;
    
}
