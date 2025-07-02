package com.saludSystem.infrastructure.adapters.in.response.Cita;

import com.saludSystem.application.dtos.Cita.GET.CitaDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class CitaResponse {

    @Schema(description = "Lista de registros de citas")
    private List<CitaDTO> data;

    @Schema(description = "Total de registros para citas", example = "0")
    private long totalData;

}