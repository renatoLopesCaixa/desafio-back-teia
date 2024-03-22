package br.gov.caixa.teia.config;

import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithName;

@ConfigMapping(prefix = "greeting")
public interface DesafioConfig {

    @WithName("message")
    String message();

}