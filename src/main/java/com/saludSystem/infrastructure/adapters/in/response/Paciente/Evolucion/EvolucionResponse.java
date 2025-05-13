package com.saludSystem.infrastructure.adapters.in.response.Paciente.Evolucion;

import com.saludSystem.application.dtos.Paciente.GET.Evolucion.EvolucionDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter @Setter
public class EvolucionResponse {

    @Schema(description = "Lista de evoluciones del paciente")
    private List<EvolucionDTO> data;

    @Schema(description = "Total de registrod de las evoluciones del paciente", example = "0")
    private long totalData;

}