package com.saludSystem.dtos.configuration.TipoDocumento;

import lombok.Data;

@Data
public class CrearTipoDocumentoDTO {

    private String tipoComprobante;

    private String serie;

    private Integer inicio;

    private Integer fin;

    private Integer correlativoActual;

    private Integer estado;

}