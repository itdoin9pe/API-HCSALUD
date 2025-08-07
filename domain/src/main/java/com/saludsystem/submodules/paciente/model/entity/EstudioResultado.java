package com.saludsystem.submodules.paciente.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EstudioResultado {

    private Long id;
    private String reporteTexto;
    private String urlImg;
    private Long estudioMedicoId;

}
