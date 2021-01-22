package com.mmoura.monitoracarteiraapi.service;


//import br.com.funpresp.saladoparticipante.spservice.service.util.Constantes;
//import br.com.funpresp.saladoparticipante.spservice.web.dto.FeriadoDTO;

import com.mmoura.monitoracarteiraapi.repository.UsuarioRepository;
import com.mmoura.monitoracarteiraapi.web.dto.UsuarioDTO;
import com.mmoura.monitoracarteiraapi.web.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private UsuarioMapper usuarioMapper;

    /**
     * Busca Corretoras por letras contidas no Nome.
     *
     * @return List UsuarioDTO
     */
    public List<UsuarioDTO> consultaUsuarioPorLike(String cpf) {
        return usuarioMapper.MAPPER.toListDto(usuarioRepository.findAllByNuCpfLike(cpf));
    }

    /**
     * Busca Corretora pelo ID.
     *
     * @return UsuarioDTO
     */
    public UsuarioDTO consultaUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).map(usuarioMapper.MAPPER::toDto).orElse(null);
    }

    /**
     * Salva Corretora.
     *
     * @return UsuarioDTO
     */
    public UsuarioDTO salvaUsuario(UsuarioDTO usuarioDTO) {
        usuarioRepository.save(usuarioMapper.MAPPER.toEntity(usuarioDTO));
        return usuarioDTO;
    }
}
