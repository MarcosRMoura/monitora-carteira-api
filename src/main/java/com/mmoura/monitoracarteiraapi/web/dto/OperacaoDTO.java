package com.mmoura.monitoracarteiraapi.web.dto;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;


@Getter
@Setter
public class OperacaoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String noAtivo;
    private String noNegociacao;
    private BigDecimal vlCompra;
    private Integer nuContrato;
    private BigDecimal vlBruto;
    private BigDecimal vlTaxas;
    private BigDecimal vlLiquido;
    private LocalDate dtOperacao;

}
