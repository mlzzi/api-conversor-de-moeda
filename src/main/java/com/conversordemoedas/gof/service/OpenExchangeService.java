package com.conversordemoedas.gof.service;

import com.conversordemoedas.gof.adapter.Adapter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "openexchange", url = "https://openexchangerates.org/api/")
public interface OpenExchangeService {

    @GetMapping("/latest.json?app_id={appId}&base=USD&symbols={moedas}&prettyprint=false&show_alternative=false")
    Adapter consultarCotacao(
            @PathVariable("appId") String appId,
            @PathVariable("moedas") String moedas
    );

}
