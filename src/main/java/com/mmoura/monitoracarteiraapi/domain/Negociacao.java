package com.mmoura.monitoracarteiraapi.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


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

    @Column(name = "TX_TIPO_NEGOCIACAO_BASE", nullable = false)
    private String noTipoNegociacaoBase;

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

    @Column(name = "TX_RESULTADO")
    private String noResultado;

    @Column(name = "DT_INICIO_NEGOCIACAO", nullable = false)
    private LocalDate dtInicioNegociacao;

    @Column(name = "DT_FIM_NEGOCIACAO")
    private LocalDate dtFimNegociacao;

    @Column(name = "VL_ENTRADA", nullable = false)
    private BigDecimal vlEntrada;

    @Column(name = "VL_SAIDA")
    private BigDecimal vlSaida;

    @Column(name = "VL_PRECO_MEDIO", nullable = false)
    private BigDecimal vlPrecoMedio;

    @Column(name = "NUM_QTD_COMPRA")
    private Integer numQtdCompra;

    @Column(name = "NUM_QTD_VENDA")
    private Integer numQtdVenda;

    @Column(name = "NO_SIGLA")
    private String noSigla;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CORRETORA", referencedColumnName = "ID")
    private Corretora corretora;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ATIVO", referencedColumnName = "ID")
    private Ativo ativo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CARTEIRA", referencedColumnName = "ID")
    private Carteira carteira;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "negociacao")
    private List<Operacao> operacoes = new ArrayList<>();

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "negociacao")
//    private List<Carteira> carteiras = new ArrayList<>();

}
