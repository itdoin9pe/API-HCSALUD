package com.saludsystem.paciente.infrastructure.adapters.in.response.Tratamiento;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter @Setter
public class ProcedimientoListResponse {

    @Schema(description = "Lita de procedimientos para tratamiento del paciente")
    private List<com.saludsystem.paciente.application.dto.res.historialclinico.tratamiento.ProcedimientoResponse> data;

    @Schema(description = "Total de procedimientos para tratamiento del paciente", example = "0")
    private long totalData;

}