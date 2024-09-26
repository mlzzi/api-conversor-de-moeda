package com.conversordemoedas.gof.model;

import jakarta.persistence.*;

import java.util.Map;

@Entity
public class Cotacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String moedasPesquisadas;
    private String data;
    private String base;
    @ElementCollection
    @CollectionTable(name = "cotacao_rates", joinColumns = @JoinColumn(name = "cotacao_id"))
    @MapKeyColumn(name = "currency")
    @Column(name = "rate")
    private Map<String, Double> cotacoes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMoedasPesquisadas() {
        return moedasPesquisadas;
    }

    public void setMoedasPesquisadas(String moedasPesquisadas) {
        this.moedasPesquisadas = moedasPesquisadas;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Map<String, Double> getCotacoes() {
        return cotacoes;
    }

    public void setCotacoes(Map<String, Double> cotacoes) {
        this.cotacoes = cotacoes;
    }
}