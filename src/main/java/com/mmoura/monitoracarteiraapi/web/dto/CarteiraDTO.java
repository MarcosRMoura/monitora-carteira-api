package com.mmoura.monitoracarteiraapi.web.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;


@Getter
@Setter
@Data
public class CarteiraDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String noNome;
    private LocalDate dtInicio;
    private LocalDate dtFim;
    private BigDecimal vlCarteira;

}
