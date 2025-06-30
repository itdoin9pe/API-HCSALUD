package com.saludSystem.application.dtos.Paciente.GET.HistorialClinico;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class PacienteAlergiaDTO {

    private UUID pacienteAlergiaId;

    private UUID pacienteId;

    private UUID alergiaId;

    private String observacion;

    @Schema(example = "0")
    private Integer estado;

}