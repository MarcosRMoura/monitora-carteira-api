package com.mmoura.monitoracarteiraapi.web.dto;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
public class UsuarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String noNome;
    private String nuCpf;
    private String noSexo;
    private String dtNascimento;
    private String noEndereco;
    private String nuEndereco;
    private String noBairro;
    private String noCidade;
    private String nuCep;
    private String noEstado;
    private String noPais;
    private String nuTelefone;
    private String noEmail;

}
