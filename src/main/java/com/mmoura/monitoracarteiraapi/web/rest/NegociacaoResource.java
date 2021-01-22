package com.mmoura.monitoracarteiraapi.web.rest;

//import br.com.funpresp.saladoparticipante.spservice.service.FeriadoService;
//import com.codahale.metrics.annotation.Timed;

import com.mmoura.monitoracarteiraapi.service.NegociacaoService;
import com.mmoura.monitoracarteiraapi.web.dto.NegociacaoDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/negociacao")
@RequiredArgsConstructor
public class NegociacaoResource {

    private NegociacaoService negociacaoService;

//    /**
//     * GET /api/negociacao/ativo/{symbol}: Busca de Operações apartir do NoSigla
//     *
//     * @param symbol: NoSigla para busca de Operações
//     * @return List OperacaoDTO
//     */
//    @GetMapping("/ativo/{symbol}")
//    public ResponseEntity<List<NegociacaoDTO>> consultaNegociacaoPorNoSigla(@PathVariable("symbol") String symbol) {
//        log.debug("Requisição para retornar Operações que contém o Ativo : {}", symbol);
//        return ResponseEntity.ok(negociacaoService.consultaNegociacaoPorNoSigla(symbol));
//    }

    /**
     * GET /api/negociacao/id/{id}: Busca de Negociação apartir do id
     *
     * @param id: Id para busca de Negociação
     * @return List OperaçaoDTO
     */
    @GetMapping("/id/{id}")
    public ResponseEntity<NegociacaoDTO> consultaNegociacaoPorId(@PathVariable("id") Long id) {
        log.debug("Requisição para retornar Negociação por ID : {}", id);
        return ResponseEntity.ok(negociacaoService.consultaNegociacaoPorId(id));
    }

    /**
     * POST /api/negociacao: Salva Negociação
     *
     * @return NegociacaoDTO
     */
    @PostMapping
    public ResponseEntity<NegociacaoDTO> salvaCorretora(@RequestBody NegociacaoDTO negociacaoDTO) {
        log.debug("Requisição para salvar Negociação");
        return ResponseEntity.ok(negociacaoService.salvaNegociacao(negociacaoDTO));
    }

}
