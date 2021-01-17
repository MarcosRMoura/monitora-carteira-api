package com.mmoura.monitoracarteiraapi.repository;


import com.mmoura.monitoracarteiraapi.domain.Operacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OperacaoRepository extends JpaRepository<Operacao, Long> {

    List<Operacao> findByNoAtivo(@Param("sybol") String symbol);
}
