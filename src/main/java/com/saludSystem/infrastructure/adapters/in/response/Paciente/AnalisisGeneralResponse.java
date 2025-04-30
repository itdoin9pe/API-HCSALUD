package com.saludSystem.infrastructure.adapters.in.response.Paciente;

import com.saludSystem.application.dtos.Paciente.GET.AnalisisGeneralDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class AnalisisGeneralResponse {

    @Schema(description = "Lista de registros de analisis generales de pacientes")
    private List<AnalisisGeneralDTO> data;

    @Schema(description = "Total de registros de analisis generales de pacientes", example = "0")
    private long totalData;

}