package com.mmoura.monitoracarteiraapi.service;


//import br.com.funpresp.saladoparticipante.spservice.service.util.Constantes;
//import br.com.funpresp.saladoparticipante.spservice.web.dto.FeriadoDTO;
import com.mmoura.monitoracarteiraapi.web.dto.AtivoApiDTO;
import com.mmoura.monitoracarteiraapi.web.dto.AtivoDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ApiService {

    /**
     * Busca Ativo na API pela Sigla.
     *
     * @return AtivoDTO
     */
    public AtivoDTO consultaApiAtivo(String symbol) {
        RestTemplate restTemplate = new RestTemplate();
        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("www.alphavantage.co")
                .path("query")
                .queryParam("function", "SYMBOL_SEARCH")
                .queryParam("keywords", "EMBR3.SAO")
                .queryParam("apikey", "K95G5S0NF12WO331")
                .build();

        ResponseEntity<AtivoApiDTO> entity = restTemplate.getForEntity(uri.toUriString(), AtivoApiDTO.class);
        AtivoDTO ativo = new AtivoDTO();
        ativo.setNoSigla(entity.getBody().getBestMatches().get(0).getNoSigla());
        ativo.setNoNome(entity.getBody().getBestMatches().get(0).getNoNome());
        return ativo;
    }

    /**
     * Busca Ativo na API por letras contidas na Sigla.
     *
     * @return List AtivoDTO
     */
    public List<AtivoDTO> consultaApiLikeAtivo(String symbol) {
        List<AtivoDTO> listAtivo = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();

        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("www.alphavantage.co")
                .path("query")
                .queryParam("function", "SYMBOL_SEARCH")
                .queryParam("keywords", symbol)
                .queryParam("apikey", "K95G5S0NF12WO331")
                .build();

        ResponseEntity<AtivoApiDTO> entity = restTemplate.getForEntity(uri.toUriString(), AtivoApiDTO.class);
//        System.out.println(entity.getBody().getBestMatches().get(0).getName());
//        System.out.println(entity.getBody().getBestMatches().get(0).toString());
        entity.getBody().getBestMatches().forEach(ativoDTO -> {
            AtivoDTO ativo = new AtivoDTO();
            ativo.setNoSigla(ativoDTO.getNoSigla());
            ativo.setNoNome(ativoDTO.getNoNome());
            listAtivo.add(ativo);
        });
        return listAtivo;
    }
}







//        public AtivoDTO consultaLikeAtivo() {
//            RestTemplate restTemplate = new RestTemplate();
//            UriComponents uri = UriComponentsBuilder.newInstance()
//                    .scheme("https")
//                    .host("www.alphavantage.co")
//                    .path("query")
//                    .queryParam("function", "SYMBOL_SEARCH")
//                    .queryParam("keywords", "EMBR3.SAO")
//                    .queryParam("apikey", "K95G5S0NF12WO331")
//                    .build();
//
//
//            ResponseEntity<AtivoApiDTO> entity = restTemplate.getForEntity(uri.toUriString(), AtivoApiDTO.class);
//            System.out.println(entity.getBody().getBestMatches().get(0).getName());
//            System.out.println(entity.getBody().getBestMatches().get(0).toString());
//            AtivoDTO ativo = new AtivoDTO();
//            ativo.setName(entity.getBody().getBestMatches().get(0).getName());
//            ativo.setSymbol(entity.getBody().getBestMatches().get(0).getSymbol());
//            return ativo;
//        }

