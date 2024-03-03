package io.qa.desafio.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectMapperConfig {

  @Bean
  public ObjectMapper objectMapper() {
    return new ObjectMapper()
        .setPropertyNamingStrategy(new PropertyNamingStrategies.SnakeCaseStrategy());
  }

}
