package com.mmoura.monitoracarteiraapi.web.dto;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;


@Getter
@Setter
public class NegociacaoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String noTipoNegociacao;
    private Integer numContrato;
    private BigDecimal vlBruto;
    private BigDecimal vlTaxas;
    private BigDecimal vlLiquido;
    private String noResultado;
    private LocalDate dtInicioNegociacao;
    private LocalDate dtFimNegociacao;
    private BigDecimal vlEntrada;
    private BigDecimal vlSaida;
    private BigDecimal vlPrecoMedio;
    private Integer numQtdCompra;
    private Integer numQtdVenda;

}
