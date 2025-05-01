package com.saludSystem.infrastructure.adapters.in.response.Paciente;

import com.saludSystem.application.dtos.Paciente.GET.AnalisisFacialDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class AnalisisFacialResponse {

    @Schema(description = "Lista de registros para analisis faciales")
    private List<AnalisisFacialDTO> data;

    @Schema(description = "Total de registros para analisis faciales", example = "0")
    private long totalData;

}