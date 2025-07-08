package com.saludsystem.paciente.infrastructure.adapters.in.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter @Setter
public class MedicamentoRecetadoListResponse {

    @Schema(description = "Lista de medicamentos recetados registrados")
    private List<com.saludsystem.paciente.application.dto.res.MedicamentoRecetadoResponse> data;

    @Schema(description = "Total de medicamentos recetados registrados", example = "0")
    private long totalData;

}