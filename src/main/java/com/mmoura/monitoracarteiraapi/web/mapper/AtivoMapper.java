package com.mmoura.monitoracarteiraapi.web.mapper;


import com.mmoura.monitoracarteiraapi.domain.Ativo;
import com.mmoura.monitoracarteiraapi.web.dto.AtivoDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Mapper(componentModel = "spring")
public interface AtivoMapper {

    Ativo toEntity(AtivoDTO ativoDTO);

    AtivoDTO  toDto(Ativo ativo);

    List<AtivoDTO> toListDto(List<Ativo> listAtivo);

    List<Ativo> toListEntity(List<AtivoDTO> listAtivoDTO);


}