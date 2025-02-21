package com.saludSystem.dtos.configuration.TipoDocumento;

import lombok.Data;

import java.util.UUID;

@Data
public class ActualizarTipoDocumentoDTO {

    private UUID hospitalId;

    private UUID userId;

    private UUID tDocumentoId;

    private String tipoComprobante;

    private String serie;

    private Integer inicio;

    private Integer fin;

    private Integer correlativoActual;

    private Integer estado;

}