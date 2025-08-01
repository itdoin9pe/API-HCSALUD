package com.saludsystem.submodules.paciente.dtos.put.historialclinico.evolucion;

import com.saludsystem.submodules.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
public class ActualizarNotaDTO extends BaseDTO {

    @Schema(example = "Integer")
    private Long pacienteEvolucionNotaId;

    private LocalDateTime fecha;

    private String tipo;

    private String contenido;

    private UUID pacienteEvolucionId;

}