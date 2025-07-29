package com.saludsystem.submodules.configuracion.dtos.get;

import com.saludsystem.submodules.configuracion.dtos.post.CrearTipoDocumentoDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class TipoDocumentoDTO extends CrearTipoDocumentoDTO {
    private UUID tDocumentoId;
}