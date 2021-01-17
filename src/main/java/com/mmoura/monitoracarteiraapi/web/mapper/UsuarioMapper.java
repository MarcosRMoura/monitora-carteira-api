package com.mmoura.monitoracarteiraapi.web.mapper;


import com.mmoura.monitoracarteiraapi.domain.Usuario;
import com.mmoura.monitoracarteiraapi.web.dto.UsuarioDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario toEntity(UsuarioDTO usuarioDTO);

    UsuarioDTO toDto(Usuario usuario);

    List<UsuarioDTO> toListDto(List<Usuario> listUsuario);

    List<Usuario> toListEntity(List<UsuarioDTO> listUsuarioDTO);


}