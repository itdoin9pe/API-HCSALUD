package com.saludSystem.dtos.catalago.Especialidad;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class ActualizarEspecialidadDTO extends CrearEspecialidadDTO{
    private UUID hospitalId;
    private UUID especialidadId;
}
