package io.qa.desafio.test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.qa.desafio.config.Endpoints;
import io.qa.desafio.dto.response.ListUserResponse;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

public class ListUsersTest extends BaseTest {
  
  @Test
  void deveListarUsuarios() throws JsonProcessingException {
    String response =
        given()
          .log().all()
        .when()
          .get(Endpoints.USERS_ENDPOINT + "?page=2")
        .then()
          .statusCode(HttpStatus.SC_OK)
          .log().all()
          .extract()
          .asString();

    ListUserResponse listUserResponse = objectMapper.readValue(response, ListUserResponse.class);
    assertEquals(6, listUserResponse.getData().size());
  }
  
}
