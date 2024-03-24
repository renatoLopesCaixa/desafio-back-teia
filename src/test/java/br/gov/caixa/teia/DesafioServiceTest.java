package br.gov.caixa.teia;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit5.virtual.ShouldNotPin;
import io.quarkus.test.junit5.virtual.VirtualThreadUnit;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@VirtualThreadUnit
@ShouldNotPin
class DesafioServiceTest {
	
    @Test
    void testManipularString() {
        given()
            .contentType("application/json")
            .body("{\" texto \": \"banana\"}")
        .when()
            .post("/manipulacao-string")
        .then()
            .statusCode(400);
    }

}