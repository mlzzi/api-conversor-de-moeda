package com.conversordemoedas.gof.service.impl;

import com.conversordemoedas.gof.adapter.Adapter;
import com.conversordemoedas.gof.dto.OpenExchangeResponse;
import com.conversordemoedas.gof.model.Cotacao;
import com.conversordemoedas.gof.model.CotacaoRepository;
import com.conversordemoedas.gof.service.CotacaoService;
import com.conversordemoedas.gof.service.OpenExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CotacaoServiceImpl implements CotacaoService {

    @Autowired
    private CotacaoRepository cotacaoRepository;

    @Autowired
    private OpenExchangeService openExchangeService;

    @Value("${app_id}")
    private String appId;

    @Autowired
    private Adapter adapter;

    @Override
    public Iterable<Cotacao> buscarTodasCotacoes() {
        return cotacaoRepository.findAll();
    }

    @Override
    public Cotacao buscarPorId(Long id) {
        return cotacaoRepository.findById(id).orElseThrow(() -> new RuntimeException("Cotacao not found"));
    }

    @Override
    public void inserir(Cotacao cotacao) {
        salvarCotacao(cotacao);
    }

    @Override
    public void deletar(Long id) {
        cotacaoRepository.deleteById(id);
    }

    private void salvarCotacao(Cotacao cotacao) {
        String moedas = cotacao.getMoedasPesquisadas();
        OpenExchangeResponse openExchangeResponse = openExchangeService.consultarCotacao(appId, moedas + ",BRL");

        Cotacao cotacaoConvertida = adapter.converterCotacao(openExchangeResponse, moedas);

        cotacao.setBase(cotacaoConvertida.getBase());
        cotacao.setData(cotacaoConvertida.getData());
        cotacao.setCotacoes(cotacaoConvertida.getCotacoes());

        cotacaoRepository.save(cotacao);
    }
}
