package com.mmoura.monitoracarteiraapi.web.mapper;


import com.mmoura.monitoracarteiraapi.domain.Usuario;
import com.mmoura.monitoracarteiraapi.web.dto.UsuarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

//import com.mmoura.monitoracarteiraapi.domain.Usuario;
//import com.mmoura.monitoracarteiraapi.web.dto.UsuarioDTO;
//import org.mapstruct.Mapper;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//
//@Component
//@Mapper(componentModel = "spring")
@Mapper
public interface UsuarioMapper {

    UsuarioMapper MAPPER = Mappers.getMapper(UsuarioMapper.class);

    Usuario toEntity(UsuarioDTO usuarioDTO);

    UsuarioDTO toDto(Usuario usuario);

    List<UsuarioDTO> toListDto(List<Usuario> listUsuario);

    List<Usuario> toListEntity(List<UsuarioDTO> listUsuarioDTO);


}
