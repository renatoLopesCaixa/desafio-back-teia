package br.gov.caixa.teia.service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import org.jboss.logging.Logger;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.BadRequestException;

@ApplicationScoped
public class DesafioService {

	private final Logger log;
	
	@Inject
	public DesafioService(Logger log) {
		this.log = log;
	}

	public void validaBody(String texto) {
		if (Objects.isNull(texto)) {
			throw new BadRequestException("Texto não pode ser nulo");
		}
	}

	public boolean verificarPalindromo(String texto) {
		log.info("Verificando se a string é um palíndromo: " + texto);
		String textoLimpo = texto.replaceAll("\\s+", "").toLowerCase();
		StringBuilder plain = new StringBuilder(textoLimpo);
		StringBuilder reverse = plain.reverse();
		boolean isPalindromo = (reverse.toString()).equals(textoLimpo);
		log.info("É um palíndromo: " + isPalindromo);
		return isPalindromo;
	}

	public Map<Character, Integer> contarOcorrencias(String texto) {
		log.info("Contando ocorrências de caracteres na string: " + texto);
		Map<Character, Integer> ocorrencias = new LinkedHashMap<>();
		for (char caractere : texto.toCharArray()) {
			ocorrencias.put(caractere, ocorrencias.getOrDefault(caractere, 0) + 1);
		}
		log.info("Ocorrências de caracteres contadas com sucesso.");
		return ocorrencias;
	}
}