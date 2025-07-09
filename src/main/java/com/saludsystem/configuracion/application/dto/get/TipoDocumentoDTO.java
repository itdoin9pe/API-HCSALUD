package com.saludsystem.configuracion.application.dto.get;

import com.saludsystem.configuracion.application.dto.post.CrearTipoDocumentoDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class TipoDocumentoDTO extends CrearTipoDocumentoDTO {
    private UUID tDocumentoId;
}