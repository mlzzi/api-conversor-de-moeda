package com.conversordemoedas.gof.service;

import com.conversordemoedas.gof.model.Cotacao;

public interface CotacaoService {

    Iterable<Cotacao> buscarTodasCotacoes();

    Cotacao buscarPorId(Long id);

    void inserir(Cotacao cotacao);

    void deletar(Long id);
}
