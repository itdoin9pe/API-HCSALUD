package com.saludsystem.submodules.paciente.model.dtos.command;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class CrearEstudioMedicoDTO {

    private String tipo;

    private String descripcion;

    private LocalDateTime requestAt;

    private LocalDateTime performedAt;

    private String estado;

    private UUID pacienteId;

    private UUID doctorId;

    @Schema(example = "Integer")
    private Long pacienteEstudioResultadoId;

}