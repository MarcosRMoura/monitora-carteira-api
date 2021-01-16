package com.mmoura.monitoracarteiraapi.domain;

import com.mmoura.monitoracarteiraapi.web.dto.AtivoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AtivoApi implements Serializable {

    private static final long serialVersionUID = 3248189030448292002L;

    private List<Ativo> bestMatches;
}
