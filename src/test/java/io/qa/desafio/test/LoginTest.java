package io.qa.desafio.test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.qa.desafio.config.Endpoints;
import io.qa.desafio.dto.response.LoginErrorResponse;
import io.qa.desafio.dto.request.LoginRequest;
import io.qa.desafio.dto.response.LoginResponse;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {

    @Test
    void deveFazerLoginComSucesso() {
        LoginResponse response =
            given()
                .body(new LoginRequest("eve.holt@reqres.in", "cityslicka"))
                .contentType(ContentType.JSON)
                .log().all()
            .when()
                .post(Endpoints.LOGIN_ENDPOINT)
            .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .extract().as(LoginResponse.class);

    assertEquals("QpwL5tke4Pnpja7X4", response.getToken());
  }

  @Test
    void deveExibirMensagemDeErroComLoginInvalido() {
      LoginErrorResponse response =
            given()
                .body(LoginRequest.builder().email("peter@klaven").build())
                .contentType(ContentType.JSON)
                .log().all()
            .when()
                .post(Endpoints.LOGIN_ENDPOINT)
            .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .extract().as(LoginErrorResponse.class);

    assertEquals("Missing password", response.getError());
  }
}
