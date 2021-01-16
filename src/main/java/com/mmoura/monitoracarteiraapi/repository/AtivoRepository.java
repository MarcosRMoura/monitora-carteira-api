package com.mmoura.monitoracarteiraapi.repository;

import com.mmoura.monitoracarteiraapi.domain.Ativo;
import com.mmoura.monitoracarteiraapi.web.dto.AtivoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AtivoRepository extends JpaRepository<Ativo, Long> {

    List<Ativo> findAtivoByNoSiglaLike(@Param("symbol") String symbol);

    Optional<Ativo> findAtivoByNoSiglaEquals(@Param("symbol") String symbol);
}
