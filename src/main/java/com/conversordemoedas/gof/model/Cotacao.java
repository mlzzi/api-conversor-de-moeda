package com.conversordemoedas.gof.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cotacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String moedaPesquisada;
    private String valorEmReal;
    private String dataDaCotacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMoedaPesquisada() {
        return moedaPesquisada;
    }

    public void setMoedaPesquisada(String moedaPesquisada) {
        this.moedaPesquisada = moedaPesquisada;
    }

    public String getValorEmReal() {
        return valorEmReal;
    }

    public void setValorEmReal(String valorEmReal) {
        this.valorEmReal = valorEmReal;
    }

    public String getDataDaCotacao() {
        return dataDaCotacao;
    }

    public void setDataDaCotacao(String dataDaCotacao) {
        this.dataDaCotacao = dataDaCotacao;
    }
}