package com.saludsystem.paciente.infrastructure.adapters.in.response.EstadoCuenta;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class DetalleMedicamentoEstudioListResponse {

    @Schema(description = "Lista de estudios para el detalle de medicamentos")
    private List<com.saludsystem.paciente.application.dto.res.historialclinico.estadocuenta.DetalleMedicamentoEstudioResponse> data;

    @Schema(description = "Total de estudios para el detalle de medicamentos", example = "0")
    private long totalData;

}