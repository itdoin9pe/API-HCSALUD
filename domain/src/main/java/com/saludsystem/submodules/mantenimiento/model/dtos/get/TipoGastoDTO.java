package com.saludsystem.submodules.mantenimiento.model.dtos.get;

import com.saludsystem.submodules.mantenimiento.model.dtos.post.CrearTipoGastoDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class TipoGastoDTO extends CrearTipoGastoDTO {

    private UUID conceptoGastoId;

    public TipoGastoDTO(UUID conceptoGastoId, String nombre, Integer estado) {
        this.setConceptoGastoId(conceptoGastoId);
        this.setNombre(nombre);
        this.setEstado(estado);
    }
}