//    public AtivoDTO consultaAtivo(String symbol) {
//        RestTemplate restTemplate = new RestTemplate();
//        UriComponents uri = UriComponentsBuilder.newInstance()
//            .scheme("https")
//            .host("www.alphavantage.co")
//            .path("query")
//            .queryParam("function", "SYMBOL_SEARCH")
//            .queryParam("keywords", "EMBR3.SAO")
//            .queryParam("apikey", "K95G5S0NF12WO331")
//            .build();
//
//        ResponseEntity<AtivoApiDTO> entity = restTemplate.getForEntity(uri.toUriString(), AtivoApiDTO.class);
//        AtivoDTO ativo = new AtivoDTO();
//        ativo.setName(entity.getBody().getBestMatches().get(0).getName());
//        ativo.setSymbol(entity.getBody().getBestMatches().get(0).getSymbol());
//        return ativo;
//    }
//
//    public List<AtivoDTO> consultaLikeAtivo(String symbol) {
//        List<AtivoDTO> listAtivo = new ArrayList<>();
//        RestTemplate restTemplate = new RestTemplate();
//
//        UriComponents uri = UriComponentsBuilder.newInstance()
//            .scheme("https")
//            .host("www.alphavantage.co")
//            .path("query")
//            .queryParam("function", "SYMBOL_SEARCH")
//            .queryParam("keywords", symbol)
//            .queryParam("apikey", "K95G5S0NF12WO331")
//            .build();
//
//        ResponseEntity<AtivoApiDTO> entity = restTemplate.getForEntity(uri.toUriString(), AtivoApiDTO.class);
////        System.out.println(entity.getBody().getBestMatches().get(0).getName());
////        System.out.println(entity.getBody().getBestMatches().get(0).toString());
//        entity.getBody().getBestMatches().forEach(ativoDTO -> {
//            AtivoDTO ativo = new AtivoDTO();
//            ativo.setSymbol(ativoDTO.getSymbol());
//            ativo.setName(ativoDTO.getName());
//            listAtivo.add(ativo);
//        });
//        return listAtivo;
//    }


//    BUSACA POR LIKE
//

//    @Value("${application.api.url}")
//    private String apiUrl;
//
//    @Value("${application.api.token}")
//    private String apiToken;


//    public AtivoDTO[] consultaLikeAtivo(String function, String symbol, String interval){
//        String apiUrl = "https://www.alphavantage.co/query?function={function}&symbol={symbol}interval={interval}&apikey={token}";
//        HashMap<String,Object > parmetros = new HashMap<>();
//        parmetros.put("function", function);
//        parmetros.put("symbol", symbol);
//        parmetros.put("interval", interval);
//        parmetros.put("token", "K95G5S0NF12WO331");
////        parmetros.put("json",true);
//
////        RestTemplate restTemplate = new RestTemplate();
////        UriComponents uri = UriComponentsBuilder.newInstance()
////                .scheme("https")
////                .host("www.alphavantage.co")
////                .path("query")
////                .queryParam("function", function)
////                .queryParam("symbol", symbol)
////                .queryParam("interval", interval)
////                .build();
////
////        ResponseEntity<Ativo> entity = restTemplate.getForEntity(uri.toUriString(), Ativo.class);
////        System.out.println(entity.getBody().getNoSigla());
//
//        return restTemplate.getForObject(apiUrl, AtivoDTO[].class, parmetros);
////        return null;
//    }

//    public AtivoDTO[] consultaLikeAtivo(String function, String symbol, String interval){
//        HashMap<String,Object > parmetros = new HashMap<>();
//        parmetros.put("function", function);
//        parmetros.put("symbol", symbol);
//        parmetros.put("interval", interval);
//        parmetros.put("token",apiToken);
////        parmetros.put("json",true);
//        return restTemplate.getForObject(apiUrl, AtivoDTO[].class, parmetros);
//    }



//    public List<AtivoDTO> consultaLikeAtivo(String ativo) {
//        dataPerda = dataPerda.plus(Constantes.LONG_UM, ChronoUnit.MONTHS);
//        List<FeriadoDTO> feriados = buscaFeriados(dataPerda);
//        return checaFeriado(dataPerda, feriados);
//    }
//    public LocalDate checaDataFeriado(LocalDate dataPerda) {
//        dataPerda = dataPerda.plus(Constantes.LONG_UM, ChronoUnit.MONTHS);
//        List<FeriadoDTO> feriados = buscaFeriados(dataPerda);
//        return checaFeriado(dataPerda, feriados);
//    }

