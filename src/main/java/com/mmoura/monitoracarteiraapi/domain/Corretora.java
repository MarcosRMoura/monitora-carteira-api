package com.mmoura.monitoracarteiraapi.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_CORRETORA")
public class Corretora implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TB_CORRETORA")
    @SequenceGenerator(name = "SEQ_TB_CORRETORA", sequenceName = "SEQ_TB_CORRETORA", allocationSize = 1)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "TX_NOME", nullable = false)
    private String noNome;

    @Column(name = "TX_CNPJ", nullable = false)
    private String nuCnpj;

    @Column(name = "TX_ENDERECO", nullable = false)
    private String noEndereco;

    @Column(name = "NU_ENDERECO", nullable = false)
    private String nuEndereco;

    @Column(name = "TX_BAIRRO", nullable = false)
    private String noBairro;

    @Column(name = "TX_CIDADE", nullable = false)
    private String noCidade;

    @Column(name = "NU_CEP", nullable = false)
    private String nuCep;

    @Column(name = "TX_ESTADO", nullable = false)
    private String noEstado;

    @Column(name = "TX_PAIS", nullable = false)
    private String noPais;

    @Column(name = "TX_TELEFONE", nullable = false)
    private String nuTelefone;

    @Column(name = "TX_EMAIL", nullable = false)
    private String noEmail;

    @Column(name = "TX_SITE", nullable = false)
    private String noSite;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "corretora")
    private List<Negociacao> negociacoes = new ArrayList<>();

}
