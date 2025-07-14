package com.saludsystem.submodules.operaciones.dtos.get;

import com.saludsystem.submodules.operaciones.dtos.post.CrearTipoMaterialDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class TipoMaterialDTO extends CrearTipoMaterialDTO {

    private UUID tipoMaterialId;

}