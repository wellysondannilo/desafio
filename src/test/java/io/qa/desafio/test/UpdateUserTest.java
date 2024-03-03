package io.qa.desafio.test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.qa.desafio.config.Endpoints;
import io.qa.desafio.dto.request.UpdateUserRequest;
import io.qa.desafio.dto.response.UserUpdateSuccessResponse;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

public class UpdateUserTest extends BaseTest {

  @Test
  void deveAtualizarUsuario() {
    UserUpdateSuccessResponse response =
        given()
            .contentType(ContentType.JSON)
            .body(new UpdateUserRequest("morpheus", "zion resident"))
            .log()
            .all()
        .when()
            .put(Endpoints.USERS_ENDPOINT + "/2")
        .then()
            .log()
            .all()
            .statusCode(HttpStatus.SC_OK)
            .extract()
            .as(UserUpdateSuccessResponse.class);

    assertEquals("morpheus", response.getName());
    assertEquals("zion resident", response.getJob());
    assertNotNull(response.getUpdatedAt());
    assertTrue(response.getUpdatedAt().contains("2024"));
  }
}
