package com.saludsystem.infrastructure.adapters.in.response.paciente.Evolucion;

import com.saludsystem.application.dtos.paciente.get.evolucion.CambioCondicionDTO;
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