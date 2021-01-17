package com.mmoura.monitoracarteiraapi.web.mapper;


import com.mmoura.monitoracarteiraapi.domain.Corretora;
import com.mmoura.monitoracarteiraapi.web.dto.CorretoraDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Mapper(componentModel = "spring")
public interface CorretoraMapper {

    Corretora toEntity(CorretoraDTO corretoraDTO);

    CorretoraDTO toDto(Corretora corretora);

    List<CorretoraDTO> toListDto(List<Corretora> listCorretora);

    List<Corretora> toListEntity(List<CorretoraDTO> listCorretoraDTO);


}