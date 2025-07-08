package com.saludsystem.paciente.infrastructure.adapters.in.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class EstudioMedicoListResponse {

    @Schema(description = "Lista de registros para estudios medicos del paciente")
    private List<com.saludsystem.paciente.application.dto.res.EstudioMedicoResponse> data;

    @Schema(description = "Total de registros para estudios medicos del paciente", example = "0")
    private long totalData;

}