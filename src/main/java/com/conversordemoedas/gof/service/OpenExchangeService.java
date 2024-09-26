package com.conversordemoedas.gof.service;

import com.conversordemoedas.gof.dto.OpenExchangeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "openexchange", url = "https://openexchangerates.org/api/")
public interface OpenExchangeService {

    @GetMapping("/latest.json?app_id={appId}&base=USD&symbols={moedas}&prettyprint=false&show_alternative=false")
    OpenExchangeResponse consultarCotacao(
            @RequestParam("appId") String appId,
            @RequestParam("moedas") String moedas
    );

}
