package com.mmoura.monitoracarteiraapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
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
    private BigDecimal dtAtualizada;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "operacao")
    private List<Operacao> operacoes = new ArrayList<>();
}
