package com.saludsystem.paciente.infrastructure.adapters.in.response.HistorialClinico;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class PacienteAlergiaListResponse {

    @Schema(description = "Lista de pacientes con alergias")
    private List<com.saludsystem.paciente.application.dto.res.historialclinico.PacienteAlergiaResponse> data;

    @Schema(description = "Total de paciente con alergias", example = "0")
    private long totalData;

}