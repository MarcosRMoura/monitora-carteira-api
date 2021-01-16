package com.mmoura.monitoracarteiraapi.domain;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_ativo")
public class Ativo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TB_ATIVO")
    @SequenceGenerator(name = "SEQ_TB_ATIVO", sequenceName = "SEQ_TB_ATIVO", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "tx_sigla", nullable = false)
    private String noSigla;

    @Column(name = "tx_nome", nullable = false)
    private String noNome;
}
