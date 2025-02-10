package com.saludSystem.dtos.Generals.Aseguradora;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class ActualizarAseguradoraDTO extends CrearAseguradoraDTO {
    private UUID hospitalId;
    private UUID userId;
    private UUID aseguradoraId;
}
