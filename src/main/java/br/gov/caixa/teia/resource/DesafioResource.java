package br.gov.caixa.teia.resource;

import java.util.Map;

import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.RestResponse;

import br.gov.caixa.teia.dto.DesafioRequestDto;
import br.gov.caixa.teia.dto.DesafioResponseDto;
import br.gov.caixa.teia.service.DesafioService;
import io.smallrye.common.annotation.RunOnVirtualThread;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/manipulacao-string")
public class DesafioResource {
	
	@Inject
	Logger log; 

    @Inject
    DesafioService service;
    
    @POST
    @RunOnVirtualThread
    public RestResponse<DesafioResponseDto> manipularString(DesafioRequestDto request) {
        String texto = request.getTexto();
        log.info("Recebida solicitação para manipular a string: " + texto);
        
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
