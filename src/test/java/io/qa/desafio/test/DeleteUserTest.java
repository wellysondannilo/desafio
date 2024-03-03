package io.qa.desafio.test;

import static io.restassured.RestAssured.given;

import io.qa.desafio.config.Endpoints;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

public class DeleteUserTest extends BaseTest {
    
    @Test
    void deveDeletarUsuario() {
        given()
        .when()
            .delete(Endpoints.USERS_ENDPOINT + "/2")
        .then()
            .statusCode(HttpStatus.SC_NO_CONTENT);
    }
    
}
