package com.conversordemoedas.gof.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CotacaoRepository extends CrudRepository<Cotacao, Long> {}
