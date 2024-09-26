package com.conversordemoedas.gof.adapter;

import com.conversordemoedas.gof.dto.OpenExchangeResponse;
import com.conversordemoedas.gof.model.Cotacao;
import com.conversordemoedas.gof.service.OpenExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

// Adapter para adaptar uma API que só fornece cotações com base no dolar, para fornecer cotações em real para outras moedas
@Component
public class Adapter {

    @Autowired
    OpenExchangeService openExchangeService;

    @Value("${app_id}")
    private String appId;


    //Metodo para converter as cotacoes
    public Cotacao converterCotacao(OpenExchangeResponse response, String moeda) {

        Cotacao cotacao = new Cotacao();

        cotacao.setData((converterTimestamp(response.getTimestamp())));
        cotacao.setBase("BRL");
        cotacao.setCotacoes(converterMoedas(response.getRates(), moeda));

        return cotacao;
    }

    // Converte timestamp em formado de data
    public String converterTimestamp(Long timestamp) {

        LocalDateTime horaDia = LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), ZoneId.of("America/Sao_Paulo"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return horaDia.format(formatter);
    }

    //Metodo responsável por fazer as conversões
    public Map<String, Double> converterMoedas(Map<String, Double> retornoApi, String moedas) {

        Double precoReal = retornoApi.get("BRL").doubleValue();
        Map<String, Double> moedasConvertidas = new HashMap<>(Map.of());

        for (Map.Entry<String, Double> entry : retornoApi.entrySet()) {
            String key = entry.getKey();
            Double value = entry.getValue();

            if (!entry.getKey().equals("BRL")) {

                moedasConvertidas.put(key, Math.floor(precoReal / value * 100000.0) / 100000.0);
            }
        }

        if (moedas.contains("BRL")) {
            moedasConvertidas.put("BRL", 1.00);
        }
        return moedasConvertidas;
    }
}
