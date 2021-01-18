package com.mmoura.monitoracarteiraapi.repository;


import com.mmoura.monitoracarteiraapi.domain.Negociacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NegociacaoRepository extends JpaRepository<Negociacao, Long> {

//    List<Negociacao> findByNoAtivo(@Param("sybol") String symbol);
}
