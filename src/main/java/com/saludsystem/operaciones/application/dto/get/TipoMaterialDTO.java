package com.saludsystem.operaciones.application.dto.get;

import com.saludsystem.operaciones.application.dto.post.CrearTipoMaterialDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class TipoMaterialDTO extends CrearTipoMaterialDTO {

    private UUID tipoMaterialId;

}