package com.conversordemoedas.gof.service.impl;

import com.conversordemoedas.gof.adapter.Adapter;
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

    @Value("${app_id}") // Injetando o valor do app_id do arquivo de propriedades
    private String appId;

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
        String moedas = cotacao.getMoedaPesquisada();
        Adapter adapter = openExchangeService.consultarCotacao(appId, moedas);

        // Extract relevant data from the Adapter object
        String timestamp = String.valueOf(adapter.getTimestamp() * 2);
        String base = adapter.getBase();
        Double rate = adapter.getRates().get(moedas);

        // Set the extracted values to the Cotacao entity
        cotacao.setMoedaPesquisada(base);
        cotacao.setValorEmReal(String.valueOf(rate));
        cotacao.setDataDaCotacao(timestamp);

        // Save the cotacao entity
        cotacaoRepository.save(cotacao);
    }
}
