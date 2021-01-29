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
@Table(name = "TB_CARTEIRA")
public class Carteira implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TB_CARTEIRA")
    @SequenceGenerator(name = "SEQ_TB_CARTEIRA", sequenceName = "SEQ_TB_CARTEIRA", allocationSize = 1)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "TX_NOME", nullable = false)
    private String noNome;

    @Column(name = "DT_INICIO", nullable = false)
    private LocalDate dtInicio;

    @Column(name = "DT_FIM")
    private LocalDate dtFim;

    @Column(name = "VL_CARTEIRA")
    private BigDecimal vlCarteira;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "ID_NEGOCIACAO", referencedColumnName = "ID")
//    private Negociacao negociacao;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "carteira")
    private List<Negociacao> negociacoes = new ArrayList<>();

}
