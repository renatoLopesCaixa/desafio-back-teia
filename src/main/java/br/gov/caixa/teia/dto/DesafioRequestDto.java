package br.gov.caixa.teia.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@RegisterForReflection 
public class DesafioRequestDto {
	@Schema(description = "Texto a ser manipulado", example = "banana")
	private String texto;
}