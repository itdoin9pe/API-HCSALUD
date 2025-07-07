package com.saludsystem.cita.infrastructure.adapters.in.response;

import com.saludsystem.cita.application.dto.res.CitaDTO;
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