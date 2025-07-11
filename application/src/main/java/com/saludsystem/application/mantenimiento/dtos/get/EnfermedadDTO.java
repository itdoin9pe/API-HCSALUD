package com.saludsystem.application.mantenimiento.dtos.get;

import com.saludsystem.application.dto.post.CrearEnfermedadDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class EnfermedadDTO extends CrearEnfermedadDTO {
    private String enfermedadId;
}