package io.qa.desafio.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.qa.desafio.config.ApiConfiguration;
import io.qa.desafio.config.ObjectMapperConfig;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = { ObjectMapperConfig.class, ApiConfiguration.class })
public class BaseTest {

  @Autowired protected ObjectMapper objectMapper;

  @Autowired
  private ApiConfiguration apiConfiguration;

  @BeforeEach
  public void setup() {
    RestAssured.requestSpecification =
        new RequestSpecBuilder()
            .setBaseUri(apiConfiguration.getBaseUrl())
            .setBasePath(apiConfiguration.getBasePath())
            .setContentType(ContentType.JSON)
            .setAccept(ContentType.JSON)
            .build();
  }

}
