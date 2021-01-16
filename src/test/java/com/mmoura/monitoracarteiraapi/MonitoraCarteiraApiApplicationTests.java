package com.mmoura.monitoracarteiraapi;

import com.mmoura.monitoracarteiraapi.domain.Ativo;
import com.mmoura.monitoracarteiraapi.domain.AtivoApi;
import com.mmoura.monitoracarteiraapi.web.dto.AtivoApiDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;

@SpringBootTest
class MonitoraCarteiraApiApplicationTests {

    @Test
    void contextLoads() {
//        https://www.alphavantage.co/query?function=SYMBOL_SEARCH&keywords=embr&apikey=K95G5S0NF12WO331
        RestTemplate restTemplate = new RestTemplate();
        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("www.alphavantage.co")
                .path("query")
                .queryParam("function", "SYMBOL_SEARCH")
                .queryParam("keywords", "EMBR3.SAO")
                .queryParam("apikey", "K95G5S0NF12WO331")
                .build();
//                .scheme("https")
//                .host("www.alphavantage.co")
//                .path("query")
//                .queryParam("function", "TIME_SERIES_INTRADAY")
//                .queryParam("symbol", "EMBR3.SAO")
//                .queryParam("interval", "60min")
//                .build();

//        ResponseEntity<AtivoApi> entity = restTemplate.getForEntity(uri.toUriString(), AtivoApi.class);
        ResponseEntity<AtivoApiDTO> entity = restTemplate.getForEntity(uri.toUriString(), AtivoApiDTO.class);
//        System.out.println(Arrays.stream(entity.getBody()).filter(ativo -> ativo.getSymbol() == "EMBR3.SAO").findAny().get().getName());
//        System.out.println(entity.getBody().filter(ativo -> ativo.getSymbol() == "EMBR3.SAO").findAny().get().getSymbol());
        System.out.println(entity.getBody().getBestMatches().get(0).getNoNome());
//        System.out.println(entity.getBody().);
        System.out.println(entity.getBody().getBestMatches().get(0).toString());
//        System.out.println(entity.getBody());
    }

}
