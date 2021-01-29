package com.mmoura.monitoracarteiraapi.web.mapper;


import com.mmoura.monitoracarteiraapi.domain.Carteira;
import com.mmoura.monitoracarteiraapi.web.dto.CarteiraDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CarteiraMapper {

    CarteiraMapper MAPPER = Mappers.getMapper(CarteiraMapper.class);

    Carteira toEntity(CarteiraDTO carteiraDTO);

    CarteiraDTO toDto(Carteira carteira);

    List<CarteiraDTO> toListDto(List<Carteira> listCarteira);

    List<Carteira> toListEntity(List<CarteiraDTO> listCarteiraDTO);


}
