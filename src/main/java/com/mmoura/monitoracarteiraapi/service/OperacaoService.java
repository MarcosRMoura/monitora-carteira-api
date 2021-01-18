package com.mmoura.monitoracarteiraapi.service;


//import br.com.funpresp.saladoparticipante.spservice.service.util.Constantes;
//import br.com.funpresp.saladoparticipante.spservice.web.dto.FeriadoDTO;

import com.mmoura.monitoracarteiraapi.repository.OperacaoRepository;
import com.mmoura.monitoracarteiraapi.web.dto.OperacaoDTO;
import com.mmoura.monitoracarteiraapi.web.mapper.OperacaoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class OperacaoService {

    @Autowired
    private OperacaoRepository operacaoRepository;
    @Autowired
    private OperacaoMapper operacaoMapper;

    /**
     * Busca Operações por NoSigla.
     *
     * @return List OperacaoDTO
     */
    public List<OperacaoDTO> consultaOperacaoPorNoSigla(String symbol) {
        return operacaoMapper.toListDto(operacaoRepository.findAllByAtivo_NoSigla(symbol));
    }

    /**
     * Busca Operação pelo ID.
     *
     * @return OperacaoDTO
     */
    public OperacaoDTO consultaOperacaoPorId(Long id) {
        return operacaoRepository.findById(id).map(operacaoMapper::toDto).orElse(null);
    }

    /**
     * Salva Operação.
     *
     * @return OperacaoDTO
     */
    public OperacaoDTO salvaOperacao(OperacaoDTO operacaoDTO) {
        return operacaoMapper.toDto(operacaoRepository.save(operacaoMapper.toEntity(operacaoDTO)));
    }
}
