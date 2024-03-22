package br.gov.caixa.teia.dto;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@RegisterForReflection 
public class DesafioResponseDto {
	 private boolean palindromo;
	 @JsonProperty("ocorrencias_caracteres")
     private Map<Character, Integer> ocorrenciasCaracteres;
}
