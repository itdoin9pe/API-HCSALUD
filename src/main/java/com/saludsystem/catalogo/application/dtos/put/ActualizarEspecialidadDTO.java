package com.saludsystem.catalogo.application.dtos.put;

import com.saludsystem.shared.application.dto.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
public class ActualizarEspecialidadDTO extends BaseDTO {
    private UUID especialidadId;
    private String nombre;

    private String descripcion;

    @Schema(description = "Estado de Especialidades (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;
}