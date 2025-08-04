package com.saludsystem.submodules.operaciones.model.dtos;

import com.saludsystem.submodules.operaciones.model.dtos.command.PresentacionCreateCommand;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class PresentacionDTO extends PresentacionCreateCommand {

    private UUID presentacionId;

    public PresentacionDTO(UUID id, String nombre, Integer estado) {
        this.setPresentacionId(id);
        this.setNombre(nombre);
        this.setEstado(estado);
    }
}