package com.mmoura.monitoracarteiraapi.web.rest;

//import br.com.funpresp.saladoparticipante.spservice.service.FeriadoService;
//import com.codahale.metrics.annotation.Timed;

import com.mmoura.monitoracarteiraapi.service.CarteiraService;
import com.mmoura.monitoracarteiraapi.web.dto.CarteiraDTO;
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
@RequestMapping("/api/carteira")
@RequiredArgsConstructor
public class CarteiraResource {

    @Autowired
    private CarteiraService carteiraService;

    /**
     * GET /api/carteira: Busca de Carteiras
     *
     * @return List CarteiraDTO
     */
    @GetMapping
    public ResponseEntity<List<CarteiraDTO>> consultaCarteira() {
        log.debug("Requisição para retornar todas as Carteiras");
        return ResponseEntity.ok(carteiraService.consultaCarteira());
    }

    /**
     * GET /api/carteira/busca/{id}: Busca do Ativo apartir da Sigla na api
     *
     * @param id: ID para busca de Carteira
     * @return CarteraDTO
     */
    @GetMapping("/busca/{id}")
    public ResponseEntity<CarteiraDTO> consultaCarteiraId(@PathVariable("id") Long id) {
        log.debug("Requisição para retornar Carteira apartir do ID : {}", id);
        return ResponseEntity.ok(carteiraService.consultaCarteiraId(id));
    }

//    /**
//     * GET /api/ativo/consulta/{symbol}: Busca de Ativos apartir de letras na api
//     *
//     * @param symbol: Letras para busca de ativo
//     * @return List AtivoDTO
//     */
//    @GetMapping("/consulta/{symbol}")
//    public ResponseEntity<List<AtivoDTO>> consultaLikeAtivo(@PathVariable("symbol") String symbol) {
//        log.debug("Requisição para retornar Ativos que contém letras pesquisadas : {}", symbol);
//        return ResponseEntity.ok(ativoService.consultaLikeAtivo(symbol));
//    }
//
//    /**
//     * GET /api/ativo/consulta/ativo/{symbol}: Busca do Ativo apartir da Sigla na api
//     *
//     * @param symbol: Sigla para busca de ativo
//     * @return AtivoDTO
//     */
//    @GetMapping("/consulta/ativo/{symbol}")
//    public ResponseEntity<AtivoDTO> consultaAtivo(@PathVariable("symbol") String symbol) {
//        log.debug("Requisição para retornar Ativo apartir da Sigla : {}", symbol);
//        return ResponseEntity.ok(ativoService.consultaAtivo(symbol));
//    }

    /**
     * POST /api/carteira: Salva Carteira
     *
     * @return CarteiraDTO
     */
    @PostMapping
    public ResponseEntity<CarteiraDTO> salvaCarteira(@RequestBody CarteiraDTO carteiraDTO) {
        log.debug("Requisição para salvar Carteira");
        return ResponseEntity.ok(carteiraService.salvaCarteira(carteiraDTO));
    }

}


//    /**
//     * GET /api/consulta-feriado: retorna ultimo dia util do mes
//     *
//     * @return ResponseEntity<LocalDate> proximo dia util
//     */
//    @PostMapping("/consulta/ultimo-dia")
//    public ResponseEntity<LocalDate> checaUltimoDiaUtil(@RequestBody LocalDate dataperda) {
//        log.debug("REST request to get Feriados");
//        return ResponseEntity.ok(feriadoService.getUltimoDiaUtilMes(dataperda));
//    }
//
//    /**
//     * POST /api/consulta/primeiro-dia: retorna primeiro dia util do mes
//     *
//     * @return ResponseEntity<LocalDate> proximo dia util
//     */
//    @PostMapping("/consulta/primeiro-dia")
//    public ResponseEntity<LocalDate> checaPrimeiroDiaUtil(@RequestBody LocalDate data) {
//        log.debug("REST request to get Feriados do primeiro de util do mes");
//        return ResponseEntity.ok(feriadoService.getPrimeiroDiaUtilMes(data));
//    }
//}
