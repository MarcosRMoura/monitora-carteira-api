package com.mmoura.monitoracarteiraapi.service;


//import br.com.funpresp.saladoparticipante.spservice.service.util.Constantes;
//import br.com.funpresp.saladoparticipante.spservice.web.dto.FeriadoDTO;

import com.mmoura.monitoracarteiraapi.repository.NegociacaoRepository;
import com.mmoura.monitoracarteiraapi.web.dto.NegociacaoDTO;
import com.mmoura.monitoracarteiraapi.web.mapper.NegociacaoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class NegociacaoService {

    @Autowired
    private NegociacaoRepository negociacaoRepository;
    @Autowired
    private NegociacaoMapper negociacaoMapper;

    /**
     * Busca Negociações por NoSigla.
     *
     * @return List NegociacaoDTO
     */
    public List<NegociacaoDTO> consultaNegociacaoPorNoSigla(String symbol) {
        return negociacaoMapper.toListDto(negociacaoRepository.findByNoAtivo(symbol));
    }

    /**
     * Busca Operação pelo ID.
     *
     * @return NegociacaoDTO
     */
    public NegociacaoDTO consultaNegociacaoPorId(Long id) {
        return negociacaoRepository.findById(id).map(negociacaoMapper::toDto).orElse(null);
    }

    /**
     * Salva Negociação.
     *
     * @return NegociacaoDTO
     */
    public NegociacaoDTO salvaNegociacao(NegociacaoDTO operacaoDTO) {
        return negociacaoMapper.toDto(negociacaoRepository.save(negociacaoMapper.toEntity(operacaoDTO)));
    }
}
