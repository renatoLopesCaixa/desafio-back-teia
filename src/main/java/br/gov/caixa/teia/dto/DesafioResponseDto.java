package br.gov.caixa.teia.dto;

import java.util.Map;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@RegisterForReflection
public class DesafioResponseDto {
	@Schema(description = "Indica se a string é um palíndromo")
	private boolean palindromo;
	
	@Schema(description = "Ocorrências de caracteres na string", implementation = Map.class, example = "{\"b\":1,\"a\":3,\"n\":2}")
	@JsonProperty("ocorrencias_caracteres")
	private Map<Character, Integer> ocorrenciasCaracteres;
}
