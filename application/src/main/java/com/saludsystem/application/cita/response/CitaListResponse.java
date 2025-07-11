package com.saludsystem.application.cita.response;

import com.saludsystem.cita.application.dto.post.CrearCitaDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class CitaListResponse {

    @Schema(description = "Lista de registros de citas")
    private List<CrearCitaDTO> data;

    @Schema(description = "Total de registros para citas", example = "0")
    private long totalData;

}