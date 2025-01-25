package com.saludSystem.dtos.Generals.Estudio;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class ActualizarEstudioDTO extends CrearEstudioDTO{
    private UUID hospitalId;

    @Schema(description = "ID de estudios educativos", example = "Integer")
    private UUID estudioId;
}
