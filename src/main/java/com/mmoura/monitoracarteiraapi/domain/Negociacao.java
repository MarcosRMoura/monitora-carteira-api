package com.mmoura.monitoracarteiraapi.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_NEGOCIACAO")
public class Negociacao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TB_NEGOCIACAO")
    @SequenceGenerator(name = "SEQ_TB_NEGOCIACAO", sequenceName = "SEQ_TB_NEGOCIACAO", allocationSize = 1)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "TX_TIPO_NEGOCIACAO", nullable = false)
    private String noTipoNegociacao;

    @Column(name = "NUM_CONTRATO", nullable = false)
    private Integer numContrato;

    @Column(name = "VL_BRUTO")
    private BigDecimal vlBruto;

    @Column(name = "VL_TAXAS")
    private BigDecimal vlTaxas;

    @Column(name = "VL_LIQUIDO")
    private BigDecimal vlLiquido;

    @Column(name = "TX_RESULTADO", nullable = false)
    private String noResultado;

    @Column(name = "DT_INICIO_NEGOCIACAO", nullable = false)
    private LocalDate dtInicioNegociacao;

    @Column(name = "DT_FIM_NEGOCIACAO", nullable = false)
    private LocalDate dtFimNegociacao;

    @Column(name = "VL_EMTRADA", nullable = false)
    private BigDecimal vlEntrada;

    @Column(name = "VL_SAIDA", nullable = false)
    private BigDecimal vlSaida;

    @Column(name = "VL_PRECO_MEDIO", nullable = false)
    private BigDecimal vlPrecoMedio;

    @Column(name = "NUM_QTD_COMPRA", nullable = false)
    private Integer numQtdCompra;

    @Column(name = "NUM_QTD_VENDA", nullable = false)
    private Integer numQtdVenda;


//    @Column(name = "ID_USUARIO", nullable = false)
//    private Long idUsuario;
//    ??? @Column(name = "ID_CORRETORA", nullable = false)
//    private Long idCorretora;
}
