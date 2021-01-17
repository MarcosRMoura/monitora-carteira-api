package com.mmoura.monitoracarteiraapi.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


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

    @Column(name = "TX_SEXO", nullable = false)
    private String noSexo;

    @Column(name = "DT_NASCIMENTO", nullable = false)
    private String dtNascimento;

    @Column(name = "TX_ENDERECO")
    private String noEndereco;

    @Column(name = "NU_ENDERECO")
    private String nuEndereco;

    @Column(name = "TX_BAIRRO")
    private String noBairro;

    @Column(name = "TX_CIDADE")
    private String noCidade;

    @Column(name = "NU_CEP")
    private String nuCep;

    @Column(name = "TX_ESTADO")
    private String noEstado;

    @Column(name = "TX_PAIS")
    private String noPais;

    @Column(name = "TX_TELEFONE")
    private String nuTelefone;

    @Column(name = "TX_EMAIL")
    private String noEmail;


//    @Column(name = "ID_USUARIO", nullable = false)
//    private Long idUsuario;
//    @Column(name = "ID_CORRETORA", nullable = false)
//    private Long idCorretora;
}
