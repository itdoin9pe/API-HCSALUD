package com.saludsystem.paciente.application.dto.get.historialclinico.evolucion;

import com.saludsystem.paciente.application.dto.post.historialclinico.evolucion.CrearAltaMedicaDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AltaMedicaDTO extends CrearAltaMedicaDTO {

    @Schema(example = "Integer")
    private Long evolucionAltaMedicaId;

}