package com.saludSystem.infrastructure.adapters.in.response.Paciente.EstadoCuenta;

import com.saludSystem.application.dtos.Paciente.GET.EstadoCuenta.DetalleMedicamentoEstudioDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class DetalleMedicamentoEstudioResponse {

    @Schema(description = "Lista de estudios para el detalle de medicamentos")
    private List<DetalleMedicamentoEstudioDTO> data;

    @Schema(description = "Total de estudios para el detalle de medicamentos", example = "0")
    private long totalData;

}