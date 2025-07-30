package com.saludsystem.submodules.mantenimiento.dtos.get;

import com.saludsystem.submodules.mantenimiento.dtos.post.CrearTipoTarjetaDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class TipoTarjetaDTO extends CrearTipoTarjetaDTO {

    private UUID tipoTarjetaId;

    public TipoTarjetaDTO(UUID tipoTarjetaId, String descripcion, Integer estado) {
        this.setTipoTarjetaId(tipoTarjetaId);
        this.setDescripcion(descripcion);
        this.setEstado(estado);
    }
}