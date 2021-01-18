package com.mmoura.monitoracarteiraapi.web.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;


@Getter
@Setter
public class AtivoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @JsonProperty("1. symbol")
    private String noSigla;

    @JsonProperty("2. name")
    private String noNome;

    @JsonProperty("05. price")
    private BigDecimal vlValorAtualizado;

    @JsonProperty("07. latest trading day")
    private LocalDate dtAtualizada;


//    private List<Operacao> operacoes = new ArrayList<>();
}
