package com.saludsystem.infrastructure.adapters.in.response.paciente.Evolucion;

import com.saludsystem.application.dtos.paciente.get.evolucion.EvolucionDTO;
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