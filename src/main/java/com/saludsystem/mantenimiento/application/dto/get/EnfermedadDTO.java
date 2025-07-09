package com.saludsystem.mantenimiento.application.dto.get;

import com.saludsystem.mantenimiento.application.dto.post.CrearEnfermedadDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class EnfermedadDTO extends CrearEnfermedadDTO {
    private String enfermedadId;
}