//    private List<FeriadoDTO> buscaFeriados(LocalDate data){
//        HashMap<String,Object > parmetros = new HashMap<>();
//        parmetros.put("ano",data.getYear());
//        parmetros.put("token",calendarioToken);
//        parmetros.put("json",true);
//        return Arrays.stream(restTemplate.getForObject(calendarioUrl, FeriadoDTO[].class, parmetros)).filter(item-> Constantes.FERIADO_NACIONAL.equals(item.getType_code())).collect(Collectors.toList());
//    }
//
//
//
////
//    public LocalDate getPrimeiroDiaUtilMes(LocalDate data) {
//        List<FeriadoDTO> feriados = buscaFeriados(data);
//        return checaFeriado(data.withDayOfMonth(Constantes.INT_UM), feriados);
//    }
//
//    public LocalDate getUltimoDiaUtilMes(LocalDate dataPerda) {
//        List<FeriadoDTO> feriados = buscaFeriados(dataPerda);
//        return checatUltimoDiaUtilMes(dataPerda, feriados);
//    }
//
//    private LocalDate checatUltimoDiaUtilMes(LocalDate data, List<FeriadoDTO> feriados) {
//        List<LocalDate> datasFeriados = feriados.stream().map(item -> LocalDate.parse(item.getDate(), DateTimeFormatter.ofPattern(Constantes.PADRAO_DATA_BR))).collect(Collectors.toList());
//        while (!validaData(data, datasFeriados)) {
//            data = data.minusDays(Constantes.LONG_UM);
//        }
//        return data;
//    }
//
//    private LocalDate checaFeriado(LocalDate data, List<FeriadoDTO> feriados) {
//        List<LocalDate> datasFeriados = feriados.stream().map(item -> LocalDate.parse(item.getDate(), DateTimeFormatter.ofPattern(Constantes.PADRAO_DATA_BR))).collect(Collectors.toList());
//        while (!validaData(data, datasFeriados)) {
//            data = data.plusDays(Constantes.LONG_UM);
//        }
//        return data;
//    }
//
//    private boolean validaData(LocalDate data, List<LocalDate> datasFeriados) {
//        return !datasFeriados.contains(data) && data.getDayOfWeek() != DayOfWeek.SATURDAY && data.getDayOfWeek() != DayOfWeek.SUNDAY;
//    }
//
//    private List<FeriadoDTO> buscaFeriados(LocalDate data){
//        HashMap<String,Object > parmetros = new HashMap<>();
//        parmetros.put("ano",data.getYear());
//        parmetros.put("token",calendarioToken);
//        parmetros.put("json",true);
//        return Arrays.stream(restTemplate.getForObject(calendarioUrl, FeriadoDTO[].class, parmetros)).filter(item-> Constantes.FERIADO_NACIONAL.equals(item.getType_code())).collect(Collectors.toList());
//    }
//}











//import com.mmoura.monitoracarteiraapi.web.dto.AtivoDTO;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.util.UriComponents;
//import org.springframework.web.util.UriComponentsBuilder;
//
//@Service
//@Transactional
//@Slf4j
//@RequiredArgsConstructor
//public class AtivoService {
//
////    private final AtivoMapper ativoMapper;
//
//    public void bucarAtivo() {
//        String url = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=IBM&apikey=demo";
//
//        RestTemplate template = new RestTemplate();
//
//        UriComponents uri = UriComponentsBuilder.newInstance()
//            .scheme("https")
//            .host("www.alphavantage.co")
//            .path("query?")
//            .queryParam("function", "TIME_SERIES_DAILY")
//            .queryParam("symbol","IBM")
//            .queryParam("apikey","demo")
//            .build();
//
//        template.getForEntity(uri.toUriString(), AtivoDTO.class);
//
//
//    }
//
//}
