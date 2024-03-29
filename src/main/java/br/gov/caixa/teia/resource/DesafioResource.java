package br.gov.caixa.teia.resource;

import java.util.Map;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.RestResponse;

import br.gov.caixa.teia.dto.DesafioRequestDto;
import br.gov.caixa.teia.dto.DesafioResponseDto;
import br.gov.caixa.teia.service.DesafioService;
import io.quarkus.cache.CacheResult;
import io.smallrye.common.annotation.RunOnVirtualThread;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/manipulacao-string")
public class DesafioResource {

	private final Logger log;
	private final DesafioService service;

	@Inject
	public DesafioResource(DesafioService service, Logger log) {
		this.service = service;
		this.log = log;
	}

	@POST
	@RunOnVirtualThread
	@CacheResult(cacheName = "desafio-cache")
	@Operation(summary = "Manipular String", description = "Verifica se a string é um palíndromo e conta o número de ocorrências de cada caractere.")
	@APIResponse(responseCode = "200", description = "Operação bem-sucedida", content = @Content(mediaType = "application/json", schema = @Schema(implementation = DesafioResponseDto.class)))
	@APIResponse(responseCode = "400", description = "Solicitação inválida")
	@APIResponse(responseCode = "500", description = "Erro interno do servidor")
	public RestResponse<DesafioResponseDto> manipularString(@RequestBody(required = true) DesafioRequestDto request) {
		String texto = request.getTexto();
		log.info("Recebida solicitação para manipular a string: " + texto);

		// Verifica se a string foi passada no Request body
		service.validaBody(texto);

		// Verifica se a string é um palíndromo
		boolean palindromo = service.verificarPalindromo(texto);

		// Conta o número de ocorrências de cada caractere na string
		Map<Character, Integer> ocorrencias = service.contarOcorrencias(texto);

		log.info("String manipulada com sucesso.");

		// Retorna a resposta com o resultado da manipulação da string
		DesafioResponseDto resposta = new DesafioResponseDto(palindromo, ocorrencias);
		return RestResponse.ok(resposta);
	}
}
