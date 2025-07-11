package com.saludsystem.application.configuracion.dtos.get;

import com.configuracion.application.dto.post.CrearTipoDocumentoDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class TipoDocumentoDTO extends CrearTipoDocumentoDTO {
    private UUID tDocumentoId;
}