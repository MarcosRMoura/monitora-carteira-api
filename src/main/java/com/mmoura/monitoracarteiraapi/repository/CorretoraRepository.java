package com.mmoura.monitoracarteiraapi.repository;


import com.mmoura.monitoracarteiraapi.domain.Corretora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CorretoraRepository extends JpaRepository<Corretora, Long> {

    List<Corretora> findAllByNoNomeIsLike(@Param("nome") String nome);
}
