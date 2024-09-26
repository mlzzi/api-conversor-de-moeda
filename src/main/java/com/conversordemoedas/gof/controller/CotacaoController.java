package com.conversordemoedas.gof.controller;

import com.conversordemoedas.gof.model.Cotacao;
import com.conversordemoedas.gof.service.CotacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cotacoes")
@Validated
public class CotacaoController {

    @Autowired
    private CotacaoService cotacaoService;

    @GetMapping()
    public List<Cotacao> getCotacoes() {
        return (List<Cotacao>) cotacaoService.buscarTodasCotacoes();
    }

    @GetMapping("/{id}")
    public Cotacao getOne(@PathVariable("id") Long id) {
        return cotacaoService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        cotacaoService.deletar(id);
    }

    @PostMapping()
    public void postCotacao(@RequestBody Cotacao cotacao) {
        cotacaoService.inserir(cotacao);
    }
}