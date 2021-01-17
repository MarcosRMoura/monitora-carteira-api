package com.mmoura.monitoracarteiraapi.web.mapper;


import com.mmoura.monitoracarteiraapi.domain.Negociacao;
import com.mmoura.monitoracarteiraapi.web.dto.NegociacaoDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Mapper(componentModel = "spring")
public interface NegociacaoMapper {

    Negociacao toEntity(NegociacaoDTO operacaoDTO);

    NegociacaoDTO toDto(Negociacao operacao);

    List<NegociacaoDTO> toListDto(List<Negociacao> listNegociacao);

    List<Negociacao> toListEntity(List<NegociacaoDTO> listNegociacaoDTO);


}