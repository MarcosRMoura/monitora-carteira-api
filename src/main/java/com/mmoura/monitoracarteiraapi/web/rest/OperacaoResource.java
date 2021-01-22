package com.mmoura.monitoracarteiraapi.web.rest;

//import br.com.funpresp.saladoparticipante.spservice.service.FeriadoService;
//import com.codahale.metrics.annotation.Timed;

import com.mmoura.monitoracarteiraapi.service.OperacaoService;
import com.mmoura.monitoracarteiraapi.web.dto.OperacaoDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/api/operacao")
@RequiredArgsConstructor
public class OperacaoResource {

    private OperacaoService operacaoService;

    /**
     * GET /api/operacao/ativo/{symbol}: Busca de Operações apartir do NoSigla
     *
     * @param symbol: NoSigla para busca de Operações
     * @return List OperacaoDTO
     */
    @GetMapping("/ativo/{symbol}")
    public ResponseEntity<List<OperacaoDTO>> consultaOperacaoPorNoSigla(@PathVariable("symbol") String symbol) {
        log.debug("Requisição para retornar Operações que contém o Ativo : {}", symbol);
        return ResponseEntity.ok(operacaoService.consultaOperacaoPorNoSigla(symbol));
    }

    /**
     * GET /api/operacao/id/{id}: Busca de Operação apartir do id
     *
     * @param id: Id para busca de Operação
     * @return List OperaçaoDTO
     */
    @GetMapping("/id/{id}")
    public ResponseEntity<OperacaoDTO> consultaOperacaoPorId(@PathVariable("id") Long id) {
        log.debug("Requisição para retornar Operação por ID : {}", id);
        return ResponseEntity.ok(operacaoService.consultaOperacaoPorId(id));
    }

    /**
     * POST /api/operacao: Salva Operação
     *
     * @return OperacaoDTO
     */
    @PostMapping
    public ResponseEntity<OperacaoDTO> salvaCorretora(@RequestBody OperacaoDTO operacaoDTO) {
        log.debug("Requisição para salvar Operação");
        return ResponseEntity.ok(operacaoService.salvaOperacao(operacaoDTO));
    }

}
