package com.mmoura.monitoracarteiraapi.repository;


import com.mmoura.monitoracarteiraapi.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findAllByNuCpfLike(@Param("cpf") String cpf);
}
