package com.saludsystem.submodules.operaciones.dtos.query;

import com.saludsystem.submodules.operaciones.dtos.command.CrearTipoMaterialDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class TipoMaterialDTO extends CrearTipoMaterialDTO {

    private UUID tipoMaterialId;

}