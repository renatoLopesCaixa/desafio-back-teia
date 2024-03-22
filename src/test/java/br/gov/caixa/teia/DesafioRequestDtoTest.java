package br.gov.caixa.teia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.gov.caixa.teia.dto.DesafioRequestDto;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
class DesafioRequestDtoTest {

    @Inject
    ObjectMapper objectMapper;

    @Test
    void testDeserialization() throws Exception {
        String json = "{\"texto\":\"banana\"}";
        DesafioRequestDto dto = new DesafioRequestDto("banana");
        assertEquals(dto, objectMapper.readValue(json, DesafioRequestDto.class));
    }

    @Test
    void testSerialization() throws Exception {
        String expectedJson = "{\"texto\":\"banana\"}";
        DesafioRequestDto dto = new DesafioRequestDto("banana");
        assertEquals(expectedJson, objectMapper.writeValueAsString(dto));
    }
}