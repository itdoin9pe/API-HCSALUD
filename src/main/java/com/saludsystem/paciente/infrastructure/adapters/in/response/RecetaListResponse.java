package com.saludsystem.paciente.infrastructure.adapters.in.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class RecetaListResponse {

    @Schema(description = "Lista de registros para recetas del paciente")
    private List<com.saludsystem.paciente.application.dto.res.RecetaResponse> data;

    @Schema(description = "Total de registros para recetas del paciente", example = "0")
    private long totalData;

}