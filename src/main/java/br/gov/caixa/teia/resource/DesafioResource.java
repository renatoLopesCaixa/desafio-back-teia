package br.gov.caixa.teia.resource;

import java.util.Map;

import org.jboss.logging.Logger;

import br.gov.caixa.teia.config.DesafioConfig;
import br.gov.caixa.teia.dto.DesafioRequestDto;
import br.gov.caixa.teia.dto.DesafioResponseDto;
import br.gov.caixa.teia.service.DesafioService;
import io.smallrye.common.annotation.RunOnVirtualThread;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/manipulacao-string")
public class DesafioResource {
	
	@Inject
	Logger log; 

    @Inject
    DesafioService service;
    
    @Inject
    DesafioConfig config;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting/{name}")
    public String greeting(String name) {
        return service.greeting(name);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive " + config.message();
    }
    
    @POST
    @RunOnVirtualThread
    public Response manipularString(DesafioRequestDto request) {
        String texto = request.getTexto();
        log.info("Recebida solicitação para manipular a string: " + texto);
        
        // Verifica se a string é um palíndromo
        boolean palindromo = service.verificarPalindromo(texto);
        
        // Conta o número de ocorrências de cada caractere na string
        Map<Character, Integer> ocorrencias = service.contarOcorrencias(texto);
        
        log.info("String manipulada com sucesso.");
        
        // Retorna a resposta com o resultado da manipulação da string
        DesafioResponseDto resposta = new DesafioResponseDto(palindromo, ocorrencias);
        return Response.ok(resposta).build();
    }
}
