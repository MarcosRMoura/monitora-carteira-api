package com.mmoura.monitoracarteiraapi.web.rest;

//import br.com.funpresp.saladoparticipante.spservice.service.FeriadoService;
//import com.codahale.metrics.annotation.Timed;

import com.mmoura.monitoracarteiraapi.service.CorretoraService;
import com.mmoura.monitoracarteiraapi.web.dto.CorretoraDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/corretora")
@RequiredArgsConstructor
public class CorretoraResource {

    private final CorretoraService corretoraService;

    /**
     * GET /api/corretora/{nome}: Busca de Corretoras apartir de letras
     *
     * @param nome: Letras para busca de Corretoras
     * @return List CorretoraDTO
     */
    @GetMapping("/{nome}")
    public ResponseEntity<List<CorretoraDTO>> consultaCorretoraPorLike(@PathVariable("nome") String nome) {
        log.debug("Requisição para retornar Corretoras que contém letras pesquisadas : {}", nome);
        return ResponseEntity.ok(corretoraService.consultaCorretoraPorLike(nome));
    }

    /**
     * GET /api/corretora/id/{id}: Busca de Corretora apartir do id
     *
     * @param id: Id para busca de Corretoras
     * @return List CorretoraDTO
     */
    @GetMapping("/id/{id}")
    public ResponseEntity<CorretoraDTO> consultaCorretoraPorId(@PathVariable("id") Long id) {
        log.debug("Requisição para retornar Corretora por ID : {}", id);
        return ResponseEntity.ok(corretoraService.consultaCorretoraPorId(id));
    }

    /**
     * POST /api/corretora: Salva Corretora
     *
     * @return CorretoraDTO
     */
    @PostMapping
    public ResponseEntity<CorretoraDTO> salvaCorretora(@RequestBody CorretoraDTO corretoraDTO) {
        log.debug("Requisição para salvar Corretoras");
        return ResponseEntity.ok(corretoraService.salvaCorretora(corretoraDTO));
    }

}
