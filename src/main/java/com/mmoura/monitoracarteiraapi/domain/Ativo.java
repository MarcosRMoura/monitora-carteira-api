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
@Table(name = "TB_ATIVO")
public class Ativo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TB_ATIVO")
    @SequenceGenerator(name = "SEQ_TB_ATIVO", sequenceName = "SEQ_TB_ATIVO", allocationSize = 1)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "TX_SIGLA", nullable = false)
    private String noSigla;

    @Column(name = "TX_NOME", nullable = false)
    private String noNome;

    @Column(name = "VL_VALOR_ATUALIZADO")
    private BigDecimal vlValorAtualizado;

    @Column(name = "DT_ATUALIZACAO")
    private LocalDate dtAtualizada;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ativo")
    private List<Operacao> operacoes = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ativo")
    private List<Negociacao> negociacoes = new ArrayList<>();
}
