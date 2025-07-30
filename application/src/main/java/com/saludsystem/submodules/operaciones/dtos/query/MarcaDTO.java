package com.saludsystem.submodules.operaciones.dtos.query;

import com.saludsystem.submodules.operaciones.dtos.command.CrearMarcaDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class MarcaDTO extends CrearMarcaDTO {

    private UUID marcaId;

    public MarcaDTO(UUID id, String nombre, Integer estado) {
        this.setMarcaId(id);
        this.setNombre(nombre);
        this.setEstado(estado);
    }
}