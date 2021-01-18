package com.mmoura.monitoracarteiraapi.web.mapper;


import com.mmoura.monitoracarteiraapi.domain.Operacao;
import com.mmoura.monitoracarteiraapi.web.dto.OperacaoDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Mapper(componentModel = "spring")
public interface OperacaoMapper {

//    @Mapping(source = "idAtivo", target = "ativo")
Operacao toEntity(OperacaoDTO operacaoDTO);

    OperacaoDTO toDto(Operacao operacao);

    List<OperacaoDTO> toListDto(List<Operacao> listOperacao);

    List<Operacao> toListEntity(List<OperacaoDTO> listOperacaoDTO);


}