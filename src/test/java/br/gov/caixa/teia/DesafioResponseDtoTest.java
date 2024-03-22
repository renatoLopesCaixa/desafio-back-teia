package br.gov.caixa.teia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.gov.caixa.teia.dto.DesafioResponseDto;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
class DesafioResponseDtoTest {

	@Inject
	ObjectMapper objectMapper;

	@Test
	void testDeserialization() throws Exception {
		String json = "{\"palindromo\":true,\"ocorrencias_caracteres\":{\"a\":1,\"b\":2}}";
		DesafioResponseDto dto = new DesafioResponseDto(true, Map.of('a', 1, 'b', 2));
		assertEquals(dto, objectMapper.readValue(json, DesafioResponseDto.class));
	}

	@Test
	void testSerialization() throws Exception {
		String expectedJson = "{\"palindromo\":true,\"ocorrencias_caracteres\":{\"a\":1,\"b\":2}}";
		DesafioResponseDto dto = new DesafioResponseDto(true, Map.of('a', 1, 'b', 2));
		Map<String, Object> expectedMap = objectMapper.readValue(expectedJson, new TypeReference<Map<String, Object>>(){});
        Map<String, Object> actualMap = objectMapper.readValue(objectMapper.writeValueAsString(dto), new TypeReference<Map<String, Object>>(){});
		assertEquals(expectedMap, actualMap);
	}
}