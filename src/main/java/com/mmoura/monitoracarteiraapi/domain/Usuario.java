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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_USUARIO")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TB_USUARIO")
    @SequenceGenerator(name = "SEQ_TB_USUARIO", sequenceName = "SEQ_TB_USUARIO", allocationSize = 1)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "TX_NOME", nullable = false)
    private String noNome;

    @Column(name = "TX_CPF", nullable = false)
    private String nuCpf;

    @Column(name = "TX_SEXO")
    private String noSexo;

    @Column(name = "DT_NASCIMENTO", nullable = false)
    private LocalDate dtNascimento;

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


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.ALL,
            })
    @JoinTable(name = "TB_USUARIO_CORRETORA",
            joinColumns = {@JoinColumn(name = "ID_USUARIO")},
            inverseJoinColumns = {@JoinColumn(name = "ID_CORRETORA")})
    private List<Corretora> corretoras = new ArrayList();


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usuario")
    private List<Negociacao> negociacoes = new ArrayList<>();

}
