package com.saludSystem.dtos.configuration.Sede;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class ActualizarSedeDTO extends CrearSedeDTO {
    private UUID sedeId;
    private UUID hospitalId;
}
