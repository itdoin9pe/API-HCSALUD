package com.saludsystem.paciente.infrastructure.adapters.in.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PacienteListResponse {

    @Schema(description = "Lista de Pacientes")
    private List<com.saludsystem.paciente.application.dto.res.PacienteResponse> data;

    @Schema(description = "Número total de Paciemtes", example = "0")
    private long totalData;

}