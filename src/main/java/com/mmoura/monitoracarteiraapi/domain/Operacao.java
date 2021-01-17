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
@Table(name = "TB_OPERACAO")
public class Operacao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TB_OPERACAO")
    @SequenceGenerator(name = "SEQ_TB_OPERACAO", sequenceName = "SEQ_TB_OPERACAO", allocationSize = 1)
    @Column(name = "ID", nullable = false)
    private Long id;

//    @Column(name = "TX_ATIVO", nullable = false)
//    private String noAtivo;

    @Column(name = "TX_OPERACAO_TIPO_BASE", nullable = false)
    private String noNegociacaoBase;

    @Column(name = "VL_OPERACAO", nullable = false)
    private BigDecimal vlCompra;

    @Column(name = "NUM_CONTRATO", nullable = false)
    private Integer numContrato;

    @Column(name = "VL_BRUTO")
    private BigDecimal vlBruto;

    @Column(name = "VL_TAXAS")
    private BigDecimal vlTaxas;

    @Column(name = "VL_LIQUIDO")
    private BigDecimal vlLiquido;

    @Column(name = "DT_OPERACAO", nullable = false)
    private LocalDate dtOperacao;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ATIVO", referencedColumnName = "ID")
    private Ativo ativo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_NEGOCIACAO", referencedColumnName = "ID")
    private Negociacao negociacao;

}
