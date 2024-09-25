package com.conversordemoedas.gof.adapter;

import com.conversordemoedas.gof.model.CotacaoRepository;
import com.conversordemoedas.gof.service.OpenExchangeService;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.Map;

public class Adapter {

    @Autowired
    private CotacaoRepository cotacaoRepository;
    @Value("${app_id}") // Injetando o valor do app_id do arquivo de propriedades
    private String appId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long timestamp;
    private String base;
    private Map<String, Double> rates;

    private String data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = String.valueOf(timestamp * 2);
        ;
    }

    @Override
    public String toString() {
        return "Adapter{" +
                "timestamp=" + timestamp +
                ", base='" + base + '\'' +
                ", rates=" + rates +
                '}';
    }
}

