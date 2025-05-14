package com.saludSystem.infrastructure.adapters.in.response.Paciente.Tratamiento;

import com.saludSystem.application.dtos.Paciente.GET.Tratamiento.CostoTratamientoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class CostoTratamientoResponse {

    @Schema(description = "Lista de los costos para tratamiento del paciente")
    private List<CostoTratamientoDTO> data;

    @Schema(description = "Total de los costos para tratamiento del paciente", example = "0")
    private long totalData;

}