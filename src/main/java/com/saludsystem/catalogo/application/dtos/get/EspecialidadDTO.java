package com.saludsystem.catalogo.application.dtos.get;

import com.saludsystem.catalogo.application.dtos.post.CrearEspecialidadDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class EspecialidadDTO extends CrearEspecialidadDTO {
    private UUID especialidadId;
}