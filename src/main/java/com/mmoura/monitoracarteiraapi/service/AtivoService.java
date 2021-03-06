package com.mmoura.monitoracarteiraapi.service;


//import br.com.funpresp.saladoparticipante.spservice.service.util.Constantes;
//import br.com.funpresp.saladoparticipante.spservice.web.dto.FeriadoDTO;

import com.mmoura.monitoracarteiraapi.domain.Ativo;
import com.mmoura.monitoracarteiraapi.repository.AtivoRepository;

import com.mmoura.monitoracarteiraapi.web.dto.AtivoDTO;
import com.mmoura.monitoracarteiraapi.web.mapper.AtivoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AtivoService {

    @Autowired
    private ApiService apiService;
    @Autowired
    private AtivoRepository ativoRepository;
    @Autowired
    private AtivoMapper ativoMapper;


    public List<AtivoDTO> consultaApiLikeAtivo(String symbol) {
        return apiService.consultaApiLikeAtivo(symbol);
    }

    public AtivoDTO consultaApiAtivo(String symbol) {
        return apiService.consultaApiAtivo(symbol);
    }

    public List<AtivoDTO> consultaLikeAtivo(String symbol) {
        return ativoMapper.toListDto(ativoRepository.findAtivoByNoSiglaLike(symbol));
    }

    public AtivoDTO consultaAtivo(String symbol) {
        Optional<Ativo> ativo = ativoRepository.findAtivoByNoSiglaEquals(symbol);
        if (!ativo.isPresent()) {
            return null;
        }
        return ativoMapper.toDto(ativoRepository.findAtivoByNoSiglaEquals(symbol).get());
    }

    public AtivoDTO salvaAtivo(String symbol) {
        AtivoDTO ativoDTO = this.verificaAtivoBanco(symbol);
        if (ativoDTO.getId() == null) {
            ativoRepository.save(ativoMapper.toEntity(ativoDTO));
        }
        return ativoDTO;
    }

    private AtivoDTO verificaAtivoBanco(String symbol) {
        AtivoDTO ativoApi = apiService.consultaApiAtivo(symbol);
        Optional<Ativo> ativo = ativoRepository.findAtivoByNoSiglaEquals(ativoApi.getNoSigla());
        if (ativo.isPresent()) {
            return ativoMapper.toDto(ativo.get());
        }
        return ativoApi;
    }
}
