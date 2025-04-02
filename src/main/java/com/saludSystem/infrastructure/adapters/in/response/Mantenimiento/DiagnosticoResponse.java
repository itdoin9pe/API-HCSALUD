package com.saludSystem.infrastructure.adapters.in.response.Mantenimiento;

import com.saludSystem.application.dtos.Mantenimiento.GET.DiagnosticoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DiagnosticoResponse {

    @Schema(description = "Lista de Diagnosticos")
    private List<DiagnosticoDTO> data;

    @Schema(description = "Numero total de Diagnosticos registrados", example = "0")
    private long totalData;

}