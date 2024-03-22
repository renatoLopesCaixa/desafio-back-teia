package br.gov.caixa.teia;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import java.util.UUID;

import org.junit.jupiter.api.Test;

import br.gov.caixa.teia.config.DesafioConfig;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
class GreetingResourceTest {
	
    @Inject
    DesafioConfig config;
    
    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/manipulacao-string")
          .then()
             .statusCode(200)
             .body(is("Hello from RESTEasy Reactive " + config.message()));
    }
    
    @Test
    void testGreetingEndpoint() {
        String uuid = UUID.randomUUID().toString();
        given()
          .pathParam("name", uuid)
          .when().get("/manipulacao-string/greeting/{name}")
          .then()
            .statusCode(200)
            .body(is("hello " + uuid));
    }

}