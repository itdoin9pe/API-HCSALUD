package com.saludsystem.paciente.infrastructure.adapters.in.response.HistorialClinico;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ConsultaListResponse {

    @Schema(description = "Registro de consultas del paciente")
    private List<com.saludsystem.paciente.application.dto.res.historialclinico.ConsultaResponse> data;

    @Schema(description = "Registros totales de consultas del paciente", example = "0")
    private long totalData;

}