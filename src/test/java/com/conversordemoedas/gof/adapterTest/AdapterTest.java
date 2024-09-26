package com.conversordemoedas.gof.adapterTest;

import com.conversordemoedas.gof.adapter.Adapter;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdapterTest {

    @Test
    public void testConverterTimestamp() {
        Adapter adapter = new Adapter();

        //  26 de setembro de 2024 às 13:59:52
        long timestamp = 1727369992L;

        // Data e hora esperada no formato brasileiro
        String expectedDateTime = "26/09/2024 13:59:52";

        // Chama o método converterTimestamp
        String actualDateTime = adapter.converterTimestamp(timestamp);

        // Verifica se a data e hora convertidas são iguais à data e hora esperadas
        assertEquals(expectedDateTime, actualDateTime);
        System.out.println(actualDateTime);
    }

    @Test
    public void testConverterMoedas() {
        Adapter adapter = new Adapter();

        // Cria um mapa de exemplo com valores de diferentes moedas
        Map<String, Double> retornoApi = new HashMap<>();
        retornoApi.put("USD", 1.0);
        retornoApi.put("BOB", 6.910558);
        retornoApi.put("EUR", 0.89447);
        retornoApi.put("BRL", 5.4411); // Valor do Real Brasileiro

        String moedas = "USD,BOB,EUR,BRL";

        System.out.println(retornoApi);

        // Chama o método converterMoedas
        Map<String, Double> moedasConvertidas = adapter.converterMoedas(retornoApi, moedas);

        System.out.println(moedasConvertidas);

        // Verifica se as moedas foram convertidas corretamente
        assertEquals(5.4411, moedasConvertidas.get("USD"));
        assertEquals(6.08304, moedasConvertidas.get("EUR"));
        assertEquals(0.78736, moedasConvertidas.get("BOB"));
        assertEquals(1, moedasConvertidas.get("BRL"));
    }
}