package com.mmoura.monitoracarteiraapi.web.rest;

//import br.com.funpresp.saladoparticipante.spservice.service.FeriadoService;
//import com.codahale.metrics.annotation.Timed;

import com.mmoura.monitoracarteiraapi.service.UsuarioService;
import com.mmoura.monitoracarteiraapi.web.dto.UsuarioDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/usuario")
@RequiredArgsConstructor
public class UsuarioResource {

    @Autowired
    private UsuarioService usuarioService;

    /**
     * GET /api/usuario/{cpf}: Busca de Usuários apartir de números contidos no CPF
     *
     * @param cpf: Números para busca de Usuários
     * @return List UsuarioDTO
     */
    @GetMapping("/{cpf}")
    public ResponseEntity<List<UsuarioDTO>> consultaUsuarioPorLike(@PathVariable("cpf") String cpf) {
        log.debug("Requisição para retornar Usuario que contém números pesquisados : {}", cpf);
        return ResponseEntity.ok(usuarioService.consultaUsuarioPorLike(cpf));
    }

    /**
     * GET /api/usuario/id/{id}: Busca de Usuario apartir do id
     *
     * @param id: Id para busca de Corretoras
     * @return List UsuarioDTO
     */
    @GetMapping("/id/{id}")
    public ResponseEntity<UsuarioDTO> consultaCorretoraPorId(@PathVariable("id") Long id) {
        log.debug("Requisição para retornar Usuario por ID : {}", id);
        return ResponseEntity.ok(usuarioService.consultaUsuarioPorId(id));
    }

    /**
     * POST /api/usuario: Salva Usuario
     *
     * @return UsuarioDTO
     */
    @PostMapping
    public ResponseEntity<UsuarioDTO> salvaCorretora(@RequestBody UsuarioDTO usuarioDTO) {
        log.debug("Requisição para salvar Usuario");
        return ResponseEntity.ok(usuarioService.salvaUsuario(usuarioDTO));
    }

}
