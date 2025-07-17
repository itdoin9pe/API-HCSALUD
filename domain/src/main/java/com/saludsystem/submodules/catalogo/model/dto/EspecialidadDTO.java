package com.saludsystem.submodules.catalogo.model.dto;

import com.saludsystem.submodules.catalogo.model.dto.command.CrearEspecialidadDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class EspecialidadDTO extends CrearEspecialidadDTO {
    private UUID especialidadId;

    public EspecialidadDTO(UUID id, String descripcion, String nombre, Integer estado) {
        this.setEspecialidadId(id);
        this.setDescripcion(descripcion);
        this.setNombre(nombre);
        this.setEstado(estado);
    }
}