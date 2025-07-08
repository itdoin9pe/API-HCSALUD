package com.saludsystem.paciente.application.dto.req.historialclinico;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class PacienteAlergiaRequest {

    private UUID pacienteId;

    private UUID alergiaId;

    private String observacion;

    @Schema(example = "0")
    private Integer estado;

}