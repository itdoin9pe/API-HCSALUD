package com.saludsystem.application.paciente.dtos.get.historialclinico.evolucion;

import com.saludsystem.application.dto.post.historialclinico.evolucion.CrearAltaMedicaDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AltaMedicaDTO extends CrearAltaMedicaDTO {

    @Schema(example = "Integer")
    private Long evolucionAltaMedicaId;

}