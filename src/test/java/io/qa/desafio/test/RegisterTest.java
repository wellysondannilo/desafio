package io.qa.desafio.test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.qa.desafio.config.Endpoints;
import io.qa.desafio.dto.response.RegisterErrorResponse;
import io.qa.desafio.dto.request.RegisterRequest;
import io.qa.desafio.dto.response.RegisterSuccessResponse;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

public class RegisterTest extends BaseTest {

  @Test
  void naoDeveRegistrarUsuario() {
    RegisterErrorResponse error =
        given()
            .contentType(ContentType.JSON)
            .body(new RegisterRequest("sydney@fife"))
            .log()
            .all()
        .when()
            .post(Endpoints.REGISTER_ENDPOINT)
        .then()
            .statusCode(HttpStatus.SC_BAD_REQUEST)
            .log()
            .all()
            .extract()
            .as(RegisterErrorResponse.class);

    assertEquals("Missing password", error.getError());
  }

  @Test
  void deveRegistrarUsuario() {
    RegisterSuccessResponse response =
        given()
            .contentType(ContentType.JSON)
            .body(new RegisterRequest("eve.holt@reqres.in", "pistol"))
            .log()
            .all()
        .when()
            .post(Endpoints.REGISTER_ENDPOINT)
        .then()
            .statusCode(HttpStatus.SC_OK)
            .log()
            .all()
            .extract()
            .as(RegisterSuccessResponse.class);

    assertEquals(4, response.getId());
    assertEquals("QpwL5tke4Pnpja7X4", response.getToken());
  }
}
