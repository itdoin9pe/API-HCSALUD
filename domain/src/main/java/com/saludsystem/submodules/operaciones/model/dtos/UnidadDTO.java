package com.saludsystem.submodules.operaciones.model.dtos;

import com.saludsystem.submodules.operaciones.model.dtos.command.UnidadCreateCommand;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class UnidadDTO extends UnidadCreateCommand {

    private UUID unidadId;

    public UnidadDTO(UUID unidadId, String nombre, String siglas, String descripcion, Integer estado) {

        this.setUnidadId(unidadId);
        this.setNombre(nombre);
        this.setSiglas(siglas);
        this.setDescripcion(descripcion);
        this.setEstado(estado);

    }

}