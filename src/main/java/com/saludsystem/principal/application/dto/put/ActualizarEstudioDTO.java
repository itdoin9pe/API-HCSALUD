package com.saludsystem.principal.application.dto.put;

import com.saludsystem.shared.application.dto.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
public class ActualizarEstudioDTO extends BaseDTO {

    private UUID estudioId;

    @Schema(description = "Descripción de estudio educativo", example = "string")
    private String descripcion;

}
