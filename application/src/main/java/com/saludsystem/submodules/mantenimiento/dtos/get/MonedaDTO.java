package com.saludsystem.submodules.mantenimiento.dtos.get;

import com.saludsystem.submodules.mantenimiento.dtos.post.CrearMonedaDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class MonedaDTO extends CrearMonedaDTO {

    private UUID monedaId;

    public MonedaDTO(UUID id, String descripcion, Integer estado) {
        this.setMonedaId(id);
        this.setDescripcion(descripcion);
        this.setEstado(estado);
    }
}