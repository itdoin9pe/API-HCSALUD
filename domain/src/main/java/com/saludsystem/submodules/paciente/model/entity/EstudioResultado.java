package com.saludsystem.submodules.paciente.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EstudioResultado {
    private Long id;
    private String reporteTexto;
    private String urlImg;
    private Long estudioMedicoId;

    public EstudioResultado(Long id, String reporteTexto, String urlImg, Long estudioMedicoId) {
    	this.id=id;
    	this.reporteTexto=reporteTexto;
    	this.urlImg=urlImg;
    	this.estudioMedicoId=estudioMedicoId;
    }
}