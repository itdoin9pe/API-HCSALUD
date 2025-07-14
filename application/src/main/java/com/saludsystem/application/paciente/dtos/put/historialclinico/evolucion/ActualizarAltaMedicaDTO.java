package com.saludsystem.application.paciente.dtos.put.historialclinico.evolucion;

import com.saludsystem.application.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
public class ActualizarAltaMedicaDTO extends BaseDTO {

    @Schema(example = "Integer")
    private Long evolucionAltaMedicaId;

    private LocalDateTime fecha;

    private String resumenFinal;

    private UUID pacienteEvolucionId;

}