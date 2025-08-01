package com.saludsystem.submodules.mantenimiento.model.dtos;

import com.saludsystem.submodules.mantenimiento.model.dtos.command.EnfermedadCreateCommand;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class EnfermedadDTO extends EnfermedadCreateCommand {
    private String enfermedadId;

    public EnfermedadDTO(String id, String descripcion, Integer estado) {
        this.setEnfermedadId(id);
        this.setDescripcion(descripcion);
        this.setEstado(estado);
    }
}