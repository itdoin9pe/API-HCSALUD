package com.saludsystem.submodules.operaciones.model.dtos;

import com.saludsystem.submodules.operaciones.model.dtos.command.TipoMaterialCreateCommand;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class TipoMaterialDTO extends TipoMaterialCreateCommand {

    private UUID tipoMaterialId;

    public TipoMaterialDTO(UUID tipoMaterialId, String nombre, String descripcion, Integer estado) {

        this.setTipoMaterialId(tipoMaterialId);
        this.setNombre(nombre);
        this.setDescripcion(descripcion);
        this.setEstado(estado);

    }

}