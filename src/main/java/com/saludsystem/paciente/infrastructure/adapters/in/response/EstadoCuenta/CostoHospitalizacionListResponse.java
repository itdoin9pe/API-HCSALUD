package com.saludsystem.paciente.infrastructure.adapters.in.response.EstadoCuenta;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class CostoHospitalizacionListResponse {

    @Schema(description = "Lista de registros para el costo de hopitalizacion del paciente")
    private List<com.saludsystem.paciente.application.dto.res.historialclinico.estadocuenta.CostoHospitalizacionResponse> data;

    @Schema(description = "Total de registros para el costo de hospitalizacion del paciente", example = "0")
    private long totalData;

}