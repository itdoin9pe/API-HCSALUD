package com.saludsystem.submodules.principal.model.dtos.get;

import com.saludsystem.submodules.principal.model.dtos.post.CrearAseguradoraDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class AseguradoraDTO extends CrearAseguradoraDTO {

    private UUID aseguradoraId;

    public AseguradoraDTO(UUID aseguradoraId, String descripcion, Integer estado) {
        this.setAseguradoraId(aseguradoraId);
        this.setDescripcion(descripcion);
        this.setEstado(estado);
    }
}