package com.saludsystem.submodules.mantenimiento.dtos.get;

import com.saludsystem.submodules.mantenimiento.dtos.post.CrearEnfermedadDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class EnfermedadDTO extends CrearEnfermedadDTO {
    private String enfermedadId;
}