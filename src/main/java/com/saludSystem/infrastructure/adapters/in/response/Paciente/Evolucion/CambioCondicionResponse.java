package com.saludSystem.infrastructure.adapters.in.response.Paciente.Evolucion;

import com.saludSystem.application.dtos.Paciente.GET.Evolucion.CambioCondicionDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class CambioCondicionResponse {

    @Schema(description = "Lista de registros para el cambio de condicion em la evolucion del paciente")
    private List<CambioCondicionDTO> data;

    @Schema(description = "Total de registros para el cambio de condicion em la evolucion del paciente", example = "0")
    private long totalData;

}