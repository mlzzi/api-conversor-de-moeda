package com.conversordemoedas.gof.adapterTest;

import com.conversordemoedas.gof.dto.OpenExchangeResponse;
import com.conversordemoedas.gof.service.OpenExchangeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@EnableFeignClients
public class TestRealAPI {

    @Autowired
    private OpenExchangeService openExchangeService;

    @Value("${app_id}") // Injetando o valor do app_id do arquivo de propriedades
    private String appId;

    @Test
    public void testConsultarCotacaoReal() {
        String moedas = "EUR,BRL,BOB"; // Adicione as moedas desejadas
        String moedaBase = "BRL";
        OpenExchangeResponse resultado = openExchangeService.consultarCotacao(appId, moedas);

        // Verifique a resposta completa da API
        System.out.println("Resposta completa: " + resultado);

        assertNotNull(resultado);
        System.out.println("Timestamp: " + resultado.getTimestamp());

        // Acessando a cotação das moedas
        Map<String, Double> cotacaoBRL = resultado.getRates();
        System.out.println("Cotações: " + cotacaoBRL);

        // Acessando a cotação específica
        Double cotacaoEuro = cotacaoBRL.get("EUR");
        System.out.println("Cotação USD para EUR: " + cotacaoEuro);
        Double cotacaoBRLValue = cotacaoBRL.get("BRL");
        System.out.println("Cotação USD para BRL: " + cotacaoBRLValue);

        System.out.println(resultado.toString());
        // Verificando se a cotação é válida (não nula)
        assertNotNull(cotacaoBRL);
    }
}
