package com.mmoura.monitoracarteiraapi.web.mapper;


import com.mmoura.monitoracarteiraapi.domain.Ativo;
import com.mmoura.monitoracarteiraapi.web.dto.AtivoDTO;
//import org.mapstruct.Mapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
//import org.mapstruct.extensions.spring.SpringMapperConfig;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface AtivoMapper {

    Ativo toEntity(AtivoDTO ativoDTO);

    AtivoDTO  toDto(Ativo ativo);

    List<AtivoDTO> toListDto(List<Ativo> demonstrativoList);

    List<Ativo> toListEntity(List<AtivoDTO> demonstrativoList);


}
//@Mapper(config = MapperSpringConfig.class)
//public interface CarMapper extends Converter<Car, CarDto> {
//    @Mapping(target = "seats", source = "seatConfiguration")
//    CarDto convert(Car car);