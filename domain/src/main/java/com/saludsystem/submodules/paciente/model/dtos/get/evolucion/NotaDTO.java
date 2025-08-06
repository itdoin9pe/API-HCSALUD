package com.saludsystem.submodules.paciente.model.dtos.get.evolucion;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class NotaDTO {

    @Schema(description = "ID de la evolucion del paciente", example = "Integer")
    private Long pacienteEvolucionNotaId;

    private LocalDateTime fecha;

    private String tipo;

    private String contenido;

    private UUID pacienteEvolucionId;

}