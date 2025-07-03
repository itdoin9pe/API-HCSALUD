package com.saludsystem.application.dtos.paciente.put.historialclinico;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class ActualizarPacienteAlergiaDTO {

    private UUID hospitalId;

    private UUID userId;

    private UUID pacienteAlergiaId;

    private UUID pacienteId;

    private UUID alergiaId;

    private String observacion;

    @Schema(example = "0")
    private Integer estado;

}