package com.mmoura.monitoracarteiraapi.web.dto;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;


@Getter
@Setter
public class AtivoApiDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<AtivoDTO> bestMatches;

}
