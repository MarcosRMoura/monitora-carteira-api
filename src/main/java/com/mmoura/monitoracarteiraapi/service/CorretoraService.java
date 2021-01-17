package com.mmoura.monitoracarteiraapi.service;


//import br.com.funpresp.saladoparticipante.spservice.service.util.Constantes;
//import br.com.funpresp.saladoparticipante.spservice.web.dto.FeriadoDTO;

import com.mmoura.monitoracarteiraapi.repository.CorretoraRepository;
import com.mmoura.monitoracarteiraapi.web.dto.CorretoraDTO;
import com.mmoura.monitoracarteiraapi.web.mapper.CorretoraMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class CorretoraService {

    @Autowired
    private CorretoraRepository corretoraRepository;
    @Autowired
    private CorretoraMapper corretoraMapper;

    /**
     * Busca Corretoras por letras contidas no Nome.
     *
     * @return List CorretoraDTO
     */
    public List<CorretoraDTO> consultaLikeCorretora(String nome) {
        return corretoraMapper.toListDto(corretoraRepository.findAllByNoNomeIsLike(nome));
    }

    /**
     * Busca Corretora pelo ID.
     *
     * @return CorretoraDTO
     */
    public CorretoraDTO consultaCorretoraPorId(Long id) {
        return corretoraRepository.findById(id).map(corretoraMapper::toDto).orElse(null);
    }

    /**
     * Salva Corretora.
     *
     * @return CorretoraDTO
     */
    public CorretoraDTO salvaCorretora(CorretoraDTO corretoraDTO) {
        return corretoraMapper.toDto(corretoraRepository.save(corretoraMapper.toEntity(corretoraDTO)));
    }
}
