package com.saludsystem.submodules.configuracion.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
@AllArgsConstructor
public class TipoDocumento {
    private UUID id;
    private String tipoComprobante;
    private String serie;
    private Integer inicio;
    private Integer fin;
    private Integer correlativoActual;
    private Integer estado;
}