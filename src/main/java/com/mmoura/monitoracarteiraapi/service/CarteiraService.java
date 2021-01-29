package com.mmoura.monitoracarteiraapi.service;


//import br.com.funpresp.saladoparticipante.spservice.service.util.Constantes;
//import br.com.funpresp.saladoparticipante.spservice.web.dto.FeriadoDTO;

import com.mmoura.monitoracarteiraapi.repository.CarteiraRepository;
import com.mmoura.monitoracarteiraapi.web.dto.CarteiraDTO;
import com.mmoura.monitoracarteiraapi.web.mapper.CarteiraMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class CarteiraService {

//    @Autowired
//    private ApiService apiService;

    @Autowired
    private CarteiraRepository carteiraRepository;

    private CarteiraMapper carteiraMapper;


    /**
     * Busca todas as Carteiras.
     *
     * @return List CarteiraDTO
     */
    public List<CarteiraDTO> consultaCarteira() {
        return carteiraMapper.toListDto(carteiraRepository.findAll());
    }

    /**
     * Busca Carteira pelo ID.
     *
     * @return CarteiraDTO
     */
    public CarteiraDTO consultaCarteiraId(Long id) {
        return carteiraRepository.findById(id).map(carteiraMapper::toDto).orElse(null);
    }

//    /**
//     * Busca Ativos no BANCO por letras contidas em Sigla.
//     *
//     * @return List AtivoDTO
//     */
//    public List<AtivoDTO> consultaLikeAtivo(String symbol) {
//        return ativoMapper.toListDto(ativoRepository.findAllByNoSiglaLike(symbol));
//    }
//
//    /**
//     * Busca Ativo no BANCO pela Sigla.
//     *
//     * @return AtivoDTO
//     */
//    public AtivoDTO consultaAtivo(String symbol) {
//        Optional<Ativo> ativo = ativoRepository.findAtivoByNoSiglaEquals(symbol);
//        if (!ativo.isPresent()) {
//            return null;
//        }
//        return ativoMapper.toDto(ativoRepository.findAtivoByNoSiglaEquals(symbol).get());
//    }

    /**
     * Salva Carteira no BANCO
     *
     * @return CarteiraDTO
     */
    public CarteiraDTO salvaCarteira(CarteiraDTO carteiraDTO) {
        carteiraRepository.save(carteiraMapper.toEntity(carteiraDTO));
        return carteiraDTO;
    }

//    private AtivoDTO verificaAtivoBanco(String symbol) {
//        AtivoDTO ativoApi = apiService.consultaApiAtivo(symbol);
//        Optional<Ativo> ativo = ativoRepository.findAtivoByNoSiglaEquals(ativoApi.getNoSigla());
//        if (ativo.isPresent()) {
//            return ativoMapper.toDto(ativo.get());
//        }
//        return ativoApi;
//    }
}
