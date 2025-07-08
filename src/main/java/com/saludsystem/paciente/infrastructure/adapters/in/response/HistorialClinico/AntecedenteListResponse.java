package com.saludsystem.paciente.infrastructure.adapters.in.response.HistorialClinico;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class AntecedenteListResponse {

    @Schema(description = "Lista de antecedentes")
    private List<com.saludsystem.paciente.application.dto.res.historialclinico.AntecedenteResponse> data;

    @Schema(description = "Total de registros para antecedentes", example = "0")
    private long totalData;

}