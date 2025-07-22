package com.saludsystem.submodules.mantenimiento.model.dtos.get;

import com.saludsystem.submodules.mantenimiento.model.dtos.post.CrearCajaDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class CajaDTO extends CrearCajaDTO {
    private UUID cajaId;

    public CajaDTO(UUID id, String nombre, Integer estado) {
        this.setCajaId(id);
        this.setNombre(nombre);
        this.setEstado(estado);
    }
}