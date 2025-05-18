package com.saludSystem.infrastructure.adapters.in.response.Paciente.EstadoCuenta;

import com.saludSystem.application.dtos.Paciente.GET.EstadoCuenta.CostoHospitalizacionDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class CostoHospitalizacionResponse {

    @Schema(description = "Lista de registros para el costo de hopitalizacion del paciente")
    private List<CostoHospitalizacionDTO> data;

    @Schema(description = "Total de registros para el costo de hospitalizacion del paciente", example = "0")
    private long totalData;

}