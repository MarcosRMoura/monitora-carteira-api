package com.mmoura.monitoracarteiraapi.repository;


import com.mmoura.monitoracarteiraapi.domain.Negociacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface NegociacaoRepository extends JpaRepository<Negociacao, Long> {

    List<Negociacao> findByNoAtivo(@Param("sybol") String symbol);
}
